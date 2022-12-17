package tdtu.edu.un.WG26.Service;

import java.util.List;

import tdtu.edu.un.WG26.Model.Cart;
import tdtu.edu.un.WG26.web.dto.CartDTO;


public interface CartService {
	List<Cart> findAppByEmail(String email);
	List<Cart> findAppByEmailAndAppNAme(String email, String appName);
	Cart save(CartDTO cartDTO);

}
