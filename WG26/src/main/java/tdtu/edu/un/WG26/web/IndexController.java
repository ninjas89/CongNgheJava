package tdtu.edu.un.WG26.web;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public String getUserHome(@AuthenticationPrincipal LoadUserDetail userDetail,Model model,@RequestParam("pid") int pid) {
			if(userDetail != null) {
				String username = userDetail.getUsername();
				model.addAttribute("username",username);
			}
			else if(userDetail == null && pid == 1) {
				return "redirect:/home?pid=0";
			}
			List<App> appList = appServices.fetchAppList();
			model.addAttribute("appList",appList);
			model.addAttribute("pid",pid);
			return "home";
	}
	
	@GetMapping("/detail")
	public String getAppInformation(@RequestParam("pid") int pid,@RequestParam("id") String id, Model model) {
		
		App appInfo= appServices.findbyAppName(id);
		
		model.addAttribute("appInfo", appInfo);
		
		return "appinformation";
	}
	

  @RequestMapping("/games")
  public String getGamePage(@AuthenticationPrincipal LoadUserDetail userDetail,Model model,@RequestParam("pid") int pid) {
	  String tagName = "game";
		if(userDetail != null) {
			String username = userDetail.getUsername();
			model.addAttribute("username",username);
		}
		else if(userDetail == null && pid == 1) {
			return "redirect:/games?pid=0";
		}
		List<App> appList = appServices.fetchAppEntertainmentList(tagName);
		model.addAttribute("pid",pid);  
		model.addAttribute("appList", appList);
		return "appentertainment" ; 
  }
  
  @RequestMapping("/books")
  public String getBookPage(@AuthenticationPrincipal LoadUserDetail userDetail,Model model,@RequestParam("pid") int pid) {
	  String tagName = "sach";
		if(userDetail != null) {
			String username = userDetail.getUsername();
			model.addAttribute("username",username);
		}
		else if(userDetail == null && pid == 1) {
			return "redirect:/books?pid=0";
		}
		List<App> appList = appServices.fetchAppEntertainmentList(tagName);
		model.addAttribute("pid",pid);  
		model.addAttribute("appList", appList);
		return "appbook"; 
  }
  
  @RequestMapping("/movies")
  public String getFlimPage(@AuthenticationPrincipal LoadUserDetail userDetail,Model model,@RequestParam("pid") int pid) {
	  String tagName = "phim";
		if(userDetail != null) {
			String username = userDetail.getUsername();
			model.addAttribute("username",username);
		}
		else if(userDetail == null && pid == 1) {
			return "redirect:/movies?pid=0";
		}
		List<App> appList = appServices.fetchAppEntertainmentList(tagName);
		model.addAttribute("pid",pid);  
		model.addAttribute("appList", appList);
		return "appfilm"; 
  }
  
  @RequestMapping("/cart")
  public String getCartPage(@AuthenticationPrincipal LoadUserDetail userDetail,Model model,@RequestParam("pid") int pid) {
	  String tagName = "phim";
		if(userDetail != null) {
			String username = userDetail.getUsername();
			model.addAttribute("username",username);
		}
		else if(userDetail == null && pid == 1) {
			return "redirect:/movies?pid=0";
		}
		List<App> appList = appServices.fetchAppEntertainmentList(tagName);
		model.addAttribute("pid",pid);  
		model.addAttribute("appList", appList);
		return "cart"; 
  }
  
  @RequestMapping("/account") public String
  getUserInfo(@AuthenticationPrincipal LoadUserDetail userDetail, Model model)
  { String email = userDetail.getUsername();
  
  User user = userServices.findByEmail(email);
  
  model.addAttribute("userInfo", user);
  
  return "userform"; } 
	}
  
