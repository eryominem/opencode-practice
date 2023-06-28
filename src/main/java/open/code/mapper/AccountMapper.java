package open.code.mapper;

import open.code.dto.AccRstrListDto;
import open.code.dto.AccountDto;
import open.code.model.AccRstrList;
import open.code.model.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountMapper {
    public Account toModel(AccountDto accountDto) {
        if (accountDto == null) {
            return null;
        }
        Account account = new Account();
        account.setAccount(accountDto.getAccount());
        account.setRegulationAccountType(accountDto.getRegulationAccountType());
        account.setCk(accountDto.getCk());
        account.setAccountCBRBIC(accountDto.getAccountCBRBIC());
        account.setDateIn(accountDto.getDateIn());
        account.setAccountStatus(accountDto.getAccountStatus());
        account.setAccRstrLists(accRstrListDtoListToAccRstrListList(accountDto.getAccRstrLists()));
        return account;
    }

    public AccountDto toDTO(Account account) {
        if (account == null) {
            return null;
        }
        AccountDto accountDto = new AccountDto();
        accountDto.setAccount(account.getAccount());
        accountDto.setRegulationAccountType(account.getRegulationAccountType());
        accountDto.setCk(account.getCk());
        accountDto.setAccountCBRBIC(account.getAccountCBRBIC());
        accountDto.setDateIn(account.getDateIn());
        accountDto.setAccountStatus(account.getAccountStatus());
        accountDto.setAccRstrLists(accRstrListListToAccRstrListDtoList(account.getAccRstrLists()));
        return accountDto;
    }

    protected AccRstrList accRstrListDtoToAccRstrList(AccRstrListDto accRstrListDto) {
        if (accRstrListDto == null) {
            return null;
        }
        AccRstrList accRstrList = new AccRstrList();
        accRstrList.setAccRstr(accRstrListDto.getAccRstr());
        accRstrList.setAccRstrDate(accRstrListDto.getAccRstrDate());
        accRstrList.setSuccessorBIC(accRstrListDto.getSuccessorBIC());
        return accRstrList;
    }

    protected List<AccRstrList> accRstrListDtoListToAccRstrListList(List<AccRstrListDto> list) {
        if (list == null) {
            return null;
        }
        List<AccRstrList> list1 = new ArrayList<AccRstrList>(list.size());
        for (AccRstrListDto accRstrListDto : list) {
            list1.add(accRstrListDtoToAccRstrList(accRstrListDto));
        }
        return list1;
    }

    protected AccRstrListDto accRstrListToAccRstrListDto(AccRstrList accRstrList) {
        if (accRstrList == null) {
            return null;
        }
        AccRstrListDto accRstrListDto = new AccRstrListDto();
        accRstrListDto.setAccRstr(accRstrList.getAccRstr());
        accRstrListDto.setAccRstrDate(accRstrList.getAccRstrDate());
        accRstrListDto.setSuccessorBIC(accRstrList.getSuccessorBIC());
        return accRstrListDto;
    }

    protected List<AccRstrListDto> accRstrListListToAccRstrListDtoList(List<AccRstrList> list) {
        if (list == null) {
            return null;
        }
        List<AccRstrListDto> list1 = new ArrayList<AccRstrListDto>(list.size());
        for (AccRstrList accRstrList : list) {
            list1.add(accRstrListToAccRstrListDto(accRstrList));
        }
        return list1;
    }
}
