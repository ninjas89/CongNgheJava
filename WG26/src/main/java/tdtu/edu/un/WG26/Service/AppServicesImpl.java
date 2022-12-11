package tdtu.edu.un.WG26.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import tdtu.edu.un.WG26.Model.App;
import tdtu.edu.un.WG26.Repository.AppRepository;
import tdtu.edu.un.WG26.web.dto.AppDto;

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

	@Override
	public App save(AppDto appDto) {

		App app = new App(appDto.getGenre(),
				appDto.getTagName(),
				appDto.getAppName(),
				appDto.getDescription(),
				appDto.getPrice(),
				appDto.getPublisher(),
				appDto.getPurchaseTime(),
				appDto.getDownloadPath(),
				appDto.getAvatarPath());

		return appRepository.save(app);

	}

	@Override
	public App findbyAppName(String appName) {
		return appRepository.findByAppName(appName);
	}

	@Override
	public List<App> fetchAppEntertainmentList(String tagName) {
		List<App> apps = appRepository.findByTagName(tagName);
		
		return apps;
	}
}
