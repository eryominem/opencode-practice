package open.code.service.bnk_msg;

import open.code.dto.SWBICSDto;
import open.code.mapper.SWBICSListMapper;
import open.code.model.SWBICS;
import open.code.repository.bnk_msg.SWBICSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SWBICSService {

    private final SWBICSRepository swbicsRepository;

    private final SWBICSListMapper swbicsMapper;

    @Autowired
    public SWBICSService(SWBICSRepository swbicsRepository, SWBICSListMapper swbicsMapper1) {
        this.swbicsRepository = swbicsRepository;
        this.swbicsMapper = swbicsMapper1;
    }

    public List<SWBICSDto> findAllSWBICSByBicId(Long id) {
        List<SWBICS> swbics = swbicsRepository.findAllByBicDirectoryEntryId(id);
        return swbicsMapper.toDTO(swbics);
    }
}
