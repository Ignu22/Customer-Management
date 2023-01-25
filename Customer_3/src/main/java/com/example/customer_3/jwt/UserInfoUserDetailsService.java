package com.example.customer_3.jwt;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


import com.example.customer_3.model.SignUp;
import com.example.customer_3.repository.SignUpRepository;

@Component
public class UserInfoUserDetailsService implements UserDetailsService{

	@Autowired
	SignUpRepository signUpRepository;
	
	private SignUp details;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		details = signUpRepository.findByEmailId(username);
		if(!Objects.isNull(details))
			return new User(details.getEmail(),details.getPassword(), new ArrayList<>());
		else
			throw new UsernameNotFoundException("User not found");
	}
	
	public SignUp getUserDetail() {
		return details;
	}

}
