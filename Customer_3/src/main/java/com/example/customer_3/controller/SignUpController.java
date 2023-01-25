package com.example.customer_3.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer_3.model.SignUp;
import com.example.customer_3.services.SignUpService;

@RestController
@RequestMapping(path="/customer")
public class SignUpController {
	
	@Autowired
	SignUpService signUpService;
	
	@PostMapping(path="/signup")
	public ResponseEntity<SignUp> customerSignUp(@RequestBody SignUp requestMap){
		
		return signUpService.customerSignUp(requestMap);
	}
	
	@PostMapping(path="/login")
	public ResponseEntity<String> login(@RequestBody(required = true)Map<String, String> requestMap){
		return signUpService.login(requestMap);
	}

}
