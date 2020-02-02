package com.emilindadie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.emilindadie.mapper.UserMapper;
import com.emilindadie.validator.UserValidator;

@SpringBootApplication
@Configuration
public class BankAccountKataApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountKataApiApplication.class, args);
	}

	@Bean
	public PasswordEncoder customPasswordEncoder() {
	    return new PasswordEncoder() {
	        @Override
	        public String encode(CharSequence rawPassword) {
	            return BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt(4));
	        }

	        @Override
	        public boolean matches(CharSequence rawPassword, String encodedPassword) {
	            return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
	        }
	    };
	}
	
	@Bean
	public UserMapper userMapper() {
		return new UserMapper();
	}
	
	@Bean
	public UserValidator userValidator() {
		return new UserValidator();
	}
}
