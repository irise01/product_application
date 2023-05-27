package com.soft.service;

import java.util.HashMap;

import com.soft.model.User;

public interface UserService {
	
	public HashMap<String, Object> userSignUp(User user);
	
	public HashMap<String, Object> userSignIn(String userName, String password);
}
