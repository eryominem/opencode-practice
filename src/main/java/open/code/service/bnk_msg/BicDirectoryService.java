package open.code.service.bnk_msg;

import lombok.extern.log4j.Log4j2;
import open.code.dto.BicDirectoryFilterDto;
import open.code.dto.PayerDto;
import open.code.exception.bic_exception.BicEntryNotFoundException;
import open.code.model.BicDirectoryEntry;
import open.code.repository.bnk_msg.BicDirectoryEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
public class BicDirectoryService {
    private final BicDirectoryEntryRepository bicDirectoryEntryRepository;

    @Autowired
    public BicDirectoryService(BicDirectoryEntryRepository bicDirectoryEntryRepository) {
        this.bicDirectoryEntryRepository = bicDirectoryEntryRepository;
    }

    /**
     * Return all payers from a specific file
     */
    public List<PayerDto> transformBicDirectoriesToPayers(Long msgId, int page) {
        Page<BicDirectoryEntry> bicDirectoryEntries = bicDirectoryEntryRepository.findAllByBankMessageId(msgId, PageRequest.of(page, 25));
        log.info("Payers returned successfully");
        return bicDirectoryEntries.getContent().stream().map((x) -> new PayerDto(x, x.getParticipantInfo()))
                .collect(Collectors.toList());
    }

    public long countAll(Long msgId) {
        log.info("Returned count of BIC entries");
        return bicDirectoryEntryRepository.countByBankMessageId(msgId);
    }

    public List<PayerDto> findAllPayersByFilter(BicDirectoryFilterDto bicDirectoryFilterDto) {
        if (bicDirectoryFilterDto.getBic() != null) {
            if (bicDirectoryFilterDto.getNameP() != null && bicDirectoryFilterDto.getPtType() != null)
                return bicDirectoryToPayers(bicDirectoryEntryRepository.findAllByBicAndParticipantInfoNamePAndParticipantInfoPtTypeAndBankMessageId(bicDirectoryFilterDto.getBic(),
                        bicDirectoryFilterDto.getNameP(), bicDirectoryFilterDto.getPtType(), bicDirectoryFilterDto.getMsgId()));
            else if (bicDirectoryFilterDto.getNameP() != null)
                return bicDirectoryToPayers(bicDirectoryEntryRepository.findAllByBicAndParticipantInfoNamePAndBankMessageId(bicDirectoryFilterDto.getBic(),
                        bicDirectoryFilterDto.getNameP(), bicDirectoryFilterDto.getMsgId()));
            else if (bicDirectoryFilterDto.getPtType() != null)
                return bicDirectoryToPayers(bicDirectoryEntryRepository.findAllByBicAndParticipantInfoPtTypeAndBankMessageId(bicDirectoryFilterDto.getBic(),
                        bicDirectoryFilterDto.getPtType(), bicDirectoryFilterDto.getMsgId()));
            else
                return bicDirectoryToPayers(bicDirectoryEntryRepository.findAllByBicAndBankMessageId(bicDirectoryFilterDto.getBic(), bicDirectoryFilterDto.getMsgId()));
        } else {
            if (bicDirectoryFilterDto.getNameP() != null && bicDirectoryFilterDto.getPtType() != null)
                return bicDirectoryToPayers(bicDirectoryEntryRepository.findAllByParticipantInfoNamePAndParticipantInfoPtTypeAndBankMessageId(bicDirectoryFilterDto.getNameP(),
                        bicDirectoryFilterDto.getPtType(), bicDirectoryFilterDto.getMsgId()));
            if (bicDirectoryFilterDto.getNameP() == null && bicDirectoryFilterDto.getPtType() != null)
                return bicDirectoryToPayers(bicDirectoryEntryRepository.findAllByParticipantInfoPtTypeAndBankMessageId(bicDirectoryFilterDto.getPtType(),
                        bicDirectoryFilterDto.getMsgId()));
            if (bicDirectoryFilterDto.getNameP() != null)
                return bicDirectoryToPayers(bicDirectoryEntryRepository.findAllByParticipantInfoNamePAndBankMessageId(bicDirectoryFilterDto.getNameP(),
                        bicDirectoryFilterDto.getMsgId()));
            else
                throw new BicEntryNotFoundException("Not found");
        }
    }

    private List<PayerDto> bicDirectoryToPayers(List<BicDirectoryEntry> bicDirectoryEntries) {
        return bicDirectoryEntries.stream().map((x) -> new PayerDto(x, x.getParticipantInfo()))
                .collect(Collectors.toList());
    }
}
