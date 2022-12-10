package tdtu.edu.un.WG26.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import tdtu.edu.un.WG26.Model.App;
import tdtu.edu.un.WG26.Service.AppServices;
import tdtu.edu.un.WG26.Service.UserServices;
import tdtu.edu.un.WG26.config.LoadUserDetail;


@Controller
public class IndexController {
	
	@Autowired
	private AppServices appServices;
	
	@Autowired
	private UserServices userServices;
	
	@GetMapping("/home")
	public String getUserHome(@AuthenticationPrincipal LoadUserDetail userDetail,Model model) {
		List<App> listApp = appServices.fetchAppList();
		if(userDetail == null) {
			return"redirect: /home?";
		}
		else {
			String username = userDetail.getUsername();
			model.addAttribute("listApp", listApp);
			model.addAttribute("username",username);
			System.out.println(username);
			return "home";
		}
	}
	
	@GetMapping("/home/{appName}")
	public String getAppInformation(@PathVariable("appName") String appName, Model model) {
		App appInfo= appServices.findbyAppName(appName);
		
		model.addAttribute("appInfo", appInfo);
		
		return "appinformation";
	}
	
	@GetMapping("/home/app-entertainment")
	public String getAppEntertainmentHomepage(Model model) {
		String tagName = "game";
		
		List<App> appList = appServices.fetchAppEntertainmentList(tagName);
		
		model.addAttribute("appList", appList);
		
		return "appentertainment";
	}
	
	@GetMapping("/home/app-book")
	public String getAppBookHomepage(Model model) {
		String tagName = "sach";
		
		List<App> appList = appServices.fetchAppEntertainmentList(tagName);
		
		model.addAttribute("appList", appList);
		
		return "appbook";
	}
	
	@GetMapping("/home/app-film")
	public String getAppFilmHomepage(Model model) {
		String tagName = "phim";
		
		List<App> appList = appServices.fetchAppEntertainmentList(tagName);
		
		model.addAttribute("appList", appList);
		
		return "appfilm";
	}
	
}

