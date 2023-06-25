package open.code.mapper;

import open.code.dto.RstrListDto;
import open.code.model.RstrList;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = ParticipantMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RstrListMapper {
    RstrList toModel(RstrListDto rstrListDto);
    RstrListDto toDTO(RstrList rstrList);
}
