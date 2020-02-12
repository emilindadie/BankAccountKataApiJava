package com.emilindadie.validator;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import com.emilindadie.model.Account;
import com.emilindadie.model.User;


public class AccountValidatorTest {

	AccountValidator validator = new AccountValidator();

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void should_return_true_when_having_valid_account(){
		// Arrange
		User user = User.builder().name("Emilin")
		        .email("dadie.emilin@gmail.com")
		        .address("Rosny")
		        .password("azerty").build();
		Account account = Account.builder().name("Compte A").user(user).build();
       
		// Act
        Boolean isValid = validator.isValid(account);
        
        // Assert
        Assertions.assertThat(isValid).isEqualTo(true);
	}
	
	@Test
	public void should_return_false_when_having_invalid_account(){
		Account account = Account.builder().name("").build();
	       
        Boolean isValid = validator.isValid(account);
        
        Assertions.assertThat(isValid).isEqualTo(false);
	}
}
