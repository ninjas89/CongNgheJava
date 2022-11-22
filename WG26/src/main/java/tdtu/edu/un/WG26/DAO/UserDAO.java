package tdtu.edu.un.WG26.DAO;

import java.util.List;

import tdtu.edu.un.WG26.Model.User;


public interface UserDAO {
	
	List<User> get();
	
	User get(String email);
	
	void save(User user);
}
