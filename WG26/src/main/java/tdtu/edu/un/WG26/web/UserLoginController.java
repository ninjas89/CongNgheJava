package tdtu.edu.un.WG26.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tdtu.edu.un.WG26.Service.UserServices;


@Controller
public class UserLoginController {
	
	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}
	
}
