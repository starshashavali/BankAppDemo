package com.org.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.org.dto.AccountDto;
import com.org.entity.Account;

@Component
public class AccountMapper {

	public AccountDto mapEntityToDto(Account account) {
		AccountDto dto = new AccountDto();
		BeanUtils.copyProperties(account, dto);

		return dto;

	}

	public Account mapDtoToEntity(AccountDto account) {
		Account entity = new Account();
		BeanUtils.copyProperties(account, entity);
		return entity;

	}

}
