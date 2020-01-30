package com.emilindadie.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emilindadie.dto.SignInDto;
import com.emilindadie.dto.SignUpDto;
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
	 public ResponseEntity<ApiResponse<User>> signUpUser(@Valid @RequestBody SignUpDto data){
		try {
			User user = new User();
			user.fromDto(data);
			User signUpUser = userService.signUpUser(user);
			return new ResponseEntity<>(new ApiResponse<User>(signUpUser, null), HttpStatus.CREATED);
		} catch (ErrorException e) {
			return new ResponseEntity<>(new ApiResponse<User>(null, e), HttpStatus.UNAUTHORIZED);
		}
	 }
	 
	 @PostMapping("/login")
	 public ResponseEntity<ApiResponse<User>> signInUser(@Valid @RequestBody SignInDto data){
		try {
			User signInUser = userService.signInUser(data.getEmail(), data.getPassword());
			return new ResponseEntity<>(new ApiResponse<User>(signInUser, null), HttpStatus.OK);
		} catch (ErrorException e) {
			return new ResponseEntity<>(new ApiResponse<User>(null, e), HttpStatus.UNAUTHORIZED);
		}
	 }
}
