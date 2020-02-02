package com.emilindadie.bean;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PasswordEncoderTest {
	
	
	@Autowired 
	PasswordEncoder passwordEncoder;

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void should_return_encoded_password_when_having_password(){
		// Arrange
		String password = "azerty";
		
		// Act
		String encodedPassword = passwordEncoder.encode(password);
		
		// Assert
	    Assertions.assertThat(password).isNotEqualTo(encodedPassword);
	}
	
	@Test
	public void should_return_true_when_having_password_matching_with_encoded_password(){
		String password = "azerty";
		String encodedPassword = passwordEncoder.encode(password);
		
		Boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
		
	    Assertions.assertThat(isPasswordMatch).isEqualTo(true);
	}
}