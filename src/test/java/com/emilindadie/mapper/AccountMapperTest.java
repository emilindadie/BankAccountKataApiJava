package com.emilindadie.mapper;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import com.emilindadie.dto.AccountDto;
import com.emilindadie.dto.UserDto;
import com.emilindadie.model.Account;

public class AccountMapperTest {

	AccountMapper mapper = new AccountMapper();

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void should_return_account_when_having_account_dto(){
		// Arrange
		UserDto user = UserDto.builder().name("Emilin")
		        .email("dadie.emilin@gmail.com")
		        .address("Rosny")
		        .password("azerty").build();
		
		AccountDto dto = AccountDto.builder()
			.name("Compte A")
			.user(user)
			.build();
       
		// Act
        Account mappedAccount = mapper.map(dto);
        
        // Assert
        Assertions.assertThat(mappedAccount instanceof Account);
	}
}

