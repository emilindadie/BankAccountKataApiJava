package com.emilindadie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emilindadie.model.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Long> {   
	//@Query("select a from Account INNER join u from User on u.id = a.user_id Where u.id = ?1")
    //@Query(value = "SELECT * from account INNER JOIN user on user.id = account.user_id WHERE user.id = ?1", nativeQuery = true)
	@Query(value = "SELECT * from Account where Account.user_id = ?1", nativeQuery = true)
	List<Account> findByUserId(int id);
}
