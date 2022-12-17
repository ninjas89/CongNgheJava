package tdtu.edu.un.WG26.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import tdtu.edu.un.WG26.config.LoadUserDetail;

public class UserChangePassDTO {
	
	@Autowired
	LoadUserDetail userDetail;
	
	@NotBlank(message = "Vui lòng nhập mật khẩu mới")
	private String newPassword;
	
	private String confirmNewPassword;

	private String email;
	
	public UserChangePassDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserChangePassDTO(@NotEmpty(message = "Vui lòng nhập mật khẩu cũ") String currentPassword,
			@NotEmpty(message = "Vui lòng nhập mật khẩu mới") String newPassword, String confirmNewPassword) {
		super();
		this.newPassword = newPassword;
		this.confirmNewPassword = confirmNewPassword;
	}


	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}

	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}
	public String getEmail() {
		
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserChangePassDTO ["+ "newPassword=" + newPassword
				+ ", confirmNewPassword=" + confirmNewPassword + ", email= "+email+"]";
	}
	
	
	
}
