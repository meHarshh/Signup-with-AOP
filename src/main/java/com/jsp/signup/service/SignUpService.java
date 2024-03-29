package com.jsp.signup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.signup.model.SignUp;
import com.jsp.signup.repository.SignUpRepository;

@Service
public class SignUpService {
	
	@Autowired
	private SignUpRepository signUpRepository;
	
	public void saveUser(SignUp signup) {
		signUpRepository.saveUser(signup);
	}

}
