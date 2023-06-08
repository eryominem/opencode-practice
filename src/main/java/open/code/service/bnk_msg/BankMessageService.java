package open.code.service.bnk_msg;

import open.code.dto.BankMessageDto;
import open.code.model.BankMessage;
import open.code.repository.bnk_msg.BankMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankMessageService {
    private final BankMessageRepository bankMessageRepository;

    @Autowired
    public BankMessageService(BankMessageRepository bankMessageRepository) {
        this.bankMessageRepository = bankMessageRepository;
    }

    public List<BankMessageDto> transformBankMessageToDto() {
        List<BankMessage> bankMessages = bankMessageRepository.findAll();
        return bankMessages.stream().map(BankMessageDto::new).collect(Collectors.toList());
    }
}