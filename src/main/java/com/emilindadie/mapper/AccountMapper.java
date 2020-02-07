package com.emilindadie.mapper;

import com.emilindadie.dto.AccountDto;
import com.emilindadie.model.Account;

public class AccountMapper implements GenericMapper<AccountDto, Account>{

	UserMapper mapper = new UserMapper();
	
	@Override
	public Account map(AccountDto dto) {
		return Account.builder().solde(dto.getSolde()).name(dto.getName()).user(mapper.map(dto.getUser())).build();
	}
}
