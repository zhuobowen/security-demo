package com.demo.security.entity;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomerUser implements UserDetails{

	private static final long serialVersionUID = 1889950798177188391L;
	private String id;
	private String username;
	private String password;
	private boolean isEnabled = true;
	private Collection<GrantedAuthority> grantedAuthoritys = new ArrayList<GrantedAuthority>();
	
	public CustomerUser(User user) {
        if(user != null){
        	 this.setId(user.getId());
             this.setUsername(user.getLoginName());
             this.setPassword(user.getPassword());
        }
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return grantedAuthoritys;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return isEnabled;
	}
}
