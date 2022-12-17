package tdtu.edu.un.WG26.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tdtu.edu.un.WG26.Model.Role;
import tdtu.edu.un.WG26.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	public User findByEmail(String email);
	public List<User> findAllByRole(Role role);
}
