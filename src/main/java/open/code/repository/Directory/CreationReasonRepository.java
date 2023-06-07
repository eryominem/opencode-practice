package open.code.repository.Directory;

import open.code.model.Directory.CreationReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreationReasonRepository extends JpaRepository<CreationReason, Long> {
}
