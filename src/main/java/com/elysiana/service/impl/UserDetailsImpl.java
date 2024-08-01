package com.elysiana.service.impl;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {
	private final int userId;
	private final String name;
	private final String email;
	private final String contact;
	private final String password;
	private final Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(int userId, String name, String email, String contact, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.password = password;
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
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
		return true;
	}

	public int getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getContact() {
		return contact;
	}
}
