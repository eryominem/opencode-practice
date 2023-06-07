package open.code.repository.Directory;

import open.code.model.Directory.InfoTypeCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoTypeCodeRepository extends JpaRepository<InfoTypeCode, Long> {
}
