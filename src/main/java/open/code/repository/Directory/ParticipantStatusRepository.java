package open.code.repository.Directory;

import open.code.model.Directory.ParticipantStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantStatusRepository extends JpaRepository<ParticipantStatus, Long> {
}
