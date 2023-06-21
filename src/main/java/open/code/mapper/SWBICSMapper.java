package open.code.mapper;

import open.code.dto.SWBICSDto;
import open.code.model.SWBICS;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SWBICSMapper {
    SWBICS toModel(SWBICSDto swbicsDto);
    SWBICSDto toDTO(SWBICS swbics);
}
