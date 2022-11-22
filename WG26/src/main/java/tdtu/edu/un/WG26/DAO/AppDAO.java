package tdtu.edu.un.WG26.DAO;

import java.util.List;

import tdtu.edu.un.WG26.Model.App;



public interface AppDAO {

	List<App> get();
	
	App get(Integer id);
	
	void save(App app);
}
