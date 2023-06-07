package open.code.repository.Directory;

import open.code.model.Directory.XchType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XchTypeRepository extends JpaRepository<XchType, Long> {
}
