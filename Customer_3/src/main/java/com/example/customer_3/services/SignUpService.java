package com.example.customer_3.services;



import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.example.customer_3.model.SignUp;


public interface SignUpService {

	ResponseEntity<SignUp> customerSignUp(SignUp requestMap);

	ResponseEntity<String> login(Map<String, String> requestMap);

}
