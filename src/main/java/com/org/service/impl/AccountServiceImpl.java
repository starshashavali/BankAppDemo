package com.org.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.dto.AccountDto;
import com.org.entity.Account;
import com.org.exception.AccountNotFoundException;
import com.org.repo.AccountRepo;
import com.org.service.AccountService;
import com.org.util.AccountMapper;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepo accountRepo;

	private AccountMapper mapper;

	@Autowired
	public AccountServiceImpl(AccountRepo accountRepo, AccountMapper mapper) {

		this.accountRepo = accountRepo;
		this.mapper = mapper;
	}

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account mapDtoToEntity = mapper.mapDtoToEntity(accountDto);
		Account save = accountRepo.save(mapDtoToEntity);
		return mapper.mapEntityToDto(save);
	}

	@Override
	public AccountDto getAccountDtls(Long id) {
		Account entity = accountRepo.findById(id)
				.orElseThrow(() -> new AccountNotFoundException("Account not exist..."));

		return mapper.mapEntityToDto(entity);
	}

	@Override
	public AccountDto deposit(Long id, Double amount) {
		Account entity = accountRepo.findById(id)
				.orElseThrow(() -> new AccountNotFoundException("Account not exist..."));

		Double total = entity.getBalance() + amount;
		entity.setBalance(total);
		Account save = accountRepo.save(entity);

		return mapper.mapEntityToDto(save);
	}

	@Override
	public AccountDto withdraw(Long id, Double amount) {
		Account entity = accountRepo.findById(id)
				.orElseThrow(() -> new AccountNotFoundException("Account not exist..."));

		if (entity.getBalance() < amount) {
			throw new RuntimeException("insufficient balance...");

		}
		Double availableBalance = entity.getBalance() - amount;

		entity.setBalance(availableBalance);
		Account save = accountRepo.save(entity);

		return mapper.mapEntityToDto(save);
	}

}
