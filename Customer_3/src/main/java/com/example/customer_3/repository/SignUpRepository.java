package com.example.customer_3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.customer_3.model.SignUp;

public interface SignUpRepository extends JpaRepository<SignUp, Integer> {

	SignUp findByEmailId(@Param("email") String email);
}
