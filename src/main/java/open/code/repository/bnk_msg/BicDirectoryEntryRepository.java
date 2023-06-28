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

    Optional<BicDirectoryEntry> findByBankMessageIdAndId(Long msgId, Long bicId);
}