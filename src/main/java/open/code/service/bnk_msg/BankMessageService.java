package open.code.service.bnk_msg;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
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
import java.util.Optional;
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

    public List<BankMsgViewDto> findBankMessageByFilter(String title, Optional<LocalDate> date1, Optional<LocalDate> date2) {
        LocalDate localDate1 = date1.orElseGet(LocalDate::now);
        LocalDate localDate2 = date2.orElseGet(LocalDate::now);
        if (title != null) {
            if (date1.isPresent() && date2.isPresent()) {
                return bankMessageToBankMsgViewDto(bankMessageRepository.findByDeletedFalseAndTitleAndCreatedAtBetween(title, localDate1, localDate2));
            } else if (date1.isPresent()) {
                return bankMessageToBankMsgViewDto(bankMessageRepository.findByDeletedFalseAndTitleAndCreatedAtIsAfter(title, localDate1));
            } else if (date2.isPresent()) {
                return bankMessageToBankMsgViewDto(bankMessageRepository.findByDeletedFalseAndTitleAndCreatedAtIsBefore(title, localDate2));
            } else {
                return bankMessageToBankMsgViewDto(bankMessageRepository.findAllByDeletedFalseAndTitle(title));
            }
        } else {
            if (date1.isPresent() && date2.isPresent()) {
                return bankMessageToBankMsgViewDto(bankMessageRepository.findByDeletedFalseAndCreatedAtBetween(localDate1, localDate2));
            } else if (date1.isEmpty() && date2.isPresent()) {
                return bankMessageToBankMsgViewDto(bankMessageRepository.findByDeletedFalseAndCreatedAtIsBefore(localDate2));
            } else if (date1.isPresent()) {
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
    public ResponseEntity<?> deleteById(Long id) {
        BankMessage bankMessage = bankMessageRepository.findById(id)
                .orElseThrow(() -> new BankMessageNotFoundException("ED807 not found"));
        log.info("BankMessage deleted successfully");
        bankMessage.setDeletedBy(SecurityUtil.extractNameCurrentUser());
        bankMessageRepository.softDelete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Successful deletion");
    }

    private List<BankMsgViewDto> bankMessageToBankMsgViewDto(List<BankMessage> bankMessages) {
        return bankMessages.stream().map(BankMsgViewDto::build).collect(Collectors.toList());
    }
}