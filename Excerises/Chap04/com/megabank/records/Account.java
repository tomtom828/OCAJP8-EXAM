package com.megabank.records;

public class Account {

  // Initial Balance @ 0.0 dollars
  protected double balance;

  // Returns Balance
  public double getBalance() {
    return balance;
  }

	// Proof that I compiled it right ;)
	static {
		System.out.println("Hit Account");
	}

}