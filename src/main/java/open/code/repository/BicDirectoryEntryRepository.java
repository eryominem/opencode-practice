package open.code.repository;

import open.code.model.BicDirectoryEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BicDirectoryEntryRepository extends JpaRepository<BicDirectoryEntry, Long> {
}
