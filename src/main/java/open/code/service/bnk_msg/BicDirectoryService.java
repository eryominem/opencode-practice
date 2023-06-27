package open.code.service.bnk_msg;

import lombok.extern.log4j.Log4j2;
import open.code.dto.PayerDto;
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
    public BicDirectoryService(BicDirectoryEntryRepository bicDirectoryEntryRepository) {
        this.bicDirectoryEntryRepository = bicDirectoryEntryRepository;
    }


    /**
     * Return all payers from a specific file
     */
    public List<PayerDto> transformBicDirectoriesToPayers(Long msgId, Long bicId) {
        log.info("Bic directory entries received");
        List<BicDirectoryEntry> bicDirectoryEntries = bicDirectoryEntryRepository.findAll(msgId, bicId);
        log.info("Payers returned successfully");
        return bicDirectoryEntries.stream().map((x) -> new PayerDto(x, x.getParticipantInfo()))
                .collect(Collectors.toList());
    }
}
