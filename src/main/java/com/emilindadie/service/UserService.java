package com.emilindadie.service;

import com.emilindadie.exception.ErrorException;
import com.emilindadie.model.User;

public interface UserService {
	User signUpUser(User user) throws ErrorException;
	User getUser();
	User signInUser(String email, String password) throws ErrorException;
	Boolean validSignInUserValue(String email, String password);
}
