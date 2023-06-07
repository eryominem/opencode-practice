package open.code.repository.Directory;

import open.code.model.Directory.Srvcs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SrvcsRepository extends JpaRepository<Srvcs, Long> {
}
