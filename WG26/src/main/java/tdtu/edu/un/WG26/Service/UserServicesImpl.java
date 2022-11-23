package tdtu.edu.un.WG26.Service;

import org.springframework.stereotype.Service;
import tdtu.edu.un.WG26.Model.User;
import tdtu.edu.un.WG26.Repository.UserRepository;
import tdtu.edu.un.WG26.web.dto.UserRegistrationDto;

@Service
public class UserServicesImpl implements UserServices {
	private UserRepository userRepository;
	
	public UserServicesImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getEmail(), 
				registrationDto.getLastName(), 
				registrationDto.getFirstName(), 
				registrationDto.getGender(), 
				registrationDto.getPassword());
		
		return userRepository.save(user);
	}
	
}
