package tdtu.edu.un.WG26.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class SuccessHandlerConfig extends SavedRequestAwareAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
		Authentication authentication) throws ServletException, IOException {
		LoadUserDetail userDetail = (LoadUserDetail) authentication.getPrincipal();
		String url = request.getContextPath();
		System.out.println(userDetail.getRole());
		if(userDetail.getRole() == "USER") {
			url += "/home?user_loged";
		}
		if(userDetail.getRole() == "ADMIN") {
			url += "/home?admin_loged";
		}
		else {
			url = "/home";
		}
		response.sendRedirect(url);
	}
	
}
