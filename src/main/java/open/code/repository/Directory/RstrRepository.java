package open.code.repository.Directory;

import open.code.model.Directory.Rstr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RstrRepository extends JpaRepository<Rstr, Long> {
}
