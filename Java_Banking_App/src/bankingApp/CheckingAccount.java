package bankingApp;
import java.time.LocalDate;

public class CheckingAccount extends Account implements AccountInterface{
	private LocalDate transactionDate;
	private String transactionType;
	private double transactionAmount;
	
	private static final double SERVICE_FEE = 0.50;
	private static final double OVERDRAFT_FEE = 30.00;
	private static final double INTEREST_RATE = .02;

	public CheckingAccount(String accountNumber) {
		super(accountNumber, "CHK", SERVICE_FEE, INTEREST_RATE, OVERDRAFT_FEE, 0.0);
	}
	
	@Override
	public void deposit(double amount) {
//		if (amount > 0) {
			setBalance(getBalance() + amount - getService_fee());
			recordTransaction("DEP", amount);
	}
	@Override
	public void withdrawal(double amount) {

	    double currentBalance = getBalance();
	    double newBalance = currentBalance - (amount + getService_fee());

	    // Check if there are sufficient funds
	    if (newBalance >= 0) {
	        setBalance(newBalance);
	        recordTransaction("WTH", amount);
	        System.out.println("\nWithdrawal successful. New Balance: $" + getBalance());
	    } else {
	        // Apply overdraft fee if overdrawn
	        double overdraftBalance = newBalance - getOverdraft_fee();
	        setBalance(overdraftBalance);
	        recordTransaction("WTH", amount);
	        System.out.println("Overdraft! A $" + getOverdraft_fee() + " fee has been applied.");
	        System.out.println("New Balance: $" + getBalance());
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