package base;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author DSzczechura
 *
 */
public class Account_Test {

	Account test_account = new Account(1122, 20000);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		test_account.setAnnualInterestRate(0.045);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Tests getter for id
	 */
	@Test
	public void testGetId() {
		double expected = 1122;
		double actual = test_account.getId();
		assertEquals(expected, actual, 1);
	}

	/**
	 * Tests setter for id
	 */
	@Test
	public void testSetId() {
		double expected = 1111;
		test_account.setId(1111);
		double actual = test_account.getId();
		assertEquals(expected, actual, 1);
	}

	/**
	 * Tests getter for balance
	 */
	@Test
	public void testGetBalance() {
		double expected = 20000;
		double actual = test_account.getBalance();
		assertEquals(expected, actual, 1);
	}

	/**
	 * Tests setter for balance
	 */
	@Test
	public void testSetBalance() {
		double expected = 25000;
		test_account.setBalance(25000);
		double actual = test_account.getBalance();
		assertEquals(expected, actual, 0.01);
	}

	/**
	 * Tests getter for AnnualInterestRate
	 */
	@Test
	public void testGetAnnualInterestRate() {
		double expected = 0.045;
		double actual = test_account.getAnnualInterestRate();
		assertEquals(expected, actual, 0.01);
	}

	/**
	 * Tests setter for AnnualInterestRate
	 */
	@Test
	public void testSetAnnualInterestRate() {
		double expected = 0.089;
		test_account.setAnnualInterestRate(0.089);
		double actual = test_account.getAnnualInterestRate();
		assertEquals(expected, actual, 0.01);
	}

	/**
	 * Tests getter for dateCreated
	 */
	@Test
	public void testGetDate() {
		Account test_account_date = new Account();
		Date expected = new Date();
		Date actual = test_account_date.getDateCreated();
		assertEquals(expected, actual);
	}

	/**
	 * Tests the withdraw method
	 * 
	 * @throws InsufficientFundsException
	 */
	@Test
	public void testWithdraw() throws InsufficientFundsException {
		double expected = 17500;
		test_account.withdraw(2500);
		double actual = test_account.getBalance();
		assertEquals(expected, actual, 0.001);
	}

	/**
	 * Tests the InsufficientFundsException on the withdraw method
	 * 
	 * @throws InsufficientFundsException
	 */
	@Test(expected = InsufficientFundsException.class)
	public void testInsufficientFundsException() throws InsufficientFundsException {
		boolean thrown = false;
		try {
			test_account.withdraw(25000);
		} catch (IndexOutOfBoundsException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	/**
	 * Tests deposit method
	 */
	@Test
	public void testDeposit() {
		double expected = 23000;
		test_account.deposit(3000);
		double actual = test_account.getBalance();
		assertEquals(expected, actual, 0.001);

	}

	/**
	 * Tests overridden toString method
	 */
	@Test
	public void testToString() {
		String expected = "Balance: 20000.0, Monthly Interest Rate: 0.00375, Date: 3/9/16";
		String actual = test_account.toString();
		assertEquals(expected, actual);
	}
}