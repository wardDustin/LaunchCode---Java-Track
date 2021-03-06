package banking;

public class ContinuousStrategy implements Compoundable{

	private double interestRate;
	
	public ContinuousStrategy(double interestRate){
		this.interestRate = interestRate;
	}
	
	@Override
	public double compoundInterest(double balance) {
		return balance*Math.pow(Math.E, interestRate);
		
	}
}
