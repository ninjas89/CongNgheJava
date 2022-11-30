package tdtu.edu.un.WG26.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tdtu.edu.un.WG26.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
}