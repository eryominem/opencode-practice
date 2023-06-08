package open.code.service.bnk_msg;

import open.code.model.Account;
import open.code.repository.bnk_msg.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllByBicId(Long id) {
        return accountRepository.findAllByBicDirectoryEntryId(id);
    }
}
