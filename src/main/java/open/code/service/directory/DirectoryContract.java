package open.code.service.directory;

import open.code.dto.directory_dto.DirectoryFilterDto;
import open.code.model.Directory;
import open.code.dto.directory_dto.DirectoryDto;
import org.springframework.data.domain.Page;

public interface DirectoryContract {
    Directory add(DirectoryDto directoryDto, String directoryType);

    Page<Directory> getAll(String directoryType, int page);

    Page<Directory> getAllDeleted(String directoryType, int page);

    Page<Directory> getAllByFilter(String directoryType, DirectoryFilterDto directoryFilterDto, int page);

    Directory update(Long id, DirectoryDto directoryDto);

    void deleteById(Long id);

    Directory recoveryById(Long id);
}
