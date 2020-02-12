package com.emilindadie.api;

import java.util.ArrayList;
import java.util.List;

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

import com.emilindadie.dto.AccountDto;
import com.emilindadie.dto.UserDto;
import com.emilindadie.exception.ErrorException;
import com.emilindadie.mapper.AccountMapper;
import com.emilindadie.model.Account;
import com.emilindadie.model.ApiResponse;
import com.emilindadie.service.account.AccountService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AccountApiTest {
	
	@Autowired 
	AccountApi api;
	
	@MockBean
	AccountService service;
	
	@Autowired 
	AccountMapper mapper;
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void should_create_account_when_having_valid_account(){
		// Arrange
		UserDto userDto = UserDto.builder()
				.id(1)
				.name("Emilin")
				.email("dadie.emilin@gmail.com")
				.address("Rosny")
				.password("azerty")
				.build();
		
		AccountDto accountDto = AccountDto.builder().name("Compte A").user(userDto).build();
		
		Account mappedAccount = mapper.map(accountDto);
		try {
			// Act
	        Mockito.when(service.create(mappedAccount)).thenReturn(mappedAccount);

	        ResponseEntity<ApiResponse<Account>> createAccountResponse = api.createAccount(accountDto);
	        
	        // Assert
	        Assertions.assertThat(createAccountResponse.getStatusCodeValue()).isEqualTo(201);
		} catch(ErrorException e) {
		}
	}
	
	@Test
	public void should_get_all_user_accounts_when_having_userId(){
		int userId = 1;
		
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(Account.builder().name("Compte A").build());
		
        Mockito.when(service.accountsByUserId(userId)).thenReturn(accounts);

        ResponseEntity<ApiResponse<List<Account>>> getAccountResponse = api.getAccounts(userId);
        
        Assertions.assertThat(getAccountResponse.getStatusCodeValue()).isEqualTo(200);
	}
}
