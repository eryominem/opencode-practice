package open.code.service.bnk_msg;

import lombok.extern.log4j.Log4j2;
import open.code.model.Account;
import open.code.repository.bnk_msg.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Log4j2
@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllByBicId(Long id) {
        log.info("Accounts returned successfully");
        return accountRepository.findAllByBicDirectoryEntryId(id);
    }
}
