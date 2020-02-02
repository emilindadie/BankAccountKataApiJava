package com.emilindadie.validator;

import com.emilindadie.model.User;

public class UserValidator implements GenericValidator<User> {

	@Override
	public boolean isValid(User t) {		
		return t != null &&
			t.getName() != null && !t.getName().isEmpty() &&
			t.getEmail() != null && !t.getEmail().isEmpty() &&
			t.getPassword() != null && !t.getPassword().isEmpty() &&
			t.getAddress() != null && !t.getAddress().isEmpty();
	}
	
	public boolean isvalidSignIn(User user) {
		return user != null &&
			 user.getEmail() != null && !user.getEmail().isEmpty() &&
			 user.getPassword() != null && !user.getPassword().isEmpty();
	}
}
