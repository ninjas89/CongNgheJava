package tdtu.edu.un.WG26.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import tdtu.edu.un.WG26.Model.User;
import tdtu.edu.un.WG26.Service.UserServices;

public class EmailValidatedValidator implements ConstraintValidator<EmailValidated, String>{
	@Autowired
	private UserServices userServices;
	
	
	@Override
    public void initialize(EmailValidated emailValidated) {
        
    }
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		User user = userServices.findbyEmail(email);
		if(user != null) {
			return false;
		}
		else {
			return true;
		}
	}
}

