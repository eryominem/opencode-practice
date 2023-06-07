package open.code.service;

import open.code.model.Ed807.Account;
import open.code.repository.ed807.AccountRepository;
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
