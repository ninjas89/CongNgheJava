package tdtu.edu.un.WG26.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import tdtu.edu.un.WG26.Model.App;
import tdtu.edu.un.WG26.Repository.AppRepository;

@Service
public class AppServicesImpl implements AppServices{

	private AppRepository appRepository;
	
	public AppServicesImpl (AppRepository appRepository) {
		this.appRepository = appRepository; 
	}
	
	@Override
	public List<App> fetchAppList() {
		List<App> apps = appRepository.findAll();
		
		return apps;
	}

}
