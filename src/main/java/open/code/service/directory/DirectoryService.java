package open.code.service.directory;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import open.code.dto.directory_dto.DirectoryFilterDto;
import open.code.exception.directory_exception.DirectoryNotFoundException;
import open.code.exception.directory_exception.DirectoryTypeException;
import open.code.model.Directory;
import open.code.dto.directory_dto.DirectoryDto;
import open.code.repository.DirectoryRepository;
import open.code.repository.bnk_msg.BankMessageRepository;
import open.code.util.Constants;
import open.code.util.DirectoryType;
import open.code.util.SecurityUtil;
import open.code.util.filter_criteria.DirectorySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Log4j2
@Service
public class DirectoryService implements DirectoryContract {
    private final DirectoryRepository directoryRepository;

    private final BankMessageRepository bankMessageRepository;

    @Autowired
    public DirectoryService(DirectoryRepository directoryRepository, BankMessageRepository bankMessageRepository) {
        this.directoryRepository = directoryRepository;
        this.bankMessageRepository = bankMessageRepository;
    }

    @Override
    @Transactional
    public Directory add(DirectoryDto directoryDto, String directoryType) {
        if (checkDirectoryType(directoryType)) {
            throw new DirectoryTypeException("Directory type is not present");
        }
        Directory directory;
        directoryRepository.save(directory = Directory.builder()
                .code(directoryDto.getCode())
                .name(directoryDto.getName())
                .validityStart(directoryDto.getValidityStart())
                .validityEnd(directoryDto.getValidityEnd())
                .directoryType(directoryType)
                .createdBy(SecurityUtil.extractNameCurrentUser())
                .updatedBy(SecurityUtil.extractNameCurrentUser())
                .build());
        log.info("Directory saved successfully");
        return directory;
    }

    @Override
    public Page<Directory> getAll(String directoryType, int page) {
        if (checkDirectoryType(directoryType)) {
            throw new DirectoryTypeException("Directory type is not present");
        }
        log.info("Directory successfully returned");
        return directoryRepository.findAllByDirectoryTypeAndDeletedIsFalse(
                directoryType,
                PageRequest.of(page, Constants.PAGE_SIZE));
    }

    @Override
    public Page<Directory> getAllDeleted(String directoryType, int page) {
        if (checkDirectoryType(directoryType)) {
            throw new DirectoryTypeException("Directory type is not present");
        }
        log.info("Directory successfully returned");
        return directoryRepository.findAllByDirectoryTypeAndDeletedIsTrue(
                directoryType,
                PageRequest.of(page, Constants.PAGE_SIZE));
    }

    @Override
    public Page<Directory> getAllByFilter(String directoryType, DirectoryFilterDto directoryFilterDto, int page) {
        if (checkDirectoryType(directoryType)) {
            throw new DirectoryTypeException("Directory type is not present");
        }

        if (directoryFilterDto == null) {
            throw new DirectoryNotFoundException("Not found");
        }

        Specification<Directory> specification = new DirectorySpecification(directoryFilterDto, directoryType);
        return directoryRepository.findAll(Specification.where(coincidenceType(directoryType)).and(specification),
                PageRequest.of(page, Constants.PAGE_SIZE));
    }

    @Override
    public Directory update(Long id, DirectoryDto directoryDto) {
        Directory directory = directoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (directory.isDeleted()) {
            throw new DirectoryNotFoundException("Directory has been deleted");
        }
        updateDirectory(directory, directoryDto);
        log.info("Directory updated successfully");
        return directoryRepository.save(directory);
    }

    @Transactional
    public Directory recoveryById(Long id) {
        Directory directory = directoryRepository.findById(id)
                .orElseThrow(() -> new DirectoryNotFoundException("Directory not found"));
        directory.setDeletedBy(null);
        directory.setDeletedAt(null);
        log.info("Directory recovered successfully");
        directoryRepository.softRecovery(id);
        return directory;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Directory directory = directoryRepository.findById(id)
                .orElseThrow(() -> new DirectoryNotFoundException("Directory not found"));
        directory.setDeletedBy(SecurityUtil.extractNameCurrentUser());
        directory.setDeletedAt(LocalDateTime.now());
        directoryRepository.softDelete(id);
        log.info("Successful deletion");
    }

    @Transactional
    public void updateDirectory(Directory directory, DirectoryDto directoryDto) {
        if (directoryDto.getCode() != null)
            directory.setCode(directoryDto.getCode());
        if (directoryDto.getName() != null)
            directory.setName(directoryDto.getName());
        if (directoryDto.getValidityStart() != null)
            directory.setValidityStart(directoryDto.getValidityStart());
        if (directoryDto.getValidityEnd() != null)
            directory.setValidityEnd(directoryDto.getValidityEnd());
        directory.setUpdatedBy(SecurityUtil.extractNameCurrentUser());
    }

    private boolean checkDirectoryType(String directoryType) {
        return Arrays.stream(DirectoryType.values()).noneMatch(x -> x.getVal().equals(directoryType));
    }

    public List<DirectoryType> getDirectoryTypes() {
        return Arrays.stream(DirectoryType.values()).toList();
    }

    private Specification<Directory> coincidenceType(String directoryType) {
        return (directory, cq, cb) -> cb.equal(directory.get("directoryType"), directoryType);
    }
}