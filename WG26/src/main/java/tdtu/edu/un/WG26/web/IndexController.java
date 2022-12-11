package tdtu.edu.un.WG26.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.PathVariable;

import tdtu.edu.un.WG26.Model.App;
import tdtu.edu.un.WG26.Model.User;
import tdtu.edu.un.WG26.Service.AppServices;
import tdtu.edu.un.WG26.Service.UserServices;
import tdtu.edu.un.WG26.config.LoadUserDetail;


@Controller
@RequestMapping("/home")
public class IndexController {
	
	@Autowired
	private AppServices appServices;
	
	@Autowired
	private UserServices userServices;
	@RequestMapping("")
	public String getHomePage(Model model) {
		List<App> listApp = appServices.fetchAppList();
		model.addAttribute("listApp", listApp);
		return "home";
	}
	
	@RequestMapping("/login")
	public String getUserHome(@AuthenticationPrincipal LoadUserDetail userDetail,Model model) {
			if(userDetail == null) {
				return "redirect:/home";
			}
			else {
			List<App> listApp = appServices.fetchAppList();
			String username = userDetail.getUsername();
			model.addAttribute("listApp",listApp);
			model.addAttribute("username",username);
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
	public String getAppEntertainmentHomepage(@AuthenticationPrincipal LoadUserDetail userDetail, Model model) {
		String tagName = "game";
		String username = userDetail.getUsername();
		
		List<App> appList = appServices.fetchAppEntertainmentList(tagName);
		
		model.addAttribute("appList", appList);
		model.addAttribute("username",username);
		
		return "appentertainment";
	}
	
	@GetMapping("/home/app-book")
	public String getAppBookHomepage(@AuthenticationPrincipal LoadUserDetail userDetail, Model model) {
		String tagName = "sach";
		String username = userDetail.getUsername();
		
		List<App> appList = appServices.fetchAppEntertainmentList(tagName);
		
		model.addAttribute("appList", appList);
		model.addAttribute("username",username);
		
		return "appbook";
	}
	
	@GetMapping("/home/app-film")
	public String getAppFilmHomepage(@AuthenticationPrincipal LoadUserDetail userDetail, Model model) {
		String tagName = "phim";
		String username = userDetail.getUsername();
		
		List<App> appList = appServices.fetchAppEntertainmentList(tagName);
		
		model.addAttribute("appList", appList);
		model.addAttribute("username",username);
		
		return "appfilm";
	}
	
	@GetMapping("/home/account")
	public String getUserInfo(@AuthenticationPrincipal LoadUserDetail userDetail, Model model) {
		String email = userDetail.getUsername();
		
		User user = userServices.findByEmail(email);

		model.addAttribute("userInfo", user);
		
		return "userform";
	}
}

