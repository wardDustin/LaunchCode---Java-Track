package banking;

public class CheckingAccount extends Account{
	
	private boolean overdraftProtection;
	private final int OVERDRAFT_CHARGE = 25;
	
	public CheckingAccount(double balance, int accountNumber, String owner){
		super(balance, accountNumber, owner, 500);
		this.overdraftProtection = false;
	}
	
//	public double withdraw(double amount){
//		if(amount > super.balance){
//			
//		}
//	}
	

}
