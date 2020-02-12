package com.emilindadie.bean;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
<<<<<<< HEAD
=======
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
>>>>>>> account
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;


<<<<<<< HEAD
public class PasswordEncoderTest implements PasswordEncoder{
=======
public class PasswordEncoderTest implements PasswordEncoder {
>>>>>>> account
	
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
<<<<<<< HEAD
        return BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt(4));
=======
		return BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt(4));
>>>>>>> account
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
	}
}