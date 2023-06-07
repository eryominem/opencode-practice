package open.code.repository.Directory;

import open.code.model.Directory.ChangeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangeTypeRepository extends JpaRepository<ChangeType, Long> {
}
