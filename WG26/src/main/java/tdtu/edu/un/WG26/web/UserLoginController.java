package tdtu.edu.un.WG26.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserLoginController {
	
	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}
	
}
