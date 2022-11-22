package tdtu.edu.un.WG26.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tdtu.edu.un.WG26.Model.User;

@Service
public class UserServicesImplement implements UserServices {
	
	@Transactional 	// Rollback thao tac truoc khi loi 
	@Override
	public List<User> get() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional 
	@Override
	public User get(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional 
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		
	}

}
