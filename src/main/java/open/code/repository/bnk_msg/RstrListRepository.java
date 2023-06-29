package open.code.repository.bnk_msg;

import open.code.model.RstrList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RstrListRepository extends JpaRepository<RstrList, Long> {
    RstrList findByParticipantInfoId(Long id);
}
