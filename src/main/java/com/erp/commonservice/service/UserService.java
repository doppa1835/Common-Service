package com.erp.commonservice.service;

import java.util.List;
import java.util.Optional;

import com.erp.commonservice.pojo.User;

public interface UserService {
			
	public User getUserByEmailAndPassword(String email,String password);
	public User createUser(User user);
	public boolean deleteUserbyId(long id);
	public List<User> getUserList();
	public User getUserById(Long id);
	public User findUserByEmail(String email);

	
}
