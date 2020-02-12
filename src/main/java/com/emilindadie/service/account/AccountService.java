package com.emilindadie.service.account;

import java.util.List;

import com.emilindadie.exception.ErrorException;
import com.emilindadie.model.Account;

public interface AccountService {
	Account create(Account account) throws ErrorException;
	List<Account> accountsByUserId(int id);
}
