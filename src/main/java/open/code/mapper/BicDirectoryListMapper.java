package open.code.mapper;

import open.code.dto.BicDirectoryEntryDto;
import open.code.model.BicDirectoryEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BicDirectoryListMapper {
    private final BicDirectoryMapper bicDirectoryMapper;

    @Autowired
    public BicDirectoryListMapper(BicDirectoryMapper bicDirectoryMapper) {
        this.bicDirectoryMapper = bicDirectoryMapper;
    }

    public List<BicDirectoryEntry> toModelList(List<BicDirectoryEntryDto> bicDirectoryEntryDtoList) {
        if (bicDirectoryEntryDtoList == null) {
            return null;
        }
        List<BicDirectoryEntry> list = new ArrayList<BicDirectoryEntry>(bicDirectoryEntryDtoList.size());
        for (BicDirectoryEntryDto bicDirectoryEntryDto : bicDirectoryEntryDtoList) {
            list.add(bicDirectoryMapper.toModel(bicDirectoryEntryDto));
        }
        return list;
    }

    public List<BicDirectoryEntryDto> toDTO(List<BicDirectoryEntry> bicDirectoryEntries) {
        if (bicDirectoryEntries == null) {
            return null;
        }
        List<BicDirectoryEntryDto> list = new ArrayList<BicDirectoryEntryDto>(bicDirectoryEntries.size());
        for (BicDirectoryEntry bicDirectoryEntry : bicDirectoryEntries) {
            list.add(bicDirectoryMapper.toDTO(bicDirectoryEntry));
        }
        return list;
    }
}