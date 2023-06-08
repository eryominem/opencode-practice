package open.code.service.directory;

import jakarta.transaction.Transactional;
import open.code.model.Directory;
import open.code.dto.DirectoryDto;
import open.code.exception.DirectoryTypeException;
import open.code.repository.DirectoryRepository;
import open.code.util.DirectoryType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class DirectoryService implements DirectoryContract {
    private final DirectoryRepository directoryRepository;

    @Autowired
    public DirectoryService(DirectoryRepository directoryRepository) {
        this.directoryRepository = directoryRepository;
    }

    @Override
    public ResponseEntity<Directory> add(DirectoryDto directoryDto, String directoryType) {
        if (!checkDirectoryType(directoryType)) {
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

        return new ResponseEntity<>(directory, HttpStatus.CREATED);
    }

    @Override
    public List<Directory> getAll(String directoryType) {
        if (!checkDirectoryType(directoryType)) {
            throw new DirectoryTypeException("Directory type is not present");
        }
        return directoryRepository.findAllByDirectoryType(directoryType);
    }

    @Override
    @Transactional
    public ResponseEntity<Directory> update(Long id, DirectoryDto directoryDto) {
        Optional<Directory> directoryOptional = directoryRepository.findById(id);
        if (directoryOptional.isPresent()) {
            Directory directory = directoryOptional.get();
            if (directoryDto.getCode() != null)
                directory.setCode(directoryDto.getCode());
            if (directoryDto.getName() != null)
                directory.setName(directoryDto.getName());
            if (directoryDto.getValidityStart() != null)
                directory.setValidityStart(directoryDto.getValidityStart());
            if (directoryDto.getValidityEnd() != null)
                directory.setValidityEnd(directoryDto.getValidityEnd());
            directoryRepository.save(directory);
            return new ResponseEntity<>(directory, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Directory> delete(Long id) {
        return null;
    }

    private boolean checkDirectoryType(String directoryType) {
        return Arrays.stream(DirectoryType.values()).anyMatch(x -> x.getVal().equals(directoryType));
    }
}
