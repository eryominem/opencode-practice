package open.code.service.bnk_msg;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import open.code.dto.BankMessageFilterDto;
import open.code.dto.BankMsgViewDto;
import open.code.exception.bankmsg_exception.BankMessageNotFoundException;
import open.code.model.BankMessage;
import open.code.repository.bnk_msg.BankMessageRepository;
import open.code.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public List<BankMsgViewDto> findBankMessageByFilter(BankMessageFilterDto bankMessageFilterDto) {
        System.out.println(bankMessageFilterDto);
        LocalDate localDate1 = bankMessageFilterDto.getDate1() == null ? LocalDate.now() : bankMessageFilterDto.getDate1();
        LocalDate localDate2 = bankMessageFilterDto.getDate2() == null ? LocalDate.now() : bankMessageFilterDto.getDate2();
        if (bankMessageFilterDto.getTitle() != null) {
            if (bankMessageFilterDto.getDate1() != null && bankMessageFilterDto.getDate2() != null) {
                return bankMessageToBankMsgViewDto(bankMessageRepository.findByDeletedFalseAndTitleAndCreatedAtBetween(bankMessageFilterDto.getTitle(),
                        localDate1, localDate2));
            } else if (bankMessageFilterDto.getDate1() != null) {
                return bankMessageToBankMsgViewDto(bankMessageRepository.findByDeletedFalseAndTitleAndCreatedAtIsAfter(bankMessageFilterDto.getTitle(), localDate1));
            } else if (bankMessageFilterDto.getDate2() != null) {
                return bankMessageToBankMsgViewDto(bankMessageRepository.findByDeletedFalseAndTitleAndCreatedAtIsBefore(bankMessageFilterDto.getTitle(), localDate2));
            } else {
                return bankMessageToBankMsgViewDto(bankMessageRepository.findAllByDeletedFalseAndTitle(bankMessageFilterDto.getTitle()));
            }
        } else {
            if (bankMessageFilterDto.getDate1() != null && bankMessageFilterDto.getDate2() != null) {
                return bankMessageToBankMsgViewDto(bankMessageRepository.findByDeletedFalseAndCreatedAtBetween(localDate1, localDate2));
            } else if (bankMessageFilterDto.getDate1() == null && bankMessageFilterDto.getDate2() != null) {
                return bankMessageToBankMsgViewDto(bankMessageRepository.findByDeletedFalseAndCreatedAtIsBefore(localDate2));
            } else if (bankMessageFilterDto.getDate1() != null) {
                return bankMessageToBankMsgViewDto(bankMessageRepository.findByDeletedFalseAndCreatedAtIsAfter(localDate1));
            } else {
                throw new BankMessageNotFoundException("BankMessage not found");
            }
        }
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