package open.code.repository.Directory;

import open.code.model.Directory.RegulationAccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegulationAccountTypeRepository extends JpaRepository<RegulationAccountType, Long> {
}
