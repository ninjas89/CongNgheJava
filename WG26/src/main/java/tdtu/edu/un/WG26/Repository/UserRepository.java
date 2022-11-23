package tdtu.edu.un.WG26.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tdtu.edu.un.WG26.Model.User;


public interface UserRepository extends JpaRepository<User, Long>{
	
}
