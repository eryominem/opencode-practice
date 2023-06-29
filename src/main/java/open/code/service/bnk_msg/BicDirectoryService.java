package open.code.service.bnk_msg;

import lombok.extern.log4j.Log4j2;
import open.code.dto.PayerDto;
import open.code.exception.bic_exception.BicEntryNotFound;
import open.code.mapper.SWBICSMapper;
import open.code.model.BicDirectoryEntry;
import open.code.repository.bnk_msg.BicDirectoryEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
public class BicDirectoryService {
    private final BicDirectoryEntryRepository bicDirectoryEntryRepository;

    @Autowired
    public BicDirectoryService(BicDirectoryEntryRepository bicDirectoryEntryRepository,
                               SWBICSMapper swbicsMapper) {
        this.bicDirectoryEntryRepository = bicDirectoryEntryRepository;
    }

    /**
     * Return all payers from a specific file
     */
    public List<PayerDto> transformBicDirectoriesToPayers(Long msgId, Long bicId) {
        List<BicDirectoryEntry> bicDirectoryEntries = bicDirectoryEntryRepository.findAll(msgId, bicId);
        log.info("Payers returned successfully");
        return bicDirectoryToPayers(bicDirectoryEntries);
    }

    public List<PayerDto> findAllPayersByFilter(String bic, String nameP, String ptType) {
        if (bic != null) {
            if (nameP != null && ptType != null)
                return bicDirectoryToPayers(bicDirectoryEntryRepository.findAllByBicAndParticipantInfoNamePAndParticipantInfoPtType(bic, nameP, ptType));
            else if (nameP != null)
                return bicDirectoryToPayers(bicDirectoryEntryRepository.findAllByBicAndParticipantInfoNameP(bic, nameP));
            else if (ptType != null)
                return bicDirectoryToPayers(bicDirectoryEntryRepository.findAllByBicAndParticipantInfoPtType(bic, ptType));
            else return bicDirectoryToPayers(bicDirectoryEntryRepository.findAllByBic(bic));
        } else {
            if (nameP != null && ptType != null)
                return bicDirectoryToPayers(bicDirectoryEntryRepository.findAllByParticipantInfoNamePAndParticipantInfoPtType(nameP, ptType));
            if (nameP == null && ptType != null)
                return bicDirectoryToPayers(bicDirectoryEntryRepository.findAllByParticipantInfoPtType(ptType));
            if (nameP != null)
                return bicDirectoryToPayers(bicDirectoryEntryRepository.findAllByParticipantInfoNameP(nameP));
            else
                throw new BicEntryNotFound("Not found");
        }
    }

    private List<PayerDto> bicDirectoryToPayers(List<BicDirectoryEntry> bicDirectoryEntries) {
        return bicDirectoryEntries.stream().map((x) -> new PayerDto(x, x.getParticipantInfo()))
                .collect(Collectors.toList());
    }
}
