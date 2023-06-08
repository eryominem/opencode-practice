package open.code.repository;

import open.code.model.Directory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectoryRepository extends JpaRepository<Directory, Long> {
    List<Directory> findAllByDirectoryType(String directoryType);

}
