package back.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import back.security.model.User;


public interface UserRepository extends JpaRepository<User, Long> 
{
    User findByUsername(String username);
}
