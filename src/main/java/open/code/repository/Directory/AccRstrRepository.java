package open.code.repository.Directory;

import open.code.model.Directory.AccRstr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccRstrRepository extends JpaRepository<AccRstr, Long> {
}
