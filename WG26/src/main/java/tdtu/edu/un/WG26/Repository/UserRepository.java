package tdtu.edu.un.WG26.Repository;

import java.util.List;

import tdtu.edu.un.WG26.Model.User;


public interface UserRepository {
	
	List<User> get();
	
	User get(String email);
	
	void save(User user);
}
