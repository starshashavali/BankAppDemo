package com.org.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.dto.AccountDto;
import com.org.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountRestController {

	private AccountService service;

	@Autowired
	public AccountRestController(AccountService service) {
		this.service = service;
	}

	@PostMapping("/save")
	public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto account) {
		AccountDto status = service.createAccount(account);
		return ResponseEntity.status(HttpStatus.CREATED).body(status);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountdtls(@PathVariable Long id) {
		AccountDto status = service.getAccountDtls(id);
		return ResponseEntity.status(HttpStatus.OK).body(status);
	}

	@PutMapping("/deposit/{id}/{amount}")
	public ResponseEntity<AccountDto> depositAccount(@PathVariable Long id, @PathVariable Double amount) {
		AccountDto status = service.deposit(id, amount);
		return ResponseEntity.status(HttpStatus.OK).body(status);
	}
	
	@PutMapping("/withdraw/{id}/{amount}")
	public ResponseEntity<AccountDto> withdrawAmout(@PathVariable Long id, @PathVariable Double amount) {
		AccountDto status = service.withdraw(id, amount);
		return ResponseEntity.status(HttpStatus.OK).body(status);
	}

}
