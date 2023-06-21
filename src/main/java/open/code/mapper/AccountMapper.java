package open.code.mapper;

import open.code.dto.AccountDto;
import open.code.model.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    Account toModel(AccountDto accountDto);
    AccountDto toDTO(Account account);
}
