package tdtu.edu.un.WG26.Service;

import tdtu.edu.un.WG26.Model.App;
import tdtu.edu.un.WG26.web.dto.AppDto;

import java.util.List;

public interface AppServices {

	List<App> fetchAppList();

	App save(AppDto appDto);
	
	App findbyAppName(String appName); 
	
	List<App> fetchAppEntertainmentList(String tagName);
}
 