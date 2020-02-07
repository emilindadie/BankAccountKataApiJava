package com.emilindadie.service.account;

import com.emilindadie.exception.ErrorException;
import com.emilindadie.model.Account;
import com.emilindadie.model.User;

public interface AccountService {
	Account create(Account account) throws ErrorException;
}
