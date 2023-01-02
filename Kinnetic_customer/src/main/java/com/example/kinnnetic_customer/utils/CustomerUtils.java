package com.example.kinnnetic_customer.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CustomerUtils {

	private CustomerUtils() {
		
	}
	
	public static ResponseEntity<String> getResponseEntity(String responseMessage,HttpStatus httpstatus){
		
		return new ResponseEntity<String>("{\"message\":\""+responseMessage+"\"}",httpstatus);
	}
}
