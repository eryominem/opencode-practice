package open.code.service.directory;

import open.code.model.Directory;
import open.code.dto.DirectoryDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DirectoryContract {
    ResponseEntity<Directory> add(DirectoryDto directoryDto, String directoryType);

    List<Directory> getAll(String directoryType, Long dicId);

    ResponseEntity<Directory> update(Long id, DirectoryDto directoryDto);

    ResponseEntity<?> deleteById(Long id);

    Directory recoveryById(Long id);
}
