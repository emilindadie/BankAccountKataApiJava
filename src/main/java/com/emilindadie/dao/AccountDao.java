package com.emilindadie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emilindadie.model.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Long> {   

}
