package tdtu.edu.un.WG26.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import tdtu.edu.un.WG26.Model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Override
	public List<tdtu.edu.un.WG26.Model.User> get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public tdtu.edu.un.WG26.Model.User get(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		
	}
}
