// File: Database.java
// Specify package
package com.megabankcorp.system;

// Refer to the Account class by using its simple name.
import com.megabankcorp.records.Account;

// Class must be abstract since it has abstract methods.
public abstract class Database {

  // Abstract and accessible to all classes in any package.
  public abstract void deposit(Account acc, double amount);

  // Abstract and accessible to all classes in any package.
  public abstract void withdraw(Account acc, double amount);

  // Abstract and accessible to all classes within its own package
  // and to subclasses in other packages.
  protected abstract double balance(Account acc);

  // Cannot be overridden by a subclass and only accessible
  // to classes within its own package.
  final void transfer(Account from, Account to, double amount) {
    withdraw(from, amount);
    deposit(to, amount);
  }
}