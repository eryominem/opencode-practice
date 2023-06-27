package open.code.service.bnk_msg;

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
        return bankMessages.stream().map(BankMsgViewDto::build).collect(Collectors.toList());
    }

    public List<BankMsgViewDto> findAllBankMessageByName(String title) {
        List<BankMessage> bankMessages = bankMessageRepository.findAllByTitle(title);
        return bankMessages.stream().map(BankMsgViewDto::build).collect(Collectors.toList());
    }

    public List<BankMsgViewDto> findByDateBetween(LocalDate date1, Optional<LocalDate> date2) {
        LocalDate localDate = date2.orElseGet(LocalDate::now);
        List<BankMessage> bankMessages = bankMessageRepository.findByDeletedFalseAndCreatedAtBetween(date1, localDate);
        return bankMessages.stream().map(BankMsgViewDto::build).collect(Collectors.toList());
    }

    public BankMsgViewDto recoveryById(Long id) {
        BankMessage bankMessage = bankMessageRepository.findById(id)
                .orElseThrow(() -> new BankMessageNotFoundException("ED807 not found"));
        bankMessage.setDeletedBy(null);
        log.info("BankMessage recovered successfully");
        bankMessageRepository.softRecovery(id);
        return BankMsgViewDto.build(bankMessage);
    }

    public ResponseEntity<?> deleteById(Long id) {
        BankMessage bankMessage = bankMessageRepository.findById(id)
                .orElseThrow(() -> new BankMessageNotFoundException("ED807 not found"));
        log.info("BankMessage deleted successfully");
        bankMessage.setDeletedBy(SecurityUtil.extractNameCurrentUser());
        bankMessageRepository.softDelete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Successful deletion");
    }
}