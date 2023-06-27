package open.code.mapper;

import open.code.dto.SWBICSDto;
import open.code.model.SWBICS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SWBICSListMapper {
    private final SWBICSMapper sWBICSMapper;

    @Autowired
    public SWBICSListMapper(SWBICSMapper sWBICSMapper) {

        this.sWBICSMapper = sWBICSMapper;
    }

    public List<SWBICS> toModelList(List<SWBICSDto> swbicsDtoList) {
        if (swbicsDtoList == null) {
            return null;
        }
        List<SWBICS> list = new ArrayList<SWBICS>(swbicsDtoList.size());
        for (SWBICSDto sWBICSDto : swbicsDtoList) {
            list.add(sWBICSMapper.toModel(sWBICSDto));
        }
        return list;
    }

    public List<SWBICSDto> toDTO(List<SWBICS> swbicsList) {
        if (swbicsList == null) {
            return null;
        }
        List<SWBICSDto> list = new ArrayList<SWBICSDto>(swbicsList.size());
        for (SWBICS sWBICS : swbicsList) {
            list.add(sWBICSMapper.toDTO(sWBICS));
        }
        return list;
    }
}
