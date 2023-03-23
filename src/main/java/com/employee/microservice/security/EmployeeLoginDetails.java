package com.employee.microservice.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.employee.microservice.entity.EmployeeLogin;
public class EmployeeLoginDetails implements UserDetails{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	EmployeeLogin emplogin=new EmployeeLogin();
	EmployeeLoginDetails(EmployeeLogin emplogin)
	{
		this.emplogin=emplogin;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority("EMPLOYEE"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return emplogin.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return emplogin.getId();
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
