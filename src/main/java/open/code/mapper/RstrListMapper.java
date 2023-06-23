package open.code.mapper;

import open.code.dto.RstrListDto;
import open.code.model.RstrList;
import open.code.v2.RstrListType;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = ParticipantMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RstrListMapper {
    RstrList toModel(RstrListDto rstrListDto);
    RstrListDto toDTO(RstrList rstrList);
}
