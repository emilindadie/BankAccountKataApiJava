package com.emilindadie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.emilindadie.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    @Async
    @Query(value = "SELECT u FROM User u WHERE u.email  = :email")
    User findByEmail(String email);
}
