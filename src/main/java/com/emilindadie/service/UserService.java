package com.emilindadie.service;

import com.emilindadie.exception.ErrorException;
import com.emilindadie.model.User;

public interface UserService {
	User createUser(User user) throws ErrorException;;
	User getUser();
}
