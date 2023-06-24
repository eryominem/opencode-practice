package open.code.service.bnk_msg;

import lombok.extern.log4j.Log4j2;
import open.code.dto.BankMessageDto;
import open.code.dto.BankMsgViewDto;
import open.code.exception.bankmsg_exception.BankMessageNotFoundException;
import open.code.model.BankMessage;
import open.code.repository.bnk_msg.BankMessageRepository;
import open.code.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
        return bankMessages.stream().map(BankMsgViewDto::build).collect(Collectors.toList());
    }

    public ResponseEntity<?> deleteById(Long id) {
        BankMessage bankMessage = bankMessageRepository.findById(id)
                .orElseThrow(() -> new BankMessageNotFoundException("ED807 not found"));
        bankMessage.setDeletedBy(SecurityUtil.extractNameCurrentUser());
        bankMessageRepository.softDelete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Successful deletion");
    }
}