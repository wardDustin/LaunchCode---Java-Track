package banking;

public class NonContinuousStrategy implements Compoundable{

	private int periods;
	private double interestRate;
	
	public NonContinuousStrategy(int periods, double interestRate){
		this.periods = periods;
		this.interestRate = interestRate;
	}
	
	@Override
	public double compoundInterest(double balance) {
		double rOverN = 1 + this.interestRate / periods;
		rOverN = Math.pow(rOverN, periods);
		balance = balance * rOverN;
		return balance;
		
	}
}
