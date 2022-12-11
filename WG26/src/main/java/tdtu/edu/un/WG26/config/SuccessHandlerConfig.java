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
		if(userDetail.getRole().equals("USER")) {
			url += "/home/login?role=2";
		}
		else if(userDetail.getRole().equals("ADMIN")) {
			url += "/home/login?role=1";
		}
		else {
			url = "/home";
		}
		response.sendRedirect(url);
	}
	
}
