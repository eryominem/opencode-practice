package open.code.service.bnk_msg;

import lombok.extern.log4j.Log4j2;
import open.code.dto.PayerDto;
import open.code.dto.SWBICSDto;
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
    private final SWBICSMapper swbicsMapper;

    @Autowired
    public BicDirectoryService(BicDirectoryEntryRepository bicDirectoryEntryRepository,
                               SWBICSMapper swbicsMapper) {
        this.bicDirectoryEntryRepository = bicDirectoryEntryRepository;
        this.swbicsMapper = swbicsMapper;
    }


    /**
     * Return all payers from a specific file
     */
    public List<PayerDto> transformBicDirectoriesToPayers(Long msgId, Long bicId) {
        List<BicDirectoryEntry> bicDirectoryEntries = bicDirectoryEntryRepository.findAll(msgId, bicId);
        log.info("Payers returned successfully");
        return bicDirectoryEntries.stream().map((x) -> new PayerDto(x, x.getParticipantInfo()))
                .collect(Collectors.toList());
    }

    public List<SWBICSDto> transformSWBICSToDto(Long msgId, Long bicId) {
        var bicDirectoryEntry = bicDirectoryEntryRepository.findByBankMessageIdAndId(msgId, bicId)
                .orElseThrow(() -> new BicEntryNotFound("BicDirectoryEntry not found"));
        log.info("SWBICS returned successfully");
        return bicDirectoryEntry.getSwbics().stream().map(swbicsMapper::toDTO).collect(Collectors.toList());
    }
}
