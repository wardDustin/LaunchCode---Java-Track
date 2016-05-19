package banking;

public class SavingsAccount extends Account{
	
	private final int MAX_WITHDRAWLS = 6;
	private int currentWithdrawls;
	private Compoundable interestStrategy;
	
	/*
	 * Behavoirs:
	 * Compounding interest
	 * Counting withdrawls (P(1+r/n)^nt)
	 */
	
	public SavingsAccount(double balance, int accountNumber, String owner, Compoundable strategy){
		super(balance, accountNumber, owner, 500);
		this.currentWithdrawls = 0;
		this.interestStrategy = strategy;
	}
	
	public void compoundInterest(){
		this.balance = this.interestStrategy.compoundInterest(this.getBalance());
	}
	
	public boolean withdrawls(double amount){
		
		if (this.currentWithdrawls < this.MAX_WITHDRAWLS){
			boolean result = super.withdraw(amount);
			if (result){
				this.currentWithdrawls++;
				return true;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args){
		ContinuousStrategy cs = new ContinuousStrategy(0.1);
		NonContinuousStrategy ncs = new NonContinuousStrategy(12, 0.1);
		SavingsAccount dustinsAccount = new SavingsAccount(10000, 1, "Dustin Ward", cs);
		SavingsAccount dougsAccount = new SavingsAccount(10000, 2, "Doug Shook", ncs);
		
		dougsAccount.compoundInterest();
		dustinsAccount.compoundInterest();
		System.out.println("Continuous: " + dustinsAccount.getBalance());
		System.out.println("Non-Continuous: " + dougsAccount.getBalance());
	}
}
