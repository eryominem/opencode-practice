package open.code.mapper;

import open.code.dto.SWBICSDto;
import open.code.model.SWBICS;
import org.springframework.stereotype.Component;

@Component
public class SWBICSMapper {
    public SWBICS toModel(SWBICSDto swbicsDto) {
        if (swbicsDto == null) {
            return null;
        }
        SWBICS sWBICS = new SWBICS();
        sWBICS.setId(swbicsDto.getId());
        sWBICS.setSwbic(swbicsDto.getSwbic());
        sWBICS.setDefaultSWBIC(swbicsDto.isDefaultSWBIC());
        return sWBICS;
    }

    public SWBICSDto toDTO(SWBICS swbics) {
        if (swbics == null) {
            return null;
        }
        SWBICSDto sWBICSDto = new SWBICSDto();
        sWBICSDto.setId(swbics.getId());
        sWBICSDto.setSwbic(swbics.getSwbic());
        sWBICSDto.setDefaultSWBIC(swbics.isDefaultSWBIC());
        return sWBICSDto;
    }
}
