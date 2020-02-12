package com.emilindadie.api;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emilindadie.dto.SignInDto;
import com.emilindadie.dto.UserDto;
import com.emilindadie.exception.ErrorException;
import com.emilindadie.mapper.UserMapper;
import com.emilindadie.model.ApiResponse;
import com.emilindadie.model.User;
import com.emilindadie.service.user.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserApiTest {
	
	@Autowired 
	UserApi api;
	
	@MockBean
	UserService service;
	
	@Autowired 
	UserMapper userMapper;
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void should_signup_a_user_when_having_valid_signup_user_property(){
		// Arrange
		UserDto dto = UserDto.builder()
				.name("Emilin")
				.email("dadie.emilin@gmail.com")
				.address("Rosny")
				.password("azerty")
				.build();
		
		User mappedUser = userMapper.map(dto);
		mappedUser.setId(1);
		try {
			// Act
	        Mockito.when(service.signUpUser(mappedUser)).thenReturn(mappedUser);

	        ResponseEntity<ApiResponse<User>> signUpResponse = api.signUpUser(dto);
	        
	        // Assert
	        Assertions.assertThat(signUpResponse.getStatusCodeValue()).isEqualTo(201);
		} catch(ErrorException e) {
		}
	}
	
	@Test
	public void should_signin_a_user_when_having_valid_signin_user_value(){
		SignInDto dto = SignInDto.builder()
				.email("dadie.emilin@gmail.com")
				.password("azerty")
				.build();
		
		User mappedUser = userMapper.map(dto);
		mappedUser.setId(1);
		try {
	        Mockito.when(service.signInUser(mappedUser)).thenReturn(mappedUser);

	        ResponseEntity<ApiResponse<User>> signInResponse = api.signInUser(dto);
	        
	        Assertions.assertThat(signInResponse.getStatusCodeValue()).isEqualTo(200);
		} catch(ErrorException e) {
		}
	}
}
