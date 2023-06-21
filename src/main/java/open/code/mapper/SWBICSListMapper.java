package open.code.mapper;

import open.code.dto.SWBICSDto;
import open.code.model.SWBICS;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = SWBICSMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SWBICSListMapper {
    List<SWBICS> toModelList(List<SWBICSDto> swbicsDtoList);
    List<SWBICSDto> toDTO(List<SWBICS> swbicsList);
}
