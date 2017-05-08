package com.example.tollbooth;

import org.joda.money.Money;

public class TollPayment {
	
	Integer accountNumber;
	Money amount;
	
	public TollPayment(Integer accountNumber, Money amount) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public Money getAmount() {
		return amount;
	}
	
}
