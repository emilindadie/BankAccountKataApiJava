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
import com.emilindadie.dto.UserDto;
import com.emilindadie.exception.ErrorException;
import com.emilindadie.mapper.UserMapper;
import com.emilindadie.model.ApiResponse;
import com.emilindadie.model.User;
import com.emilindadie.service.user.UserService;

@RestController
@RequestMapping("/user")
public class UserApi {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserMapper userMapper;
	
	 @PostMapping()
	 public ResponseEntity<ApiResponse<User>> signUpUser(@Valid @RequestBody UserDto dto){
		try {
			User mapedUser = userMapper.map(dto);
			User signUpUser = userService.signUpUser(mapedUser);
			return new ResponseEntity<>(new ApiResponse<User>(signUpUser, null), HttpStatus.CREATED);
		} catch (ErrorException e) {
			return new ResponseEntity<>(new ApiResponse<User>(null, e), HttpStatus.BAD_REQUEST);
		}
	 }
	
	 @PostMapping("/login")
	 public ResponseEntity<ApiResponse<User>> signInUser(@Valid @RequestBody SignInDto dto){
		try {
			User mapedUser = userMapper.map(dto);

			User signInUser = userService.signInUser(mapedUser);
			return new ResponseEntity<>(new ApiResponse<User>(signInUser, null), HttpStatus.OK);
		} catch (ErrorException e) {
			return new ResponseEntity<>(new ApiResponse<User>(null, e), HttpStatus.UNAUTHORIZED);
		}
	 }
}
