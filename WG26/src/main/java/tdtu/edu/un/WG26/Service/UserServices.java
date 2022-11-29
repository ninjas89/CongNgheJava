package tdtu.edu.un.WG26.Service;

import java.util.List;

import tdtu.edu.un.WG26.Model.User;
import tdtu.edu.un.WG26.web.dto.UserRegistrationDto;


public interface UserServices{
	User save(UserRegistrationDto registrationDto);
	List<UserRegistrationDto> findAllUsers();
	User findbyEmail(String email);
}
