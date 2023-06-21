package open.code.mapper;

import open.code.dto.AccountDto;
import open.code.model.Account;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = AccountMapper.class,  injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AccountListMapper {
    List<Account> toModelList(List<AccountDto> accountDtoList);
    List<AccountDto> toDTOList(List<Account> accountList);
}
