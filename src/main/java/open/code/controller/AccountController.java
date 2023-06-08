package open.code.controller;

import open.code.model.Account;
import open.code.service.bnk_msg.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAccounts(@RequestParam("bicId") Long bicId) {
        return accountService.getAllByBicId(bicId);
    }

}
