package open.code.mapper;

import open.code.dto.BicDirectoryEntryDto;
import open.code.model.BicDirectoryEntry;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BicDirectoryMapper {
    BicDirectoryEntry toModel(BicDirectoryEntryDto bicDirectoryEntryDto);
    BicDirectoryEntryDto toDTO(BicDirectoryEntry bicDirectoryEntry);
}
