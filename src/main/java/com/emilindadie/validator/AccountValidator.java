package com.emilindadie.validator;

import com.emilindadie.model.Account;

public class AccountValidator implements GenericValidator<Account> {

	UserValidator validator = new UserValidator();
	@Override
	public boolean isValid(Account t) {		
		return t != null &&
			t.getName() != null && !t.getName().isEmpty() 
			&& validator.isValid(t.getUser());
	}
}
