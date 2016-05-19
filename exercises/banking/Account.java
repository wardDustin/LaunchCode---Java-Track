package banking;
/**
 * This class represents a bank account... provides
 * withdraws, deposits, and transfers
 * @author drawnitsud
 *
 */
public class Account {
	
	/*
	 * An account has-a
	 * 
	 * balance
	 * account number
	 * type
	 * owner
	 * routing number
	 * signature card
	 * 
	 * Behaviors:
	 * 
	 * deposit
	 * withdraw
	 * overdraft
	 * transfer
	 * checking balance
	 * 
	 */
	
	protected double balance;
	private int accountNumber;
	private String owner;
	private boolean active;
	private double minBalance;
	
	public Account(double balance, int accountNumber, String owner, double minBalance){
		if (balance < 0){
			throw new IllegalArgumentException();
		}
		
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.owner = owner;
		this.minBalance = minBalance;
	}
	
	public double getBalance(){
		return this.balance;
	}
	
	public int getAccountNumber(){
		return this.accountNumber;
	}
	
	public String getOwner(){
		return this.owner;
	}
	
	public void setBalance(double newBalance){
		this.balance = newBalance;
	}
	
	public void setAccountingNumber (int newAccountNumber){
		this.accountNumber = newAccountNumber;
	}
	
	public void setOwner(String newOwner){
		this.owner = newOwner;
	}
	
	/**
	 * Withdraws money from this account
	 * @param amount amount of money to withdraw
	 * @return true if withdraw was successful
	 */
	
	public boolean withdraw(double amount){
		if (this.balance - minBalance >= amount){
			this.balance -= amount;
			return true;
		}
		return false;
	}
	
	public boolean deposit(double amount){
		/*
		 * check amount... if it is negative
		 * throw an exception
		 * 
		 */
		if (amount>0){
			this.balance += amount;
			return true;
		}
		return false;
	}
	
	public boolean transfer(Account from, double amount){
		if (from.withdraw(amount)){
			this.deposit(amount);
			return true;
		}
		return false;
	}
	
	public static void main (String args[]){
		Account dAccount = new Account(100, 1, "Dustin", 250);
		Account zAccount = new Account(1000, 2, "Zach", 250);
		System.out.println(dAccount.getBalance());
		dAccount.withdraw(20);
		System.out.println(dAccount.getBalance());
		dAccount.transfer(zAccount, 100);
		System.out.println(dAccount.getBalance());
		System.out.println(zAccount.getBalance());
	}
}
