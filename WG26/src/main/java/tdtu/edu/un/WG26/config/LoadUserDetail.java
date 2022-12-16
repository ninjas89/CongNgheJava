package tdtu.edu.un.WG26.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import tdtu.edu.un.WG26.Model.User;

public class LoadUserDetail implements UserDetails {

	private User user;

	public LoadUserDetail(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String userRoles = user.getRole().getRole();
		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
		return authorities;
	}

	public String getRole() {
		return user.getRole().getRole();
	}

	public String getEmail() {
		return user.getEmail();
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getFirstName() + " " + user.getLastName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
