package com.bank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.AccountRepository;
import com.bank.entities.Accounts;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	
	
	// Find All Accounts Details
	public List<Accounts> getAllAccounts() {
		// TODO Auto-generated method stub
		List<Accounts> list = (List<Accounts>)this.accountRepository.findAll();
		return list;
	}

	// Find Accounts Details by Id

	public Accounts getAccountById(long account_Id) {
		// TODO Auto-generated method stub
		Accounts account = null;
		try {
			account = this.accountRepository.findById(account_Id);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return account;
	}
	
	
	// Add accounts
	
	public Accounts addAccount(Accounts account) {
		// TODO Auto-generated method stub
		Accounts result = this.accountRepository.save(account);
		return result;
	}

	
	// Update Account details
	public void updateAccount(Accounts account, long account_Id) {
		account.setAccount_Id(account_Id);
		this.accountRepository.save(account);
		
	}
	
	
	// Delete Account by their account_Id
	
	public void deleteAccount(long account_Id) {
		this.accountRepository.deleteById(account_Id);
	}
	
	
	
	

}
