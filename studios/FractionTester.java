import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FractionTester {

	private Fraction newFraction, otherFraction, thirdFraction;
	
	@Before
	public void setUp(){
		newFraction = new Fraction(2, 4);
		otherFraction = new Fraction(5, 5);
		thirdFraction = new Fraction(8, 2);
	}

	@Test
	public void testMultiplyEm() {
		assertEquals("Faulty math when multiplying", newFraction.multiplyEm(otherFraction), new Fraction (1, 2));
	}
	
	@Test
	public void testAddEm() {
		assertEquals("Faulty math when adding", newFraction.addEm(otherFraction), new Fraction (1, 2));
	}
	
	@Test
	public void testTakeRecip(){
		assertEquals("Error when taking reciprical", thirdFraction.takeRecip(), new Fraction (1, 4));
	}
	
	@Test
	public void testSimplifyWhenNumeratorIsBigger(){
		assertEquals("Error when simplifying when numerator is bigger", newFraction.simplify(), new Fraction (1, 2));
	}
	
	@Test
	public void testSimplifyWhenDenominatorIsBigger(){
		assertEquals("Error when simplifying when denominator is bigger", thirdFraction.simplify(), new Fraction (0, 0));
	}
	
	@Test
	public void testSimplifyWhenDenomAndNumerAreSame(){
		assertEquals("Error when simplifying when denominator == numerator", otherFraction.simplify(), new Fraction (0, 0));
	}

}
