package open.code.service;

import open.code.repository.Directory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectoryService {
    private final AccountStatusRepository accountStatusRepository;
    private final AccRstrRepository accRstrRepository;
    private final ChangeTypeRepository changeTypeRepository;
    private final CreationReasonRepository creationReasonRepository;
    private final InfoTypeCodeRepository infoTypeCodeRepository;
    private final ParticipantStatusRepository participantStatusRepository;
    private final PtTypeRepository ptTypeRepository;
    private final RegulationAccountTypeRepository regulationAccountTypeRepository;
    private final RstrRepository rstrRepository;
    private final SrvcsRepository srvcsRepository;
    private final XchTypeRepository xchTypeRepository;

    @Autowired
    public DirectoryService(AccountStatusRepository accountStatusRepository, AccRstrRepository accRstrRepository,
                            ChangeTypeRepository changeTypeRepository, CreationReasonRepository creationReasonRepository,
                            InfoTypeCodeRepository infoTypeCodeRepository, ParticipantStatusRepository participantStatusRepository,
                            PtTypeRepository ptTypeRepository, RegulationAccountTypeRepository regulationAccountTypeRepository,
                            RstrRepository rstrRepository, SrvcsRepository srvcsRepository, XchTypeRepository xchTypeRepository) {
        this.accountStatusRepository = accountStatusRepository;
        this.accRstrRepository = accRstrRepository;
        this.changeTypeRepository = changeTypeRepository;
        this.creationReasonRepository = creationReasonRepository;
        this.infoTypeCodeRepository = infoTypeCodeRepository;
        this.participantStatusRepository = participantStatusRepository;
        this.ptTypeRepository = ptTypeRepository;
        this.regulationAccountTypeRepository = regulationAccountTypeRepository;
        this.rstrRepository = rstrRepository;
        this.srvcsRepository = srvcsRepository;
        this.xchTypeRepository = xchTypeRepository;
    }
}
