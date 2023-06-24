package open.code.service.directory;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import open.code.exception.directory_exception.DirectoryNotFoundException;
import open.code.exception.directory_exception.DirectoryTypeException;
import open.code.model.Directory;
import open.code.dto.DirectoryDto;
import open.code.repository.DirectoryRepository;
import open.code.util.DirectoryType;
import open.code.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Log4j2
@Service
public class DirectoryService implements DirectoryContract {
    private final DirectoryRepository directoryRepository;

    @Autowired
    public DirectoryService(DirectoryRepository directoryRepository) {
        this.directoryRepository = directoryRepository;
    }

    @Override
    public ResponseEntity<Directory> add(DirectoryDto directoryDto, String directoryType) {
        if (checkDirectoryType(directoryType)) {
            throw new DirectoryTypeException("Directory type is not present");
        }
        Directory directory = Directory.builder()
                .code(directoryDto.getCode())
                .name(directoryDto.getName())
                .validityStart(directoryDto.getValidityStart())
                .validityEnd(directoryDto.getValidityEnd())
                .directoryType(directoryType)
                .createdBy(SecurityUtil.extractNameCurrentUser())
                .updatedBy(SecurityUtil.extractNameCurrentUser())
                .build();
        directoryRepository.save(directory);
        log.info("Directory saved successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(directory);
    }

    @Override
    public List<Directory> getAll(String directoryType) {
        if (checkDirectoryType(directoryType)) {
            throw new DirectoryTypeException("Directory type is not present");
        }
        log.info("Directory successfully returned");
        return directoryRepository.findByDirectoryTypeAndDeletedFalse(directoryType);
    }

    @Override
    @Transactional
    public ResponseEntity<Directory> update(Long id, DirectoryDto directoryDto) {
        Directory directory = directoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (directory.isDeleted()) {
            throw new DirectoryNotFoundException("Directory has been deleted");
        }

        updateDirectory(directory, directoryDto);
        directoryRepository.save(directory);
        log.info("Directory updated successfully");
        return ResponseEntity.status(HttpStatus.OK).body(directory);
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        Directory directory = directoryRepository.findById(id)
                .orElseThrow(() -> new DirectoryNotFoundException("Directory not found"));
        directory.setDeletedBy(SecurityUtil.extractNameCurrentUser());
        directory.setDeletedAt(LocalDateTime.now());
        directoryRepository.softDelete(id);
        log.info("Successful deletion");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Successful deletion");
    }

    private void updateDirectory(Directory directory, DirectoryDto directoryDto) {
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
}