package com.emilindadie.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emilindadie.exception.ErrorException;
import com.emilindadie.model.User;
import com.emilindadie.model.UserDao;
import com.emilindadie.service.UserService;

import org.assertj.core.api.Assertions;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired 
	UserService service;
	
	@MockBean
	UserDao dao;


	@Before
	public void setUp() throws Exception {
	}
	
	
	@Test
	public void should_return_an_user_when_having_valid_user_property(){
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
	        User savedUser = service.createUser(user);
	        
	        // Assert
	        Assertions.assertThat(savedUser.getId()).isNotNull();
		} catch(ErrorException e) {
		}
	}
	
	@Test
	public void should_throw_an_exception_when_having_invalid_user_property(){
		try {
	        User savedUser = service.createUser(new User());
		} catch(ErrorException e) {
	        Assertions.assertThat(e instanceof ErrorException);
		}
	}
}
