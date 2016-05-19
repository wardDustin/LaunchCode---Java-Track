
public class Fraction {
	private int numerator;
	private int denominator;
	private int wholeNum = 0;
	
	public Fraction(int numerator, int denominator){
		this.numerator = numerator;
		this.denominator = denominator;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
            return true;
        }
		
		if (!(obj instanceof Fraction)) {
            return false;
        }
		
		Fraction c = (Fraction) obj;
		
		return Integer.compare(numerator, c.numerator) == 0 && Integer.compare(denominator, c.denominator)==0;
	}
	
	@Override
	public int hashCode() {
	    return this.hashCode();
	}

	public int getNumerator(){
		return this.numerator;
	}
	
	public int getDenominator(){
		return this.denominator;
	}
	
	public void setNumerator(int newNumerator){
		this.numerator = newNumerator;
	}
	
	public void setDenominator(int newDenominator){
		this.denominator = newDenominator;
	}
	
	public Fraction multiplyEm(Fraction otherFraction){
		int newNumerator = this.numerator * otherFraction.numerator;
		int newDenominator = this.denominator * otherFraction.denominator;
		Fraction newFraction = new Fraction(newNumerator, newDenominator);
		return newFraction.simplify();
	}
	
	public Fraction addEm(Fraction otherFraction){
		if (this.denominator == otherFraction.denominator){
			int newNumerator = this.numerator + otherFraction.numerator;
			Fraction newFraction = new Fraction(newNumerator, this.denominator);
			return newFraction.simplify();
		}
		
		int newDenominator = this.denominator * otherFraction.denominator;
		int thisNumerator = this.numerator * otherFraction.denominator;
		int otherNumerator = otherFraction.numerator * this.denominator;
		int newNumerator = thisNumerator + otherNumerator;
		Fraction newFraction = new Fraction(newNumerator, newDenominator);
		return newFraction.simplify();
	}
	
	public Fraction takeRecip(){
		int newNumerator = this.denominator;
		int newDenominator = this.numerator;
		Fraction newFrac = new Fraction(newNumerator, newDenominator);
		return newFrac.simplify();
	}
	
	public Fraction simplify(){
		Fraction newFrac = new Fraction(this.numerator, this.denominator);
		
		if (newFrac.numerator == newFrac.denominator){
			newFrac.wholeNum++;
			newFrac.numerator = newFrac.denominator = 0;
			return newFrac;
		}
		else if (newFrac.numerator > newFrac.denominator){
			while(newFrac.numerator > newFrac.denominator){
				newFrac.numerator = newFrac.numerator - newFrac.denominator;
				newFrac.wholeNum++;
			}
			
			if (newFrac.numerator == newFrac.denominator){
				newFrac.wholeNum++;
				newFrac.numerator = newFrac.denominator = 0;
			}
			else{
				for (int i = 2; i <= newFrac.numerator; i++){
					while (newFrac.numerator % i == 0 && newFrac.denominator % i == 0){
						newFrac.numerator = newFrac.numerator / i;
						newFrac.denominator = newFrac.denominator / i;
					}
				}
			}
			return newFrac;
		}
		else{
			for (int i = 2; i<=newFrac.numerator; i++){
				while (newFrac.numerator % i == 0 && newFrac.denominator % i == 0){
					newFrac.numerator = newFrac.numerator / i;
					newFrac.denominator = newFrac.denominator / i;
				}
			}
			return newFrac;
		}
	}
	
	public String toString(){
		return "Numerator: " + numerator + " Denominator: " + denominator + " Fraction: " + wholeNum + " " + numerator + "/" + denominator;
	}
	
	public static void main (String args[]){
		Fraction myFraction = new Fraction(60, 20);
		Fraction otherFraction = new Fraction (3, 5);
		System.out.println(myFraction);
		System.out.println(otherFraction);
		System.out.println(myFraction.toString() + " multiplied by " + otherFraction.toString() + " equals " + myFraction.multiplyEm(otherFraction));
		System.out.println(myFraction.toString() + " added to " + otherFraction.toString() + " equals " + myFraction.addEm(otherFraction));
		System.out.println(myFraction.takeRecip());
		System.out.println(myFraction.simplify());
		
	}
}
