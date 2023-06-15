package open.code.service.bnk_msg;

import lombok.extern.log4j.Log4j2;
import open.code.dto.BankMessageDto;
import open.code.model.BankMessage;
import open.code.repository.bnk_msg.BankMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<BankMessageDto> transformBankMessageToDto() {
        log.info("Bank message received");
        List<BankMessage> bankMessages = bankMessageRepository.findAll();
        log.info("Bank message returned successfully");
        return bankMessages.stream().map(BankMessageDto::new).collect(Collectors.toList());
    }
}