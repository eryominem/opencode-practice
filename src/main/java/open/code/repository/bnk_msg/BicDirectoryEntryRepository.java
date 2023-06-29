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
    @Query("from BicDirectoryEntry where bankMessage.id = :msgId and id > :bicId order by id ASC LIMIT 25")
    List<BicDirectoryEntry> findAll(@Param("msgId") Long msgId, @Param("bicId") Long bicId);

    List<BicDirectoryEntry> findAllByBicAndParticipantInfoNamePAndParticipantInfoPtType(String bic, String nameP, String ptType);

    List<BicDirectoryEntry> findAllByBicAndParticipantInfoNameP(String bic, String nameP);

    List<BicDirectoryEntry> findAllByBicAndParticipantInfoPtType(String bic, String ptType);

    List<BicDirectoryEntry> findAllByParticipantInfoNamePAndParticipantInfoPtType(String nameP, String ptType);

    List<BicDirectoryEntry> findAllByBic(String bic);

    List<BicDirectoryEntry> findAllByParticipantInfoPtType(String ptType);

    List<BicDirectoryEntry> findAllByParticipantInfoNameP(String nameP);

    Optional<BicDirectoryEntry> findByBankMessageIdAndId(Long msgId, Long bicId);
}