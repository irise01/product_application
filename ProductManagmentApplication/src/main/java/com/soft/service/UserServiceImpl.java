package com.soft.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.model.User;
import com.soft.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public HashMap<String, Object> userSignUp(User user) {
		
		HashMap<String, Object> serviceResponse = new HashMap<>();
		
		User saveUsed = userRepository.save(user);
		if(saveUsed != null) {
			serviceResponse.put("Message", "User signUp sucessfully...!");
			serviceResponse.put("status", true);
			serviceResponse.put("SaveUserData", saveUsed);
		}else {
			serviceResponse.put("Message", "User not signUp sucessfully...!");
			serviceResponse.put("status", false);
		}
		
		return serviceResponse;
	}

	@Override
	public HashMap<String, Object> userSignIn(String userName, String password) {
		
		HashMap<String, Object> serviceResponse = new HashMap<>();
		try {
			User signInuser = userRepository.signInFromRepo(userName, password);
			if(signInuser != null) {
				serviceResponse.put("message", "user signIn sucessfully");
				serviceResponse.put("status", true);
				serviceResponse.put("SignInUser", signInuser);
			}else {
				serviceResponse.put("message", "user not signIn please check username and password");
				serviceResponse.put("status", false);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return serviceResponse;
	}

}
