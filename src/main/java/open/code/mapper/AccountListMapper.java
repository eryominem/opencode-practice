package open.code.mapper;

import open.code.dto.AccountDto;
import open.code.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountListMapper {
    private final AccountMapper accountMapper;

    @Autowired
    public AccountListMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    public List<Account> toModelList(List<AccountDto> accountDtoList) {
        if (accountDtoList == null) {
            return null;
        }
        List<Account> list = new ArrayList<Account>(accountDtoList.size());
        for (AccountDto accountDto : accountDtoList) {
            list.add(accountMapper.toModel(accountDto));
        }
        return list;
    }

    public List<AccountDto> toDTOList(List<Account> accountList) {
        if (accountList == null) {
            return null;
        }
        List<AccountDto> list = new ArrayList<AccountDto>(accountList.size());
        for (Account account : accountList) {
            list.add(accountMapper.toDTO(account));
        }
        return list;
    }
}