package tdtu.edu.un.WG26.Validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = {PasswordValidatedValidator.class})
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.TYPE})
public @interface PasswordValidated {
    String message() default "Mật khẩu hiện tại không đúng";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}