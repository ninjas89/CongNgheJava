package tdtu.edu.un.WG26.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import tdtu.edu.un.WG26.Model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(String role);
}
