package com.emilindadie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.emilindadie.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {   
	@Query("select u from User u where u.email = ?1")
    User findByEmail(String email);
}
