package tdtu.edu.un.WG26.Validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = {PasswordCompareValidator.class})
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.TYPE})
public @interface PasswordCompare {
    String message() default "Mật khẩu xác thực không chính xác";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}