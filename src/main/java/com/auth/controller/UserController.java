package com.auth.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auth.model.User;
import com.auth.model.UserRequest;
import com.auth.model.UserResponse;
import com.auth.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(path="/login", method = RequestMethod.POST)
	public ResponseEntity<UserResponse>  ValidateLogin(@RequestBody UserRequest userRequest){
		System.out.println("login +++++ input");
		return userService.validateLogin(userRequest);
		
	}
	@RequestMapping(path="/register", method = RequestMethod.POST)
	public ResponseEntity<UserResponse>  RegisterUser(@RequestBody UserRequest userRequest){
		System.out.println("register user");
		return userService.validateLogin(userRequest);
		
	}
	
	//sample methods for further enhancements
	@RequestMapping(path="/user", method = RequestMethod.GET)
	public ResponseEntity<List<User>>  listUser(){
		return new ResponseEntity<List<User>>(getUsers(), HttpStatus.OK);
	}
	
	@RequestMapping(path="/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<User>  listUser(@PathVariable(value = "id") String id){
		return new ResponseEntity<User>(getUsers().stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null), HttpStatus.OK);
		
	}
	
	
	
	private List<User> getUsers() {
		User user = new User();
		user.setId("1");
		user.setEmail("abc.efg@gmail.com");
		user.setName("FIRST LAST");
		user.setAddress("Phoenix, AZ");
	
		return Arrays.asList(user);
	}


}
