package open.code.mapper;

import open.code.dto.ParticipantInfoDto;
import open.code.dto.RstrListDto;
import open.code.model.ParticipantInfo;
import open.code.model.RstrList;
import org.springframework.stereotype.Component;

@Component
public class ParticipantMapper {
    public ParticipantInfo toModel(ParticipantInfoDto participantInfoDto) {
        if (participantInfoDto == null) {
            return null;
        }
        ParticipantInfo participantInfo = new ParticipantInfo();
        participantInfo.setId(participantInfoDto.getId());
        participantInfo.setNameP(participantInfoDto.getNameP());
        participantInfo.setEnglName(participantInfoDto.getEnglName());
        participantInfo.setRegN(participantInfoDto.getRegN());
        participantInfo.setCntrCd(participantInfoDto.getCntrCd());
        participantInfo.setRgn(participantInfoDto.getRgn());
        participantInfo.setInd(participantInfoDto.getInd());
        participantInfo.setTnp(participantInfoDto.getTnp());
        participantInfo.setNnp(participantInfoDto.getNnp());
        participantInfo.setAdr(participantInfoDto.getAdr());
        participantInfo.setPrntBIC(participantInfoDto.getPrntBIC());
        participantInfo.setDateIn(participantInfoDto.getDateIn());
        participantInfo.setDateOut(participantInfoDto.getDateOut());
        participantInfo.setPtType(participantInfoDto.getPtType());
        participantInfo.setSrvcs(participantInfoDto.getSrvcs());
        participantInfo.setXchType(participantInfoDto.getXchType());
        participantInfo.setUid(participantInfoDto.getUid());
        participantInfo.setParticipantStatus(participantInfoDto.getParticipantStatus());
        participantInfo.setRstrList(rstrListDtoToRstrList(participantInfoDto.getRstrList()));
        return participantInfo;
    }

    public ParticipantInfoDto toDTO(ParticipantInfo participantInfo) {
        if (participantInfo == null) {
            return null;
        }
        ParticipantInfoDto participantInfoDto = new ParticipantInfoDto();
        participantInfoDto.setId(participantInfo.getId());
        participantInfoDto.setNameP(participantInfo.getNameP());
        participantInfoDto.setEnglName(participantInfo.getEnglName());
        participantInfoDto.setRegN(participantInfo.getRegN());
        participantInfoDto.setCntrCd(participantInfo.getCntrCd());
        participantInfoDto.setRgn(participantInfo.getRgn());
        participantInfoDto.setInd(participantInfo.getInd());
        participantInfoDto.setTnp(participantInfo.getTnp());
        participantInfoDto.setNnp(participantInfo.getNnp());
        participantInfoDto.setAdr(participantInfo.getAdr());
        participantInfoDto.setPrntBIC(participantInfo.getPrntBIC());
        participantInfoDto.setDateIn(participantInfo.getDateIn());
        participantInfoDto.setDateOut(participantInfo.getDateOut());
        participantInfoDto.setPtType(participantInfo.getPtType());
        participantInfoDto.setSrvcs(participantInfo.getSrvcs());
        participantInfoDto.setXchType(participantInfo.getXchType());
        participantInfoDto.setUid(participantInfo.getUid());
        participantInfoDto.setParticipantStatus(participantInfo.getParticipantStatus());
        participantInfoDto.setRstrList(rstrListToRstrListDto(participantInfo.getRstrList()));
        return participantInfoDto;
    }

    protected RstrList rstrListDtoToRstrList(RstrListDto rstrListDto) {
        if (rstrListDto == null) {
            return null;
        }
        RstrList rstrList = new RstrList();
        rstrList.setRstr(rstrListDto.getRstr());
        rstrList.setRstrDate(rstrListDto.getRstrDate());
        return rstrList;
    }

    protected RstrListDto rstrListToRstrListDto(RstrList rstrList) {
        if (rstrList == null) {
            return null;
        }
        RstrListDto rstrListDto = new RstrListDto();
        rstrListDto.setRstr(rstrList.getRstr());
        rstrListDto.setRstrDate(rstrList.getRstrDate());
        return rstrListDto;
    }
}