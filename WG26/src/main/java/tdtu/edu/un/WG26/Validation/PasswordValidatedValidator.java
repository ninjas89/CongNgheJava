package tdtu.edu.un.WG26.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import tdtu.edu.un.WG26.Model.User;
import tdtu.edu.un.WG26.Service.UserServices;
import tdtu.edu.un.WG26.config.LoadUserDetail;

public class PasswordValidatedValidator implements ConstraintValidator<PasswordValidated, String>{
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserServices userServices;
	
	@Autowired
	private LoadUserDetail userDetail;
	@Override
    public void initialize(PasswordValidated passwordValidated) {
    }
	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
		User user = userServices.findByEmail(userDetail.getUsername());
		String userDetailPassword = user.getPassword();
		String userInputPassword = passwordEncoder.encode(password);
		if(userInputPassword.equals(userDetailPassword)) {
			return true;
		}
		else {
			return false;
		}
	}
}
