package open.code.mapper;

import open.code.dto.RstrListDto;
import open.code.model.RstrList;
import org.springframework.stereotype.Component;

@Component
public class RstrListMapper {
    public RstrList toModel(RstrListDto rstrListDto) {
        if (rstrListDto == null) {
            return null;
        }
        RstrList rstrList = new RstrList();
        rstrList.setRstr(rstrListDto.getRstr());
        rstrList.setRstrDate(rstrListDto.getRstrDate());
        return rstrList;
    }

    public RstrListDto toDTO(RstrList rstrList) {
        if (rstrList == null) {
            return null;
        }
        RstrListDto rstrListDto = new RstrListDto();
        rstrListDto.setRstr(rstrList.getRstr());
        rstrListDto.setRstrDate(rstrList.getRstrDate());
        return rstrListDto;
    }
}