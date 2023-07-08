package open.code.repository;

import jakarta.transaction.Transactional;
import open.code.model.Directory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectoryRepository extends JpaRepository<Directory, Long>, JpaSpecificationExecutor<Directory> {
    Page<Directory> findAllByDirectoryTypeAndDeletedIsFalse(String directoryType, PageRequest pageRequest);

    Page<Directory> findAllByDirectoryTypeAndDeletedIsTrue(String directoryType, PageRequest pageRequest);

    Page<Directory> findAllByDirectoryTypeAndDeletedIsFalse(String directoryType,
                                                          Specification<Directory> specification,
                                                          Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE Directory d SET d.deleted = true, d.deletedAt = CURRENT_TIMESTAMP WHERE d.id = :id")
    void softDelete(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Directory d SET d.deleted = false WHERE d.id = :id")
    void softRecovery(@Param("id") Long id);
}
