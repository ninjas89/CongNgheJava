package tdtu.edu.un.WG26.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tdtu.edu.un.WG26.Model.Cart;
import tdtu.edu.un.WG26.Repository.CartRepository;
import tdtu.edu.un.WG26.web.dto.CartDTO;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartRepository cartRepository;

	@Override
	public Cart save(CartDTO cartDTO) {
		Cart cart = new Cart(cartDTO.getEmail(),cartDTO.getAppName(), cartDTO.getGenre(), cartDTO.getTagName(), cartDTO.getDownloadPath());
		return cartRepository.save(cart);
	}

	@Override
	public List<Cart> findAppByEmail(String email) {
		List<Cart> cartItems = cartRepository.findAllByEmail(email);
		return cartItems;
	}

	@Override
	public List<Cart> findAppByEmailAndAppNAme(String email, String appName) {
		List<Cart> items = cartRepository.findByEmailAndAppName(email, appName);
		return items;
	}
	
	
	
	
	
}
