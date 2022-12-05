package tdtu.edu.un.WG26.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import tdtu.edu.un.WG26.Model.App;
import tdtu.edu.un.WG26.Service.AppServices;


@Controller
public class IndexController {

	@Autowired
	private AppServices appServices;
	
	public IndexController (AppServices appServices) {
		super();
		this.appServices = appServices;
	}
 
	@GetMapping("/home")
	public String getHomePage(ModelMap model) {
		List<App> listApp = appServices.fetchAppList();
		model.addAttribute("listApp", listApp);
		return "home";
	}
}