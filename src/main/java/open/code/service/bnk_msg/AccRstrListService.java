package open.code.service.bnk_msg;

import open.code.dto.AccRstrListDto;
import open.code.mapper.AccountMapper;
import open.code.repository.bnk_msg.AccRstrRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccRstrListService {
    private final AccRstrRepository accRstrRepository;

    private final AccountMapper accountMapper;

    public AccRstrListService(AccRstrRepository accRstrRepository, AccountMapper accountMapper) {
        this.accRstrRepository = accRstrRepository;
        this.accountMapper = accountMapper;
    }

    public List<AccRstrListDto> getAllByAccountId(Long id) {
        return accountMapper.accRstrListListToAccRstrListDtoList(accRstrRepository.findAllByAccountId(id));
    }
}
