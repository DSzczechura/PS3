package base;

public class InsufficientFundsException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private double amount;
	
	/**
	 * Constructs the InsufficientFundsException
	 * @param amount - represents the amount being withdrawn
	 */
	public InsufficientFundsException(double amount){
		this.amount = amount;
	}
	
	public double getAmount(){
		return amount;
	}

}