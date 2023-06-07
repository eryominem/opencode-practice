package open.code.repository.ed807;

import open.code.model.Ed807.BankMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankMessageRepository extends JpaRepository<BankMessage, Long> {
}
