package tdtu.edu.un.WG26.Service;

import java.util.List;

import tdtu.edu.un.WG26.Model.User;


public interface UserServices {
	
	List<User> get();
	
	User get(String email);
	
	void save(User user);
}
