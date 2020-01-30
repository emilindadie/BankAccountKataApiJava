package com.emilindadie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.emilindadie.dao.UserDao;
import com.emilindadie.exception.ErrorException;
import com.emilindadie.model.User;


@Service()
public class UserServiceImpl implements UserService{

	@Autowired UserDao dao;
	
	@Autowired
    private PasswordEncoder passwordEncoder;

	@Override
	public User signUpUser(User user) throws ErrorException {
		System.out.println("Onnne");
		if(user.validProperty()) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return dao.save(user);
		} 
		throw new ErrorException("failed to create user", "All field are requiered");	
	}

	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User signInUser(String email, String password) throws ErrorException {
		if(validSignInUserValue(email, password)) {
			System.out.println(email);
			System.out.println(password);
			User loginUser = dao.findByEmail(email);
			System.out.println(loginUser.getPassword());
			if(loginUser != null && passwordEncoder.matches(password, loginUser.getPassword())) {
				return loginUser;  
			}
			throw new ErrorException("failed to login", "Wrong email or password");
		} else {
			throw new ErrorException("failed to login", "Email and password is required");
		}
	}

	@Override
	public Boolean validSignInUserValue(String email, String password) {
		return !email.isEmpty() && !password.isEmpty();
	}
}
