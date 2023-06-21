package open.code.mapper;

import open.code.dto.BicDirectoryEntryDto;
import open.code.model.BicDirectoryEntry;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = BicDirectoryMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BicDirectoryListMapper {
    List<BicDirectoryEntry> toModelList(List<BicDirectoryEntryDto> bicDirectoryEntryDtoList);
    List<BicDirectoryEntryDto> toDTO(List<BicDirectoryEntry> bicDirectoryEntries);
}
