package com.soft.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soft.model.User;
import com.soft.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/signUp")
	public HashMap<String, Object> signUp(@RequestBody User user){
		
		HashMap<String, Object> response = userService.userSignUp(user);
		
		return response;
		
	}
	
	@GetMapping("/signIn")
	public HashMap<String, Object> signIn(@RequestParam String userName,String password){
		
		HashMap<String, Object> response = userService.userSignIn(userName, password);
		
		return response;
		
	}

}
