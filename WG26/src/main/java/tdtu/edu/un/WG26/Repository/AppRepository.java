package tdtu.edu.un.WG26.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tdtu.edu.un.WG26.Model.App;

@Repository
public interface AppRepository extends JpaRepository<App, Long>{
	public App findByAppName(String appName);
	
	public List<App> findByGenre(String genre);
}
