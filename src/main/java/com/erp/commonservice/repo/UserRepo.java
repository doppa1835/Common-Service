package com.erp.commonservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.commonservice.pojo.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	
	public User getUserByEmailAndPassword(String email,String password);
	public User findUserByEmail(String email);
	
}
