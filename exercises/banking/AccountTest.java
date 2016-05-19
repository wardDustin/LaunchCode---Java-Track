package banking;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {

	private Account dAccount;
	
	@Before
	public void setUp(){
		this.dAccount = new Account(100, 1, "Dustin", 50);
	}
	
	@Test
	public void testWithdrawSuccess() {
		assertTrue("Withdraw constructor failure", dAccount.getBalance()==100);
		assertTrue("Withdraw fail because ammount", dAccount.withdraw(25)==true);
		assertTrue("Withdraw fail because incorrect balance after withdraw", dAccount.getBalance()==75);
	}
	
	@Test
	public void testWithdrawFail() {
		assertTrue("Withdraw constructor failure", dAccount.getBalance()==100);
		assertTrue("Withdraw fail because ammount", dAccount.withdraw(75)==false);
		assertTrue("Withdraw fail because incorrect balance after withdraw", dAccount.getBalance()==100);
	}
	
	@Test
	public void testDeposit(){
		assertTrue("Incorrect balance", dAccount.getBalance()==100);
		assertTrue("Deposit fail because ammount", dAccount.deposit(100)==true);
		assertTrue("Deposit fail, incorrect balance after deposit", dAccount.getBalance()==200);
	}
	
	@Test
	public void testNegativeBalance(){
		
		try{
			Account a = new Account(23, 1, "Dustin", 25);
		}
		catch(IllegalArgumentException e){
			
		}
		catch(Exception e){
			fail("Illegal Argument Exception");
		}
	}

}
