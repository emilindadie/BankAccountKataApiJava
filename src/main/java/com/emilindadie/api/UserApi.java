package com.emilindadie.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emilindadie.exception.ErrorException;
import com.emilindadie.model.ApiResponse;
import com.emilindadie.model.User;
import com.emilindadie.service.UserService;

@RestController
@RequestMapping("/user")
public class UserApi {
	@Autowired
	private UserService userService;
	
	 @PostMapping()
	 public ResponseEntity<ApiResponse<User>> signUpUser(@Valid @RequestBody User user){
		try {
			User signInuser = userService.signUpUser(user);
			return new ResponseEntity<>(new ApiResponse<User>(signInuser, null), HttpStatus.CREATED);
		} catch (ErrorException e) {
			return new ResponseEntity<>(new ApiResponse<User>(null, e), HttpStatus.BAD_REQUEST);
		}
	 }
}
