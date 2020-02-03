package com.emilindadie.bean;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;


public class PasswordEncoderTest implements PasswordEncoder{
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void should_return_encoded_password_when_having_password(){
		// Arrange
		String password = "azerty";
		
		// Act
		String encodedPassword = this.encode(password);
		
		// Assert
	    Assertions.assertThat(password).isNotEqualTo(encodedPassword);
	}
	
	@Test
	public void should_return_true_when_having_password_matching_with_encoded_password(){
		String password = "azerty";
		String encodedPassword = this.encode(password);
		
		Boolean isPasswordMatch = this.matches(password, encodedPassword);
		
	    Assertions.assertThat(isPasswordMatch).isEqualTo(true);
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