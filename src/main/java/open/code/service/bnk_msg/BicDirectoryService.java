package open.code.service.bnk_msg;

import lombok.extern.log4j.Log4j2;
import open.code.dto.bic_dto.BicDirectoryFilterDto;
import open.code.dto.bic_dto.PayerDto;
import open.code.exception.bic_exception.BicEntryNotFoundException;
import open.code.model.BicDirectoryEntry;
import open.code.repository.bnk_msg.BicDirectoryEntryRepository;
import open.code.util.Constants;
import open.code.util.filter_criteria.BicEntrySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

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
    public Page<PayerDto> transformBicDirectoriesToPayers(Long msgId, int page) {
        Page<PayerDto> payerDtos = bicDirectoryEntryRepository.findAllByBankMessageId(msgId, PageRequest.of(page, Constants.PAGE_SIZE))
                .map((x) -> new PayerDto(x, x.getParticipantInfo()));
        log.info("Payers returned successfully");
        return payerDtos;
    }

    public long countAll(Long msgId) {
        log.info("Returned count of BIC entries");
        return bicDirectoryEntryRepository.countByBankMessageId(msgId);
    }

    public Page<PayerDto> findAllPayersByFilter(BicDirectoryFilterDto bicDirectoryFilterDto, int page) {
        if (bicDirectoryFilterDto == null)
            throw new BicEntryNotFoundException("Not found");
        Specification<BicDirectoryEntry> specification = new BicEntrySpecification(bicDirectoryFilterDto);
        return bicDirectoryEntryRepository.findAll(specification, PageRequest.of(page, Constants.PAGE_SIZE))
                .map((x) -> new PayerDto(x, x.getParticipantInfo()));
    }
}
