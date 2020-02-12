package com.emilindadie.mapper;

import com.emilindadie.dto.SignInDto;
import com.emilindadie.dto.UserDto;
import com.emilindadie.model.User;

import lombok.extern.java.Log;


public class UserMapper implements GenericMapper<UserDto, User>{
	@Override
	public User map(UserDto dto) {
		return User.builder()
				.id(dto.getId())
				.name(dto.getName())
                .email(dto.getEmail())
                .address(dto.getAddress())
                .password(dto.getPassword())
                .build();
	}
	
	public User map(SignInDto dto) {
		return User.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
	}
}
