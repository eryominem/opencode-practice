package open.code.mapper;

import open.code.dto.ParticipantInfoDto;
import open.code.model.ParticipantInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ParticipantMapper {
    ParticipantInfo toModel(ParticipantInfoDto participantInfoDto);
    ParticipantInfoDto toDTO(ParticipantInfo participantInfo);
}
