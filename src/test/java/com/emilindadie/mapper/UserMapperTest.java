package com.emilindadie.mapper;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import com.emilindadie.dto.SignInDto;
import com.emilindadie.dto.UserDto;
import com.emilindadie.model.User;


public class UserMapperTest {

	UserMapper mapper = new UserMapper();

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void should_return_user_when_having_user_dto(){
		// Arrange
		UserDto dto = UserDto.builder()
			.name("Emilin")
			.email("dadie.emilin@gmail.com")
			.address("Rosny")
			.password("azerty")
			.build();
       
		// Act
        User mappedUser = mapper.map(dto);
        
        // Assert
        Assertions.assertThat(mappedUser instanceof User);
	}
	
	@Test
	public void should_return_user_when_having_signin_user_dto(){
		SignInDto dto = SignInDto.builder()
				.email("dadie.emilin@gmail.com")
				.password("azerty")
				.build();
       
        User mappedUser = mapper.map(dto);
        
        Assertions.assertThat(mappedUser instanceof User);
	}
}
