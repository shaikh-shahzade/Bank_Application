package com.bank.dao;

import org.springframework.data.repository.CrudRepository;

import com.bank.entities.Accounts;

public interface AccountRepository extends CrudRepository<Accounts, Long>{

	public Accounts findById(long account_Id);
	
}
