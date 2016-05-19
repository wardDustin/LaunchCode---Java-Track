import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RectangleTester {

	private Rectangle x, y, z;
	
	@Before
	public void setUp(){
		x = new Rectangle(5, 5);
		y = new Rectangle(6, 6);
		z = new Rectangle(4, 4);
	}

	@Test
	public void testIsSquare() {
		assertTrue("Square function error with boolean", x.isSquare()==true);
	}
	
	@Test
	public void testShowArea(){
		assertTrue("Area computed incorrectly", x.showArea() == 25);
	}
	
	@Test
	public void testShowPerim(){
		assertTrue("Perimeter computed incorrectly", x.showPerim() == 20);
	}
	
	@Test
	public void testBiggerOrSmallerIsSmaller(){
		
		assertTrue("Inccorect computation of smaller areas", x.biggerOrSmaller(y) == -11);
	}
	
	@Test
	public void testBiggerOrSmallerIsBigger(){
		
		assertTrue("Inccorect computation of bigger areas", x.biggerOrSmaller(z) == 9);
	}
	
	@Test
	public void testBiggerOrSmallerIsSame(){
		Rectangle a = new Rectangle (5, 5);
		assertTrue("Inccorect computation of same areas", x.biggerOrSmaller(a) == 0);
	}

}
