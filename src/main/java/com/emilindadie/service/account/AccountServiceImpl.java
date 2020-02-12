package com.emilindadie.service.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emilindadie.dao.AccountDao;
import com.emilindadie.exception.ErrorException;
import com.emilindadie.model.Account;
import com.emilindadie.validator.AccountValidator;


@Service()
public class AccountServiceImpl implements AccountService {
	
	@Autowired AccountDao dao;
	
	@Autowired AccountValidator validator;

	@Override
	public Account create(Account account) throws ErrorException {
		if(validator.isValid(account)) {
			return dao.save(account);
		}
		throw new ErrorException("failed to create account", "Name field are requiered");	
	}

	@Override
	public List<Account> accountsByUserId(int id) {
		return dao.findByUserId(id);
	}
}
