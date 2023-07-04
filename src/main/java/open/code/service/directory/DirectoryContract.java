package open.code.service.directory;

import open.code.model.Directory;
import open.code.dto.DirectoryDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DirectoryContract {
    Directory add(DirectoryDto directoryDto, String directoryType);

    List<Directory> getAll(String directoryType, Long dicId);

    Directory update(Long id, DirectoryDto directoryDto);

    void deleteById(Long id);

    Directory recoveryById(Long id);
}
