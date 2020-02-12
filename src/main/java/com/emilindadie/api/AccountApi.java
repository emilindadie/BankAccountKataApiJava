package com.emilindadie.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emilindadie.dto.AccountDto;
import com.emilindadie.exception.ErrorException;
import com.emilindadie.mapper.AccountMapper;
import com.emilindadie.model.Account;
import com.emilindadie.model.ApiResponse;
import com.emilindadie.service.account.AccountService;


@RestController
@RequestMapping("/accounts")
public class AccountApi {

	@Autowired
	private AccountService service;
	
	@Autowired
	private AccountMapper mapper;
	
	 @PostMapping
	 public ResponseEntity<ApiResponse<Account>> createAccount(@Valid @RequestBody AccountDto dto){
		try {
			Account mappedAccount = mapper.map(dto);
			Account createdAccount = service.create(mappedAccount);
			return new ResponseEntity<>(new ApiResponse<Account>(createdAccount, null), HttpStatus.CREATED);
		} catch (ErrorException e) {
			return new ResponseEntity<>(new ApiResponse<Account>(null, e), HttpStatus.BAD_REQUEST);
		}
	 }

	 @GetMapping
	 public ResponseEntity<ApiResponse<List<Account>>> getAccounts(@Valid @RequestParam int id){
		 List<Account> accounts = service.accountsByUserId(id);
		 return new ResponseEntity<>(new ApiResponse<List<Account>>(accounts, null), HttpStatus.OK);
	 }
}
