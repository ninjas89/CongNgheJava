package tdtu.edu.un.WG26.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import tdtu.edu.un.WG26.Service.UserServices;
import tdtu.edu.un.WG26.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("register")
public class UserRegistratronController {
	@Autowired
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
	public String postRegister(@Validated @ModelAttribute("user") UserRegistrationDto registrationDto, BindingResult result) {
        if(result.hasErrors()){
        	System.out.println(result.getAllErrors());
        	System.out.println(result.getGlobalErrorCount());
            return "register?error";
        }
		else {
			userServices.save(registrationDto);
			return "redirect:/register?success";			
		}
	}
}