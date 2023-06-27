package open.code.repository;

import jakarta.transaction.Transactional;
import open.code.model.Directory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectoryRepository extends JpaRepository<Directory, Long> {

    @Query("from Directory where directoryType = :directoryType and deleted = false and id > :dicId order by id ASC LIMIT 25")
    List<Directory> findByDirectoryTypeAndDeletedFalse(@Param("directoryType") String directoryType, @Param("dicId") Long dicId);

    @Transactional
    @Modifying
    @Query("UPDATE Directory e SET e.deleted = true, e.deletedAt = CURRENT_TIMESTAMP WHERE e.id = :id")
    void softDelete(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Directory e SET e.deleted = false WHERE e.id = :id")
    void softRecovery(@Param("id") Long id);
}
