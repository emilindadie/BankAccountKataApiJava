package com.emilindadie.validator;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import com.emilindadie.model.User;


public class UserValidatorTest {

	UserValidator validator = new UserValidator();

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void should_return_true_when_having_valid_user(){
		// Arrange
		User user = new User();
		user.setName("toto");
		user.setEmail("toto@gmail.com");
		user.setPassword("azerty");
		user.setAddress("Rosny");
       
		// Act
        Boolean isValid = validator.isValid(user);
        
        // Assert
        Assertions.assertThat(isValid).isEqualTo(true);
	}
	
	@Test
	public void should_return_true_when_having_valid_signin_user(){
		User user = new User();
		user.setEmail("toto@gmail.com");
		user.setPassword("azerty");
       
        Boolean isValid = validator.isvalidSignIn(user);
        
        Assertions.assertThat(isValid).isEqualTo(true);
	}
	
	@Test
	public void should_return_false_when_having_invalid_user(){
		User user = new User();
		user.setEmail("toto@gmail.com");
		user.setAddress("Rosny");
       
        Boolean isValid = validator.isValid(user);
        
        Assertions.assertThat(isValid).isEqualTo(false);
	}
	
	@Test
	public void should_return_false_when_having_invalid_signin_user(){
		User user = new User();
        Boolean isValid = validator.isvalidSignIn(user);
        Assertions.assertThat(isValid).isEqualTo(false);
	}
}
