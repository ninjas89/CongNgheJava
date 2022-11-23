package tdtu.edu.un.WG26.Service;

import tdtu.edu.un.WG26.Model.User;
import tdtu.edu.un.WG26.web.dto.UserRegistrationDto;


public interface UserServices {
	User save(UserRegistrationDto registrationDto);
}
