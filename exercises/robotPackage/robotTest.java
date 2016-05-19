package robotPackage;

import static org.junit.Assert.*;

import org.junit.Before;

import java.util.Arrays;

import org.junit.Test;

public class robotTest {
	
	private Robot d, j, p, q;
	
	@Before
	public void setUp(){
		d = new Robot("Dustin", new int[]{2, 2}, 10, 180);
		j = new Robot("Justin", new int[]{3, 3}, 8, 0);
		p = new Robot("Bustin", new int[]{4, 4}, 3, 90);
		q = new Robot("Mustin", new int[]{5, 5}, 1, 270);
	}
	
	
	@Test
	public void testMoveNorth(){
		assertTrue("Error moving north", Arrays.equals(j.move(), new int[]{3, 11}));
	}
	
	@Test
	public void testMoveSouth(){
		assertTrue("Error moving south", Arrays.equals(d.move(), new int[]{2, -8}));
	}
	
	@Test
	public void testMoveEast(){
		assertTrue("Error moving east", Arrays.equals(p.move(), new int[] {7, 4}));
	}
	
	@Test
	public void testMoveWest(){
		assertTrue("Error moving west", Arrays.equals(q.move(), new int[]{4, 5}));
	}
	
	@Test
	public void testRotateRight(){
		assertTrue("Error turning right", d.rotate(true) == 270);
	}
	
	@Test
	public void testRotateLeft(){
		assertTrue("Error turning left", d.rotate(false) == 90);
	}
	
	@Test
	public void testDistanceFromOther(){
		Robot w = new Robot("Crustin", new int[]{6, 7}, 11, 90);
		assertTrue("Error calculating distance", j.distanceFromOther(w) == 5);
	}
}