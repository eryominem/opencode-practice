package open.code.mapper;

import open.code.dto.BankMessageDto;
import open.code.model.BankMessage;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = {BicDirectoryMapper.class, ParticipantMapper.class, AccountMapper.class, SWBICSMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BankMessageMapper {
    BankMessage toModel(BankMessageDto bankMessageDto);

    BankMessageDto toDTO(BankMessage bankMessage);
}
