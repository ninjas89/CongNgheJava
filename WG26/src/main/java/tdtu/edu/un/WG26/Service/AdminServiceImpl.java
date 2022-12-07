package tdtu.edu.un.WG26.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tdtu.edu.un.WG26.Model.User;
import tdtu.edu.un.WG26.Repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminServices {
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> fetchAllUser() {
		List<User> allUser = userRepository.findAll();

		return allUser;
	}
	
}
