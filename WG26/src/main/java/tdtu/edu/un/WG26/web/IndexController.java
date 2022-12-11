package tdtu.edu.un.WG26.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import tdtu.edu.un.WG26.Model.App;
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
			System.out.println(username);
			return "home";
			}
	}
}

