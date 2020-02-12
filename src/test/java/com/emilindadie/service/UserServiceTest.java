package com.emilindadie.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emilindadie.dao.UserDao;
import com.emilindadie.exception.ErrorException;
import com.emilindadie.model.User;
import com.emilindadie.service.user.UserService;

import org.assertj.core.api.Assertions;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest implements PasswordEncoder {

	@Autowired 
	UserService service;
	
	@MockBean
	UserDao dao;
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void should_signup_a_user_when_having_valid_signup_user_property(){
		// Arrange
		User user = new User();
		user.setId(1);
		user.setName("toto");
		user.setEmail("toto@gmail.com");
		user.setPassword("azerty");
		user.setAddress("Rosny");
        Mockito.when(dao.save(user)).thenReturn(user);
        
		try {
			// Act
	        User signUpUser = service.signUpUser(user);
	        
	        // Assert
	        Assertions.assertThat(signUpUser.getId()).isNotNull();
		} catch(ErrorException e) {
		}
	}
	
	@Test
	public void should_throw_an_exception_when_having_invalid_signup_user_property(){
		try {
	        User signUpUser = service.signUpUser(new User());
		} catch(ErrorException e) {
	        Assertions.assertThat(e instanceof ErrorException);
		}
	}
	
	@Test
	public void should_signin_a_user_when_having_valid_signin_user_value(){
		String email = "toto@gmail.com";
		String password = "azerty";
		User user = new User();
		user.setId(1);
		user.setPassword(this.encode(password));
        Mockito.when(dao.findByEmail(email)).thenReturn(user);
		try {
	        User signInUser = service.signInUser(user);
	        Assertions.assertThat(signInUser.getId()).isNotNull();
		} catch(ErrorException e) {
		}
	}
	
	@Test
	public void should_throw_an_exception_when_having_invalid_signin_user_value(){
		try {
	        User signInUser = service.signInUser(new User());
	        Assertions.assertThat(signInUser.getId()).isNotNull();
		} catch(ErrorException e) {
	        Assertions.assertThat(e instanceof ErrorException);
		}
	}

	@Override
	public String encode(CharSequence rawPassword) {
        return BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt(4));
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
	}
}
