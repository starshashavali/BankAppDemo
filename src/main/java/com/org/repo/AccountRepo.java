package com.org.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.entity.Account;

public interface AccountRepo  extends JpaRepository<Account,Long>{

}
