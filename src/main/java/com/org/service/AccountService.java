package com.org.service;

import com.org.dto.AccountDto;

public interface AccountService {
	
	public AccountDto createAccount(AccountDto accountDto);
	
	public AccountDto getAccountDtls(Long  id);
	
	public AccountDto deposit(Long id, Double amount);
	
	public AccountDto withdraw(Long id, Double amount);

	
	

}
