package encapsulation;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComputerTester {

	@Test
	public void testAddMemory() {
		Computer a = new Computer(4, 100, 100, "Lenovo");
		assertTrue("Problem setting memory in the constructor", a.getMemory()==4);
		a.addMemory(2);
		assertTrue(a.getMemory()==6);
	}
	
	@Test
	public void testAddMemoryMax() {
		Computer a = new Computer(8, 100, 100, "Lenovo");
		assertTrue("Problem setting memory in the constructor", a.getMemory()==8);
		a.addMemory(2);
		assertTrue("Problem adding memory in addMemory when we hit max", a.getMemory()==8);
	}
}
