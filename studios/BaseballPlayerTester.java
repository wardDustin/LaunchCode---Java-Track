import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class BaseballPlayerTester {

	private BaseballPlayer dustin;
	
	@Before
	public void setUp(){
		dustin = new BaseballPlayer("Dustin Ward", 13, "right handed", 21, new int[]{12, 9});
	}
	
	@Test
	public void testRecordGame() {
		assertTrue("Error with recording game stats", dustin.getGamesPlayed()==21);
		dustin.recordGame(2, 2);
		assertTrue("Error with game addition", dustin.getGamesPlayed()==22);
	}
	
	@Test
	public void testAddToTotal() {
		assertTrue("Error with adding to total", Arrays.equals(dustin.addToTotal(new int[]{20, 12}), new int[]{32,21}));
	}

}
