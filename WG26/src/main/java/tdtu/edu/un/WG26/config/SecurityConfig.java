package tdtu.edu.un.WG26.config;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private SuccessHandlerConfig successHandlerConfig;
    
    @Bean
	public static PasswordEncoder passEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeRequests().antMatchers( "/js/**",
	                "/css/**",
	                "/img/**",
					"/register**",
					"/home**",
					"/login**").permitAll()
			.anyRequest().permitAll()
			.and()
			.formLogin(
				form -> form
					.loginPage("/login")
				    .usernameParameter("email")
				    .passwordParameter("password")
					.loginProcessingUrl("/login")
					.successHandler(successHandlerConfig)
					.failureHandler(new SimpleUrlAuthenticationFailureHandler() {
						
						@Override
						public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
								AuthenticationException exception) throws IOException, ServletException {
							String email = request.getParameter("email");
							String password = request.getParameter("password");
							String err = "/login?error";
							if(email.isBlank()) {
								err = err + "&email";
							}
							if(password.isBlank()) {
								err = err + "&password";
							}
							super.setDefaultFailureUrl(err);
							super.onAuthenticationFailure(request, response, exception);
							
						}
					}).permitAll()
					
			)
			.logout( logout -> logout
				.logoutUrl("/logout")
				.invalidateHttpSession(false)
				.deleteCookies("JSESSIONID")
				.logoutSuccessUrl("/home")
			)
			.sessionManagement( session -> session
				.invalidSessionUrl("/home")
			);

			
		return http.build();
	}

}
