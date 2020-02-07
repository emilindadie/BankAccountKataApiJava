package com.emilindadie.service;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emilindadie.dao.AccountDao;
import com.emilindadie.exception.ErrorException;
import com.emilindadie.model.Account;
import com.emilindadie.model.User;
import com.emilindadie.service.account.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AccountServiceTest {
	@Autowired 
	AccountService service;
	
	@MockBean
	AccountDao dao;
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void should_create_account_when_having_valid_account_property(){
		// Arrange
		User user = new User();
		user.setId(1);
		user.setName("toto");
		user.setEmail("toto@gmail.com");
		user.setPassword("azerty");
		user.setAddress("Rosny");
		
		Account account = Account.builder().name("compte A").id(1).user(user).build();
        Mockito.when(dao.save(account)).thenReturn(account);
        
		try {
			// Act
			Account createdAccount = service.create(account);
	        
	        // Assert
	        Assertions.assertThat(createdAccount.getId()).isNotNull();
		} catch(ErrorException e) {
		}
	}
}

