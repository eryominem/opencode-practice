package open.code.mapper;

import open.code.dto.BankMessageDto;
import open.code.dto.BicDirectoryEntryDto;
import open.code.model.BankMessage;
import open.code.model.BicDirectoryEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BankMessageMapper {
    private final BicDirectoryMapper bicDirectoryMapper;

    @Autowired
    public BankMessageMapper(BicDirectoryMapper bicDirectoryMapper) {
        this.bicDirectoryMapper = bicDirectoryMapper;
    }

    public BankMessage toModel(BankMessageDto bankMessageDto) {
        if (bankMessageDto == null) {
            return null;
        }
        BankMessage.BankMessageBuilder bankMessage = BankMessage.builder();
        bankMessage.eDNo(bankMessageDto.getEDNo());
        bankMessage.eDDate(bankMessageDto.getEDDate());
        bankMessage.eDAuthor(bankMessageDto.getEDAuthor());
        bankMessage.eDReceiver(bankMessageDto.getEDReceiver());
        bankMessage.id(bankMessageDto.getId());
        bankMessage.title(bankMessageDto.getTitle());
        bankMessage.fileName(bankMessageDto.getFileName());
        bankMessage.creationReason(bankMessageDto.getCreationReason());
        bankMessage.creationDateTime(bankMessageDto.getCreationDateTime());
        bankMessage.infoTypeCode(bankMessageDto.getInfoTypeCode());
        bankMessage.businessDay(bankMessageDto.getBusinessDay());
        bankMessage.directoryVersion(bankMessageDto.getDirectoryVersion());
        bankMessage.createdBy(bankMessageDto.getCreatedBy());
        bankMessage.bicDirectoryEntries(bicDirectoryEntryDtoListToBicDirectoryEntryList(bankMessageDto.getBicDirectoryEntries()));
        return bankMessage.build();
    }

    public BankMessageDto toDTO(BankMessage bankMessage) {
        if (bankMessage == null) {
            return null;
        }
        BankMessageDto bankMessageDto = new BankMessageDto();
        bankMessageDto.setId(bankMessage.getId());
        bankMessageDto.setTitle(bankMessage.getTitle());
        bankMessageDto.setFileName(bankMessage.getFileName());
        bankMessageDto.setCreatedBy(bankMessage.getCreatedBy());
        bankMessageDto.setEDNo(bankMessage.getEDNo());
        bankMessageDto.setEDDate(bankMessage.getEDDate());
        bankMessageDto.setEDAuthor(bankMessage.getEDAuthor());
        bankMessageDto.setEDReceiver(bankMessage.getEDReceiver());
        bankMessageDto.setCreationReason(bankMessage.getCreationReason());
        bankMessageDto.setCreationDateTime(bankMessage.getCreationDateTime());
        bankMessageDto.setInfoTypeCode(bankMessage.getInfoTypeCode());
        bankMessageDto.setBusinessDay(bankMessage.getBusinessDay());
        bankMessageDto.setDirectoryVersion(bankMessage.getDirectoryVersion());
        bankMessageDto.setBicDirectoryEntries(bicDirectoryEntryListToBicDirectoryEntryDtoList(bankMessage.getBicDirectoryEntries()));
        return bankMessageDto;
    }

    protected List<BicDirectoryEntry> bicDirectoryEntryDtoListToBicDirectoryEntryList(List<BicDirectoryEntryDto> list) {
        if (list == null) {
            return null;
        }
        List<BicDirectoryEntry> list1 = new ArrayList<BicDirectoryEntry>(list.size());
        for (BicDirectoryEntryDto bicDirectoryEntryDto : list) {
            list1.add(bicDirectoryMapper.toModel(bicDirectoryEntryDto));
        }
        return list1;
    }

    protected List<BicDirectoryEntryDto> bicDirectoryEntryListToBicDirectoryEntryDtoList(List<BicDirectoryEntry> list) {
        if (list == null) {
            return null;
        }
        List<BicDirectoryEntryDto> list1 = new ArrayList<BicDirectoryEntryDto>(list.size());
        for (BicDirectoryEntry bicDirectoryEntry : list) {
            list1.add(bicDirectoryMapper.toDTO(bicDirectoryEntry));
        }
        return list1;
    }
}
