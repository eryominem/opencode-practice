package open.code.repository.bnk_msg;

import open.code.model.AccRstrList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccRstrRepository extends JpaRepository<AccRstrList, Long> {
    List<AccRstrList> findAllByAccountId(Long id);
}
