package open.code.service.directory;

import open.code.model.Directory;
import open.code.dto.DirectoryDto;
import org.springframework.data.domain.Page;

public interface DirectoryContract {
    Directory add(DirectoryDto directoryDto, String directoryType, Long msgId);

    Page<Directory> getAll(String directoryType, int page, Long msgId);

    Directory update(Long id, DirectoryDto directoryDto);

    void deleteById(Long id);

    Directory recoveryById(Long id);
}
