package open.code.repository.bnk_msg;

import jakarta.transaction.Transactional;
import open.code.model.BankMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankMessageRepository extends JpaRepository<BankMessage, Long> {
    List<BankMessage> findByDeletedFalse();

    @Transactional
    @Modifying
    @Query("UPDATE BankMessage bm SET bm.deleted = true, bm.deletedAt = CURRENT_TIMESTAMP WHERE bm.id = :id")
    void softDelete(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE BankMessage bm SET bm.deleted = false WHERE bm.id = :id")
    void softRecovery(@Param("id") Long id);
}
