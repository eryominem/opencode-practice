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
    List<Directory> findByDirectoryTypeAndDeletedFalse(String directoryType);

    @Transactional
    @Modifying
    @Query("UPDATE Directory e SET e.deleted = true, e.deletedAt = CURRENT_TIMESTAMP WHERE e.id = :id")
    void softDelete(@Param("id") Long id);
}
