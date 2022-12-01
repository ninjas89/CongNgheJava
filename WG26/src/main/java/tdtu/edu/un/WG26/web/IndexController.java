package tdtu.edu.un.WG26.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String getHomePage() {
		return "home";
	}
}
