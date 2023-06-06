package open.code.service;

import open.code.model.BankMessage;
import open.code.repository.AccountRepository;
import open.code.repository.BankMessageRepository;
import open.code.repository.BicDirectoryEntryRepository;
import open.code.repository.ParticipantInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankMessageService {
    private final BankMessageRepository bankMessageRepository;

    @Autowired
    public BankMessageService(BankMessageRepository bankMessageRepository) {
        this.bankMessageRepository = bankMessageRepository;
    }

    public List<BankMessage> getAllMessages() {
        return bankMessageRepository.findAll();
    }
}