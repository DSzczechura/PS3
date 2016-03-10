package base;

import java.text.DateFormat;
import java.util.Date;


/**
 * @author DSzczechura
 *
 */

public class Account {
	/**
	 * Account class attributes
	 */
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated = new Date();

	/**
	 * Default Account Constructor (sets all account values to defaults)
	 */
	public Account() {
		this.id = 0;
		this.balance = 0;
		this.annualInterestRate = 0;
		this.dateCreated = new Date();
	}

	/**
	 * Account Constructor
	 * @param id - double that represents the Account's ID number
	 * @param balance = double that represents the Account's Balance
	 */
	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
	}

	/**
	 * @return - id (Account's ID number)
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id - sets the Account's ID number
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return - balance (Account's Balance)
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance - sets the Account's Balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @return - annualInterestRate (Account's Annual Interest Rate)
	 */
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	/**
	 * @param annualInterestRate - sets the Account's Annual Interest Rate
	 */
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	/**
	 * @return - dateCreated (When the Account was created)
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	/**
	 * @return - monthly_rate (the monthly rate of the Account)
	 */
	public double getMonthlyInterestRate() {
		double monthly_rate = annualInterestRate / 12;
		return monthly_rate;
	}

	/**
	 * @param x - represents the amount being withdrawn from the Account
	 * @throws InsufficientFundsException - thrown if withdrawn amount is greater than balance
	 */
	public void withdraw(double x) throws InsufficientFundsException {
		if(x <= balance){
			balance = balance - x;
		}
		else{
			double needs = x - balance;
			throw new InsufficientFundsException(needs);
		}
	}

	/**
	 * @param x - represents the amount being deposited into the Account
	 */
	public void deposit(double x) {
		balance = balance + x;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Balance: " + this.balance + ", Monthly Interest Rate: " + this.getMonthlyInterestRate() + ", Date: "
				+ DateFormat.getDateInstance(DateFormat.SHORT).format(this.dateCreated);
	}

}