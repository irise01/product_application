package com.soft.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.soft.model.User;
import com.soft.repository.UserRepository;

@SpringBootTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void createUser() {
		User user = new User();
		user.setFullName("ajay");
		user.setAddress("Pune");
		user.setEmail("ajay@gmail.com");
		user.setPhoneNo(5555);
		user.setUserName("ajay123");
		//user.setPassword("Password@gmail.com");
		
		User savedUser = userRepository.save(user);
		
		assertNotNull(savedUser);
	
	}

	@Test
	public void findALLUser() {
		
		List<User> list = userRepository.findAll();
		
		assertThat(list.size()).isGreaterThan(1000);
		
	}
	
	@Test
	public void findById() {
		User existeduser = userRepository.findById(101).get();
		
		assertEquals("sachin", existeduser.getFullName());
	}
	
	@Test
	public void deletebyId() {
		userRepository.deleteById(109);
		
		assertThat(userRepository.existsById(109)).isFalse();
			
	}
	
	@Test
	public void updateUserbyId() {
		User existeduser = userRepository.findById(101).get();
		existeduser.setFullName("ram");
		userRepository.save(existeduser);
		
		assertNotEquals("ramesh", userRepository.findById(101).get().getFullName());
		
	}
	
	
}
