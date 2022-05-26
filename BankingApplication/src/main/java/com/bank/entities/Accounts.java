package com.bank.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Accounts {

	@Id
	private long account_Id;
	private String userName;
	private double balance;
	@Temporal(TemporalType.DATE)
	private Date openDate = new Date(System.currentTimeMillis());
	
	
	
	public long getAccount_Id() {
		return account_Id;
	}
	public void setAccount_Id(long account_Id) {
		this.account_Id = account_Id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	@Override
	public String toString() {
		return "Accounts [account_Id=" + account_Id + ", userName=" + userName + ", balance=" + balance + ", openDate="
				+ openDate + "]";
	} 
	
	
	
}
