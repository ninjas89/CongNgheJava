package tdtu.edu.un.WG26.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tdtu.edu.un.WG26.Model.App;
import tdtu.edu.un.WG26.Model.Card;
import tdtu.edu.un.WG26.Model.User;
import tdtu.edu.un.WG26.Service.AdminServices;
import tdtu.edu.un.WG26.Service.AppServices;
import tdtu.edu.un.WG26.Service.CardServices;

@Controller
public class AdminDashboard {
	@Autowired
	private AdminServices adminServices;
	
	@Autowired
	private AppServices appService;
	
	@Autowired CardServices cardService;

	@GetMapping("/admin")
	public String adminDashboard() {
		return "admin"; 
	}

	@GetMapping("admin/get-all-user")
	public String getAllUser(Model model) {
		List<User> userList = adminServices.fetchAllUser();
		model.addAttribute("userList", userList);
		System.out.println(userList);
		return "admin";
	}
	
	@GetMapping("admin/get-all-app")
	public String getAllApp(Model model) {
		List<App> appList = appService.fetchAppList();
		model.addAttribute("appList", appList);
		return "admin";
	}
	
	@GetMapping("admin/get-all-card")
	public String getAllCard(Model model) {
		List<Card> appList = cardService.fetchAllCard();
		model.addAttribute("appList", appList);
		return "admin";
	}
}
