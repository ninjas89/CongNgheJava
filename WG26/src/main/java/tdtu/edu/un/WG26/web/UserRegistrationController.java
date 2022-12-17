package tdtu.edu.un.WG26.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tdtu.edu.un.WG26.Service.UserServices;
import tdtu.edu.un.WG26.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("register")
public class UserRegistrationController {
	@Autowired
	private UserServices userServices;

	public UserRegistrationController(UserServices userServices) {
		super(); 
		this.userServices = userServices; 
	} 
	
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	
	@RequestMapping("")
	public String getRegister() {
		return "register";
	}
	
	@PostMapping("")
	public String postRegister(@Validated @ModelAttribute("user") UserRegistrationDto registrationDto, BindingResult result) {
        if(result.hasErrors()){
        	System.out.println(result.getAllErrors());
        	System.out.println(result.getGlobalErrorCount());
            return "register";
        }
		else {
			userServices.save(registrationDto);
			return "redirect:/register?success";			
		}
	}
}