package com.auth.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.auth.model.UserErrorResponse;
import com.auth.model.UserRequest;
import com.auth.model.UserResponse;
import com.auth.model.UserSuccessResponse;

@Service
public class UserService {
	
	@Value("${user.username}")
	private String USERNAME;
	@Value("${user.password}")
	private String PASSWORD;
	

	public ResponseEntity<UserResponse> validateLogin(UserRequest userRequest){
		ResponseEntity<UserResponse> response= null;
		UserSuccessResponse success=new UserSuccessResponse();
		UserErrorResponse error=new UserErrorResponse();
		System.out.println(userRequest.getUsername()+ " "+userRequest.getPassword());
		boolean invalidInput=false;
		//validations
		if(userRequest.getUsername()==null || userRequest.getUsername().trim().equals("")) {
			error.setMessage("Please provide mandatory username");
			response=new ResponseEntity<UserResponse>(error,HttpStatus.BAD_REQUEST);
			invalidInput=true;
		}
		else if(userRequest.getPassword()==null || userRequest.getPassword().trim().equals("")) {
			error.setMessage("Please provide mandatory password");
			response=new ResponseEntity<UserResponse>(error,HttpStatus.BAD_REQUEST);
			invalidInput=true;
		}
		
		if(!invalidInput){
			if(userRequest.getUsername().equals(USERNAME) && userRequest.getPassword().equals(PASSWORD)) {
			success.setUserName(userRequest.getUsername());
			success.setMessage("Logged in successfully");
			response=new ResponseEntity<UserResponse>(success,HttpStatus.OK);		
			}
			else
			{
				error.setMessage("Not able to find the match for the given user details");
				response=new ResponseEntity<UserResponse>(error,HttpStatus.NOT_FOUND);
			}
		}
		System.out.println(response);
		return response;
		
	}
}
