package com.bank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entities.Accounts;
import com.bank.services.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	
	// find all account details\
	@GetMapping("/accounts")
	public ResponseEntity<List<Accounts>> getAccounts(){
		List<Accounts> list = this.accountService.getAllAccounts();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
		
		
	}
	
	
	// Find account details by account_Id
	
	@GetMapping("/accounts/{account_Id}")
	public ResponseEntity<Accounts> getAccount(@PathVariable("account_Id") long account_Id){
		Accounts account=  this.accountService.getAccountById(account_Id);
		if(account==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}
		return ResponseEntity.of(Optional.of(account));
		
	}
	
	
		// Add new Accounts 
		
		@PostMapping("/accounts")
		public ResponseEntity<Accounts> addAccount(@RequestBody Accounts acc){
			Accounts account = null;
			try {
				account = this.accountService.addAccount(acc);
				return ResponseEntity.of(Optional.of(account));
				
				
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
			
		}
		
		//Update accounts details
		
		@PutMapping("/accounts/{account_Id}")
		public ResponseEntity<Accounts> updateAccount(@RequestBody Accounts account, @PathVariable("account_Id") long account_Id){
			try {
				this.accountService.updateAccount(account,account_Id);
				return ResponseEntity.ok().body(account);
				
			} catch (Exception e) {
				// TODO: handle exception
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
			
		}
		
		//  delete account by their account_Id
		
		@DeleteMapping("/accounts/{account_Id}")
		public ResponseEntity<Void> deleteAccount(@PathVariable("account_Id") long account_Id){
			try {
				this.accountService.deleteAccount(account_Id);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
		
		
	
	
	

}
