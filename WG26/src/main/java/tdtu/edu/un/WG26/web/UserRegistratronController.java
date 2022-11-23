package tdtu.edu.un.WG26.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tdtu.edu.un.WG26.Service.UserServices;
import tdtu.edu.un.WG26.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("register")
public class UserRegistratronController {
	private UserServices userServices;

	public UserRegistratronController(UserServices userServices) {
		super();
		this.userServices = userServices; 
	} 
	
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	
	@GetMapping
	public String getRegister() {
		return "register";
	}
	
	@PostMapping
	public String postRegister(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		userServices.save(registrationDto);
		return "redirect:/register?success";
	}
}
