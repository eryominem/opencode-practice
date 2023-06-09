package open.code.service.directory;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import open.code.exception.DirectoryNotFoundException;
import open.code.model.Directory;
import open.code.dto.DirectoryDto;
import open.code.exception.DirectoryTypeException;
import open.code.repository.DirectoryRepository;
import open.code.util.DirectoryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

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
        var directory = Directory.builder()
                .code(directoryDto.getCode())
                .name(directoryDto.getName())
                .validityStart(directoryDto.getValidityStart())
                .validityEnd(directoryDto.getValidityEnd())
                .directoryType(directoryType)
                .build();
        directoryRepository.save(directory);

        return ResponseEntity.status(HttpStatus.CREATED).body(directory);
    }

    @Override
    public List<Directory> getAll(String directoryType) {
        if (checkDirectoryType(directoryType)) {
            throw new DirectoryTypeException("Directory type is not present");
        }
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
        return ResponseEntity.status(HttpStatus.OK).body(directory);
    }


    @Override
    public ResponseEntity<?> delete(Long id) {
        directoryRepository.softDelete(id);
        var deletedDirectory = directoryRepository.findById(id)
                        .orElseThrow(() -> new DirectoryNotFoundException("Directory not found"));
        System.out.println(deletedDirectory.toString());
        return ResponseEntity.status(HttpStatus.OK).body("Successful deletion");
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
    }

    private boolean checkDirectoryType(String directoryType) {
        return Arrays.stream(DirectoryType.values()).noneMatch(x -> x.getVal().equals(directoryType));
    }
}
