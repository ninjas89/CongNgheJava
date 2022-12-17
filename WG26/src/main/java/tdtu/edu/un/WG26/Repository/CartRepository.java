package tdtu.edu.un.WG26.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tdtu.edu.un.WG26.Model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{
	public List<Cart> findAllByEmail(String email);
	public List<Cart> findByEmailAndAppName(String email,String AppName);
}
