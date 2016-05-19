package banking;

import java.util.ArrayList;

public class Bank {
	/*
	 * Has-a
	 * 
	 * Routing Number
	 * Name
	 * Accounts
	 * Vault
	 * Amount of Money
	 * Location
	 * 
	 */
	/*
	 * implement multiple account linkage
	 */
	
	/*
	 * Behaviors
	 * 
	 * rob
	 * deposit
	 * withdraw
	 * create accounts
	 * close accounts
	 * 
	 */
	

	private int routingNum;
	private String name;
	private String location;
	private ArrayList<Account> accounts;
	private ArrayList<CheckingAccount> chkAccnt;
	private ArrayList<SavingsAccount> svngAccnt;

	public Bank(int routingNum, String name, String location){
		this.accounts = new ArrayList<Account>();
		this.routingNum = routingNum;
		this.name = name;
		this.location = location;
	}
	
	public void createAccount(double balance, String owner, boolean isChecking){
		int accountNum = accounts.size();
		Account a;
		if (isChecking){
			a = new CheckingAccount(balance, accountNum, owner);
			chkAccnt.add((CheckingAccount) a);
		}
		else{
			a = new SavingsAccount(balance, accountNum, owner, 0.25);
			svngAccnt.add((SavingsAccount) a);
		}
		accounts.add(a);
	}
	
	public void deposit(double amount, int accountNum){
		accounts.get(accountNum).deposit(amount);
	}
	
	public void withdraw(double amount, int accountNum){
		accounts.get(accountNum).withdraw(amount);
	}
}
