package tdtu.edu.un.WG26.Service;

import java.util.List;

import tdtu.edu.un.WG26.Model.User;
import tdtu.edu.un.WG26.web.dto.UserChangePassDTO;
import tdtu.edu.un.WG26.web.dto.UserRegistrationDto;


public interface UserServices{
	User save(UserRegistrationDto registrationDto);
	List<UserRegistrationDto> findAllUsers();
	User findByEmail(String email);
	void deleteUserById(Long userId);
	User update(User user);
	User changePassword(UserChangePassDTO userChangePassDTO);
}
