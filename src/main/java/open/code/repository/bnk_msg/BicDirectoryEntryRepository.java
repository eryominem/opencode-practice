package open.code.repository.bnk_msg;

import open.code.model.BicDirectoryEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BicDirectoryEntryRepository extends JpaRepository<BicDirectoryEntry, Long> {

    @Query("select count(*) from BicDirectoryEntry where bankMessage.id = :msgId")
    long count(@Param("msgId") Long msgId);

    @Query("from BicDirectoryEntry where bankMessage.id = :msgId and id > :bicId order by id ASC LIMIT 25")
    List<BicDirectoryEntry> findAll(@Param("msgId") Long msgId, @Param("bicId") Long bicId);

    List<BicDirectoryEntry> findAllByBicAndParticipantInfoNamePAndParticipantInfoPtTypeAndBankMessageId(String bic, String nameP, String ptType, Long id);

    List<BicDirectoryEntry> findAllByBicAndParticipantInfoNamePAndBankMessageId(String bic, String nameP, Long id);

    List<BicDirectoryEntry> findAllByBicAndParticipantInfoPtTypeAndBankMessageId(String bic, String ptType, Long id);

    List<BicDirectoryEntry> findAllByParticipantInfoNamePAndParticipantInfoPtTypeAndBankMessageId(String nameP, String ptType, Long id);

    List<BicDirectoryEntry> findAllByBicAndBankMessageId(String bic, Long id);

    List<BicDirectoryEntry> findAllByParticipantInfoPtTypeAndBankMessageId(String ptType, Long id);

    List<BicDirectoryEntry> findAllByParticipantInfoNamePAndBankMessageId(String nameP, Long id);

    Optional<BicDirectoryEntry> findByBankMessageIdAndId(Long msgId, Long bicId);
}