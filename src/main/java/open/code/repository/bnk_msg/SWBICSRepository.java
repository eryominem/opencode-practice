package open.code.repository.bnk_msg;

import open.code.model.SWBICS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SWBICSRepository extends JpaRepository<SWBICS, Long> {
    List<SWBICS> findAllByBicDirectoryEntryId(Long id);
}
