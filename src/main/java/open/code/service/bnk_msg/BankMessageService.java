package open.code.service.bnk_msg;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import open.code.dto.bic_dto.PayerDto;
import open.code.dto.ed807_dto.BankMessageFilterDto;
import open.code.dto.ed807_dto.BankMsgViewDto;
import open.code.exception.bankmsg_exception.BankMessageNotFoundException;
import open.code.model.BankMessage;
import open.code.model.BicDirectoryEntry;
import open.code.repository.bnk_msg.BankMessageRepository;
import open.code.util.Constants;
import open.code.util.SecurityUtil;
import open.code.util.filter_criteria.BankMessageSpecification;
import open.code.util.filter_criteria.BicEntrySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
public class BankMessageService {
    private final BankMessageRepository bankMessageRepository;

    @Autowired
    public BankMessageService(BankMessageRepository bankMessageRepository) {
        this.bankMessageRepository = bankMessageRepository;
    }

    public List<BankMsgViewDto> transformBankMsgToViewDto() {
        log.info("Bank message received");
        List<BankMessage> bankMessages = bankMessageRepository.findByDeletedFalse();
        log.info("Bank message returned successfully");
        return bankMessageToBankMsgViewDto(bankMessages);
    }

    public Page<BankMsgViewDto> findBankMessageByFilter(BankMessageFilterDto bankMessageFilterDto, int page) {
        if (bankMessageFilterDto == null)
            throw new BankMessageNotFoundException("Not found");
        Specification<BankMessage> specification = new BankMessageSpecification(bankMessageFilterDto);
        return bankMessageRepository.findAll(specification, PageRequest.of(page, Constants.PAGE_SIZE))
                .map(BankMsgViewDto::build);
    }

    @Transactional
    public BankMsgViewDto recoveryById(Long id) {
        BankMessage bankMessage = bankMessageRepository.findById(id)
                .orElseThrow(() -> new BankMessageNotFoundException("ED807 not found"));
        bankMessage.setDeletedBy(null);
        log.info("BankMessage recovered successfully");
        bankMessageRepository.softRecovery(id);
        return BankMsgViewDto.build(bankMessage);
    }

    @Transactional
    public BankMsgViewDto deleteById(Long id) {
        BankMessage bankMessage = bankMessageRepository.findById(id)
                .orElseThrow(() -> new BankMessageNotFoundException("ED807 not found"));
        bankMessage.setDeletedBy(SecurityUtil.extractNameCurrentUser());
        bankMessageRepository.softDelete(id);
        log.info("BankMessage deleted successfully");
        BankMsgViewDto bankMsgViewDto = BankMsgViewDto.build(bankMessage);
        return bankMsgViewDto;
    }

    private List<BankMsgViewDto> bankMessageToBankMsgViewDto(List<BankMessage> bankMessages) {
        return bankMessages.stream().map(BankMsgViewDto::build).collect(Collectors.toList());
    }
}