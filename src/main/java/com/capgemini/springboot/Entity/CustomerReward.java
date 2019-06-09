package com.capgemini.springboot.Entity;

import java.util.List;

public class CustomerReward {
	

	private List<Transaction> transactionsList;
	
	public CustomerReward(List<Transaction> transactionsList) {
		super();
    this.transactionsList = transactionsList;
	}

	public List<Transaction> getTransactionsList() {
		return transactionsList;
	}

	public void setTransactionsList(List<Transaction> transactionsList) {
		this.transactionsList = transactionsList;
	}
	
}
	
	
