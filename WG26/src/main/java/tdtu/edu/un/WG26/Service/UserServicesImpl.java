package tdtu.edu.un.WG26.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tdtu.edu.un.WG26.Model.Role;
import tdtu.edu.un.WG26.Model.User;
import tdtu.edu.un.WG26.Repository.RoleRepository;
import tdtu.edu.un.WG26.Repository.UserRepository;
import tdtu.edu.un.WG26.config.LoadUserDetail;
import tdtu.edu.un.WG26.web.dto.UserRegistrationDto;

@Service
public class UserServicesImpl implements UserServices,UserDetailsService {
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passEncoder;
	
	public UserServicesImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passEncoder = passEncoder;
	}
	

	@Override
	public User save(UserRegistrationDto registrationDto) {
		String passwordHashed = passEncoder.encode(registrationDto.getPassword());
		DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		User user = new User(registrationDto.getEmail(), 
				registrationDto.getLastName(), 
				registrationDto.getFirstName(),
				LocalDateTime.now().format(formatDateTime),
				registrationDto.getGender(),
				passwordHashed
				);
		
		Role role = roleRepository.findByRole("USER");
		if(role == null) {
			role = checkRole();
		}
		user.setRole(role);
		return userRepository.save(user);
		
	}
	
	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	public List<UserRegistrationDto> findAllUsers(){
		List<User> users = userRepository.findAll();
		return users.stream()
				.map((user)-> mapToUserRegistrationDto(user))
				.collect(Collectors.toList());
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("");
        }
		return new LoadUserDetail(user);
	}
	
	private UserRegistrationDto mapToUserRegistrationDto(User user) {
		UserRegistrationDto userDto = new UserRegistrationDto();
		String str = user.getFirstName();
		userDto.setFirstName(str);
		userDto.setEmail(user.getEmail());
		return userDto;
	}
	
	
	private Role checkRole() {
		Role role = new Role();
		role.setRole("ADMIN");
		return roleRepository.save(role);
	}
}