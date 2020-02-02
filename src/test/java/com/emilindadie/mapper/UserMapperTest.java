package com.emilindadie.mapper;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emilindadie.dto.SignInDto;
import com.emilindadie.dto.UserDto;
import com.emilindadie.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired 
	UserMapper mapper;

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
