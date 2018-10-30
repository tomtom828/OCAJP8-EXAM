package com.megabank.system;

import com.megabank.records.Account;

abstract public class Database {


  // Deposit dollar amount into account
  abstract public void deposit(double amount, Account account);


  // Withdraw dollar amount from account
  abstract public void withdraw(double amount, Account account);


  // Get Balance of current Account
  abstract protected void balance(Account account);


  // Transer funds between accounts
  final void transfer(double amount, Account account1, Account account2) {

    // Withdraw from account 1
    this.withdraw(amount, account1);

    // Deposit into account 2
    this.deposit(amount, account2);

  }


  // Proof that I compiled it right ;)
	public static void main(String[] args) {
		Account myAccount = new Account();
		System.out.println("Hit Database");
	}


}