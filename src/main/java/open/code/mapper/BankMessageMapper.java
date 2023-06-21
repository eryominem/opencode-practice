package open.code.mapper;

import open.code.dto.BankMessageDto;
import open.code.model.BankMessage;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = {BicDirectoryMapper.class, ParticipantMapper.class, AccountMapper.class, SWBICSMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BankMessageMapper {

    @Mapping(target = "eDNo", source = "EDNo")
    @Mapping(target = "eDDate", source = "EDDate")
    @Mapping(target = "eDAuthor", source = "EDAuthor")
    @Mapping(target = "eDReceiver", source = "EDReceiver")
    BankMessage toModel(BankMessageDto bankMessageDto);

    BankMessageDto toDTO(BankMessage bankMessage);
}
