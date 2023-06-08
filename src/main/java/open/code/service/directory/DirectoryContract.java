package open.code.service.directory;

import open.code.model.Directory;
import open.code.dto.DirectoryDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DirectoryContract {
    public ResponseEntity<Directory> add(DirectoryDto directoryDto, String directoryType);

    public List<Directory> getAll(String directoryType);

    public ResponseEntity<Directory> update(Long id, DirectoryDto directoryDto);

    public ResponseEntity<Directory> delete(Long id);

}
