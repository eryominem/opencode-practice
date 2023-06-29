package open.code.service.bnk_msg;

import open.code.dto.RstrListDto;
import open.code.mapper.RstrListMapper;
import open.code.repository.bnk_msg.RstrListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RstrListService {
    private final RstrListRepository rstrListRepository;

    private final RstrListMapper rstrListMapper;

    @Autowired
    public RstrListService(RstrListRepository rstrListRepository, RstrListMapper rstrListMapper) {
        this.rstrListRepository = rstrListRepository;
        this.rstrListMapper = rstrListMapper;
    }

    public RstrListDto getRstrListByParticipantId(Long id) {
        return rstrListMapper.toDTO(rstrListRepository.findByParticipantInfoId(id));
    }
}
