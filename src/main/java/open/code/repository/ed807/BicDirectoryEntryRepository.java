package open.code.repository.ed807;

import open.code.model.Ed807.BicDirectoryEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BicDirectoryEntryRepository extends JpaRepository<BicDirectoryEntry, Long> {
    List<BicDirectoryEntry> findAllByBankMessageId(Long id);
}
