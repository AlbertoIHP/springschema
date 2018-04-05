package back.project;

import org.springframework.data.jpa.repository.JpaRepository;

public interface projectRepository extends JpaRepository<project, Long> {
    //User findByUsername(String username);
}
