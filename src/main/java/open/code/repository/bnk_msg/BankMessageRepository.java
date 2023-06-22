package open.code.repository.bnk_msg;

import open.code.model.BankMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankMessageRepository extends JpaRepository<BankMessage, Long> {
}
