package com.emilindadie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.emilindadie.exception.ErrorException;
import com.emilindadie.model.User;
import com.emilindadie.model.UserDao;


@Service()
public class UserServiceImpl implements UserService{

	@Autowired UserDao dao;
	
	@Autowired
    private PasswordEncoder passwordEncoder;

	@Override
	public User createUser(User user) throws ErrorException{
		if(user.validProperty()) {
			System.out.println(user.getEmail());
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return dao.save(user);
		} else {
			throw new ErrorException("Invalid", "All field are requiered");	
		}
	}

	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
