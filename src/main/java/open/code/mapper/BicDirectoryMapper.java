package open.code.mapper;

import open.code.dto.*;
import open.code.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BicDirectoryMapper {

    public BicDirectoryEntry toModel(BicDirectoryEntryDto bicDirectoryEntryDto) {
        if (bicDirectoryEntryDto == null) {
            return null;
        }
        BicDirectoryEntry.BicDirectoryEntryBuilder bicDirectoryEntry = BicDirectoryEntry.builder();
        bicDirectoryEntry.id(bicDirectoryEntryDto.getId());
        bicDirectoryEntry.bic(bicDirectoryEntryDto.getBic());
        bicDirectoryEntry.changeType(bicDirectoryEntryDto.getChangeType());
        bicDirectoryEntry.participantInfo(participantInfoDtoToParticipantInfo(bicDirectoryEntryDto.getParticipantInfo()));
        bicDirectoryEntry.accounts(accountDtoListToAccountList(bicDirectoryEntryDto.getAccounts()));
        bicDirectoryEntry.swbics(sWBICSDtoListToSWBICSList(bicDirectoryEntryDto.getSwbics()));
        return bicDirectoryEntry.build();
    }

    public BicDirectoryEntryDto toDTO(BicDirectoryEntry bicDirectoryEntry) {
        if (bicDirectoryEntry == null) {
            return null;
        }
        BicDirectoryEntryDto bicDirectoryEntryDto = new BicDirectoryEntryDto();
        bicDirectoryEntryDto.setId(bicDirectoryEntry.getId());
        bicDirectoryEntryDto.setBic(bicDirectoryEntry.getBic());
        bicDirectoryEntryDto.setChangeType(bicDirectoryEntry.getChangeType());
        bicDirectoryEntryDto.setParticipantInfo(participantInfoToParticipantInfoDto(bicDirectoryEntry.getParticipantInfo()));
        bicDirectoryEntryDto.setAccounts(accountListToAccountDtoList(bicDirectoryEntry.getAccounts()));
        bicDirectoryEntryDto.setSwbics(sWBICSListToSWBICSDtoList(bicDirectoryEntry.getSwbics()));
        return bicDirectoryEntryDto;
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

    protected ParticipantInfo participantInfoDtoToParticipantInfo(ParticipantInfoDto participantInfoDto) {
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

    protected AccRstrList accRstrListDtoToAccRstrList(AccRstrListDto accRstrListDto) {
        if (accRstrListDto == null) {
            return null;
        }
        AccRstrList accRstrList = new AccRstrList();
        accRstrList.setAccRstr(accRstrListDto.getAccRstr());
        accRstrList.setAccRstrDate(accRstrListDto.getAccRstrDate());
        accRstrList.setSuccessorBIC(accRstrListDto.getSuccessorBIC());
        return accRstrList;
    }

    protected List<AccRstrList> accRstrListDtoListToAccRstrListList(List<AccRstrListDto> list) {
        if (list == null) {
            return null;
        }
        List<AccRstrList> list1 = new ArrayList<AccRstrList>(list.size());
        for (AccRstrListDto accRstrListDto : list) {
            list1.add(accRstrListDtoToAccRstrList(accRstrListDto));
        }
        return list1;
    }

    protected Account accountDtoToAccount(AccountDto accountDto) {
        if (accountDto == null) {
            return null;
        }
        Account account = new Account();
        account.setAccount(accountDto.getAccount());
        account.setRegulationAccountType(accountDto.getRegulationAccountType());
        account.setCk(accountDto.getCk());
        account.setAccountCBRBIC(accountDto.getAccountCBRBIC());
        account.setDateIn(accountDto.getDateIn());
        account.setAccountStatus(accountDto.getAccountStatus());
        account.setAccRstrLists(accRstrListDtoListToAccRstrListList(accountDto.getAccRstrLists()));
        return account;
    }

    protected List<Account> accountDtoListToAccountList(List<AccountDto> list) {
        if (list == null) {
            return null;
        }
        List<Account> list1 = new ArrayList<Account>(list.size());
        for (AccountDto accountDto : list) {
            list1.add(accountDtoToAccount(accountDto));
        }
        return list1;
    }

    protected SWBICS sWBICSDtoToSWBICS(SWBICSDto sWBICSDto) {
        if (sWBICSDto == null) {
            return null;
        }
        SWBICS sWBICS = new SWBICS();
        sWBICS.setId(sWBICSDto.getId());
        sWBICS.setSwbic(sWBICSDto.getSwbic());
        sWBICS.setDefaultSWBIC(sWBICSDto.isDefaultSWBIC());
        return sWBICS;
    }

    protected List<SWBICS> sWBICSDtoListToSWBICSList(List<SWBICSDto> list) {
        if (list == null) {
            return null;
        }
        List<SWBICS> list1 = new ArrayList<SWBICS>(list.size());
        for (SWBICSDto sWBICSDto : list) {
            list1.add(sWBICSDtoToSWBICS(sWBICSDto));
        }
        return list1;
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

    protected ParticipantInfoDto participantInfoToParticipantInfoDto(ParticipantInfo participantInfo) {
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

    protected AccRstrListDto accRstrListToAccRstrListDto(AccRstrList accRstrList) {
        if (accRstrList == null) {
            return null;
        }
        AccRstrListDto accRstrListDto = new AccRstrListDto();
        accRstrListDto.setAccRstr(accRstrList.getAccRstr());
        accRstrListDto.setAccRstrDate(accRstrList.getAccRstrDate());
        accRstrListDto.setSuccessorBIC(accRstrList.getSuccessorBIC());
        return accRstrListDto;
    }

    protected List<AccRstrListDto> accRstrListListToAccRstrListDtoList(List<AccRstrList> list) {
        if (list == null) {
            return null;
        }
        List<AccRstrListDto> list1 = new ArrayList<AccRstrListDto>(list.size());
        for (AccRstrList accRstrList : list) {
            list1.add(accRstrListToAccRstrListDto(accRstrList));
        }
        return list1;
    }

    protected AccountDto accountToAccountDto(Account account) {
        if (account == null) {
            return null;
        }
        AccountDto accountDto = new AccountDto();
        accountDto.setAccount(account.getAccount());
        accountDto.setRegulationAccountType(account.getRegulationAccountType());
        accountDto.setCk(account.getCk());
        accountDto.setAccountCBRBIC(account.getAccountCBRBIC());
        accountDto.setDateIn(account.getDateIn());
        accountDto.setAccountStatus(account.getAccountStatus());
        accountDto.setAccRstrLists(accRstrListListToAccRstrListDtoList(account.getAccRstrLists()));
        return accountDto;
    }

    protected List<AccountDto> accountListToAccountDtoList(List<Account> list) {
        if (list == null) {
            return null;
        }
        List<AccountDto> list1 = new ArrayList<AccountDto>(list.size());
        for (Account account : list) {
            list1.add(accountToAccountDto(account));
        }
        return list1;
    }

    protected SWBICSDto sWBICSToSWBICSDto(SWBICS sWBICS) {
        if (sWBICS == null) {
            return null;
        }
        SWBICSDto sWBICSDto = new SWBICSDto();
        sWBICSDto.setId(sWBICS.getId());
        sWBICSDto.setSwbic(sWBICS.getSwbic());
        sWBICSDto.setDefaultSWBIC(sWBICS.isDefaultSWBIC());
        return sWBICSDto;
    }

    protected List<SWBICSDto> sWBICSListToSWBICSDtoList(List<SWBICS> list) {
        if (list == null) {
            return null;
        }
        List<SWBICSDto> list1 = new ArrayList<SWBICSDto>(list.size());
        for (SWBICS sWBICS : list) {
            list1.add(sWBICSToSWBICSDto(sWBICS));
        }
        return list1;
    }
}
