package tdtu.edu.un.WG26.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import tdtu.edu.un.WG26.web.dto.UserRegistrationDto;

public class PasswordCompareValidator implements ConstraintValidator<PasswordCompare, UserRegistrationDto>{
	@Override
    public void initialize(PasswordCompare passwordCompare) {
        
    }
	@Override
	public boolean isValid(UserRegistrationDto user, ConstraintValidatorContext context) {
		String pass = user.getPassword();
		String passConfirm = user.getConfirmPassword(); 
		if(passConfirm.equals(pass) == false && pass != null) {
			return false;
		}
		return true;
	}

}
