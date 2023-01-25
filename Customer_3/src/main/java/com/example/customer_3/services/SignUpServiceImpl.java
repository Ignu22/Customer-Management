package com.example.customer_3.services;


import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.customer_3.jwt.JwtFilter;
import com.example.customer_3.jwt.JwtUtil;
import com.example.customer_3.jwt.UserInfoUserDetailsService;
import com.example.customer_3.model.SignUp;
import com.example.customer_3.repository.SignUpRepository;

@Service
public class SignUpServiceImpl implements SignUpService{

	@Autowired
	SignUpRepository signUpReposiotory;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserInfoUserDetailsService userInfoUserDetailsService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	JwtFilter jwtFilter;
	
	@Override
	public ResponseEntity<SignUp> customerSignUp(SignUp requestMap) {
		// TODO Auto-generated method stub
		try {
			SignUp signUp = signUpReposiotory.findByEmailId(requestMap.get("email"));
			if(Objects.isNull(signUp)) {
				SignUp sign= signUpReposiotory.save(requestMap);
				return new ResponseEntity<>(sign,HttpStatus.CREATED);
			}else {
				System.out.println("Email already exist");
			 return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<String> login(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		try {			
			Authentication auth= (Authentication) authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(requestMap.get("email"), requestMap.get("password")));
			if(auth.isAuthenticated()) {
				return new ResponseEntity<String>("{\"token\":\""+jwtUtil.generateToken(userInfoUserDetailsService.getUserDetail().getEmail(),
						userInfoUserDetailsService.getUserDetail().getRole())+"\"}",HttpStatus.OK);
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return new ResponseEntity<>("Bad Request",HttpStatus.BAD_REQUEST);
	}

}
