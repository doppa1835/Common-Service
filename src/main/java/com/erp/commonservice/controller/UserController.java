package com.erp.commonservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.erp.commonservice.pojo.Role;
import com.erp.commonservice.pojo.User;
import com.erp.commonservice.repo.UserRepo;
import com.erp.commonservice.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@Autowired
	UserRepo userRpository;

	@PostMapping(value = "/login")
	public ResponseEntity userAuthenticate(@RequestBody User user, HttpServletResponse res) {

		User user1 = userService.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
		try {
			if (user1 == null) {
				logger.info("User does not exist");

				return new ResponseEntity(HttpStatus.NOT_FOUND);
			} else {
				logger.info("User authentication successful.");
			}

		} catch (Exception e) {
			logger.error("Authentication failed. Exception: " + e.getMessage());
		}
		return new ResponseEntity(HttpStatus.OK);
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		userRpository.save(user);
		return user;
	}

	@PutMapping(value = "/{id}")
	public User updateUser(@RequestBody User user, @PathVariable long id) {
		user.setId(id);
		userRpository.save(user);
		return user;
	}

	@DeleteMapping(value = "/{id}")
	public void deleteUserById(@PathVariable Long id) {
		logger.info("User deleted successfully.");
		userService.deleteUserbyId(id);

	}

	@GetMapping
	public List<User> getAll() {
		List<User> userList = userRpository.findAll();
		if (userList.size() > 0) {
			logger.info("Fetched all the list of users");
			return userList;

		} else {

			return new ArrayList<User>();
		}
	}

	@GetMapping(value = "/{id}")
	public Object getUserByid(@PathVariable Long id) {
		logger.info("Fetched user by id");
		return userService.getUserById(id);

	}

}
