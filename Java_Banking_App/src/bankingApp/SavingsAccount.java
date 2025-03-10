package bankingApp;
import java.time.LocalDate;

public class SavingsAccount extends Account implements AccountInterface {
	private LocalDate transactionDate;
	private String transactionType;
	private double transactionAmount;
	
	private static final double SERVICE_FEE = 0.25;
	private static final double INTEREST_RATE = .05;

	public SavingsAccount(String accountNumber) {
		super(accountNumber, "SAV", SERVICE_FEE, INTEREST_RATE, 0.0, 0.0);
	}
	
	@Override
	public void deposit(double amount) {
		setBalance((getBalance() * (1 + (INTEREST_RATE/100))) + (amount - getService_fee()));
		recordTransaction("DEP", amount);
	}
	@Override
	public void withdrawal(double amount) {

		double currentBalance = getBalance();
	    double newBalance = ((currentBalance * (1 + (INTEREST_RATE/100))) - (amount + getService_fee()));

	    // Check if there are sufficient funds
	    if (newBalance >= 0) {
	        setBalance(newBalance);
	        recordTransaction("WTH", amount);
	        System.out.println("\nWithdrawal successful. New Balance: $" + getBalance());       
	    } else {
	    	System.out.println("\nERROR: Insufficient funds.");
	    	return;
	    }
    }


		
	@Override
	public double balance() {
		return super.getBalance();
	}
	
	private void recordTransaction(String type, double amount) {
		if (!type.equals("WTH") && !type.equals("DEP")) {
	        throw new IllegalArgumentException("Invalid transaction type. Must be 'WTH' or 'DEP'.");
	    }
		
		this.transactionDate = LocalDate.now();
		this.transactionType = type;
		this.transactionAmount = amount;
		
		System.out.println("\nTransaction recorded: " + transactionType + " of $" + transactionAmount + " on " + transactionDate);
	}
	
	// Add method to retrieve transaction details
	public String getLastTransaction() {
		if (transactionType == null) {
			return "No transactions recorded.";
		}
		return "Last Transaction: " + transactionType + " of $" + transactionAmount + " on " + transactionDate;
	}

}