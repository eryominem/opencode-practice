package open.code.repository.Directory;

import open.code.model.Directory.PtType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PtTypeRepository extends JpaRepository<PtType, Long> {
}
