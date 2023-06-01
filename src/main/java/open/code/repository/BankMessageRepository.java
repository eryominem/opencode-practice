package open.code.repository;

import open.code.model.BankMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankMessageRepository extends JpaRepository<BankMessage, Long> {
}