package open.code.mapper;

import open.code.dto.AccRstrListDto;
import open.code.model.AccRstrList;

import java.util.List;

/*
@Mapper(componentModel = "spring", uses = AccountMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
*/
public interface AccRstrListMapper {
    AccRstrList toModel(AccRstrListDto accRstrListDto);
    AccRstrListMapper toDTO(AccRstrList accRstrList);

    List<AccRstrList> toModelList(List<AccRstrListDto> accRstrListDtos);
    List<AccRstrListDto> toDTOList(List<AccRstrList> accRstrLists);
}
