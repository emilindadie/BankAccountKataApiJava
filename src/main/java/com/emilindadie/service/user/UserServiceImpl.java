package com.emilindadie.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.emilindadie.dao.UserDao;
import com.emilindadie.exception.ErrorException;
import com.emilindadie.model.User;
import com.emilindadie.validator.UserValidator;


@Service()
public class UserServiceImpl implements UserService{

	@Autowired UserDao dao;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired UserValidator validator;

	@Override
	public User signUpUser(User user) throws ErrorException {
		if(validator.isValid(user)) {
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
	public User signInUser(User user) throws ErrorException {
		if(validator.isvalidSignIn(user)) {
			User loginUser = dao.findByEmail(user.getEmail());
			if(loginUser != null && !loginUser.getName().isEmpty() && passwordEncoder.matches(user.getPassword(), loginUser.getPassword())) {
				System.out.println("not exception");
				return loginUser;
			}
			throw new ErrorException("failed to login", "Wrong email or password");
		} else {
			throw new ErrorException("failed to login", "Email and password is required");
		}
	}
}
