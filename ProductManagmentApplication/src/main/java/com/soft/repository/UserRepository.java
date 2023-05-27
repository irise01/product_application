package com.soft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.soft.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	@Query(value = "SELECT * FROM user_details where user_name=?1 AND password=?2",nativeQuery = true)
	public User signInFromRepo(String userName, String password);
}
