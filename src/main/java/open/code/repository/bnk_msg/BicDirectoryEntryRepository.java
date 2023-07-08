package open.code.repository.bnk_msg;

import open.code.model.BicDirectoryEntry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BicDirectoryEntryRepository extends JpaRepository<BicDirectoryEntry, Long>, JpaSpecificationExecutor<BicDirectoryEntry> {
    long countByBankMessageId(Long msgId);

    Page<BicDirectoryEntry> findAllByBankMessageId(Long msgId, PageRequest pageRequest);

    List<BicDirectoryEntry> findAllByBicAndParticipantInfoNamePAndParticipantInfoPtTypeAndBankMessageId(String bic, String nameP, String ptType, Long id);

    List<BicDirectoryEntry> findAllByBicAndParticipantInfoNamePAndBankMessageId(String bic, String nameP, Long id);

    List<BicDirectoryEntry> findAllByBicAndParticipantInfoPtTypeAndBankMessageId(String bic, String ptType, Long id);

    List<BicDirectoryEntry> findAllByParticipantInfoNamePAndParticipantInfoPtTypeAndBankMessageId(String nameP, String ptType, Long id);

    List<BicDirectoryEntry> findAllByBicAndBankMessageId(String bic, Long id);

    List<BicDirectoryEntry> findAllByParticipantInfoPtTypeAndBankMessageId(String ptType, Long id);

    List<BicDirectoryEntry> findAllByParticipantInfoNamePAndBankMessageId(String nameP, Long id);
}