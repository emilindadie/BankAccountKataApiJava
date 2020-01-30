package com.emilindadie.model;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void should_return_true_when_having_valid_user_property(){
		// Arrange
		User user = new User();
		user.setName("toto");
		user.setEmail("toto@gmail.com");
		user.setPassword("azerty");
		user.setAddress("Rosny");
		
		// Act
		Boolean output = user.validProperty();
		
		// Assert
	    Assertions.assertThat(output).isEqualTo(true);
	}
	
	@Test
	public void should_return_false_when_having_invalid_user_property(){
		User user = new User();
		Boolean output = user.validProperty();
	    Assertions.assertThat(output).isEqualTo(false);
	}
}

