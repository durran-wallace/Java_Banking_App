package bankingApp;

public class Account {

	// Instance Variables
	private String account_number;
	private String account_type;
	private double service_fee;
	private double interest_rate;
	private double overdraft_fee;
	private double balance;
	
	// Create new account
	public Account(String account_num, String acct_type, double svc_fee, double interest_rt, double ovrdrft_fee, double bal) {
		account_number = account_num;
		account_type = acct_type;
		service_fee = svc_fee;
		interest_rate = interest_rt;
		overdraft_fee = ovrdrft_fee;
		balance = bal;
		
	}
	
	// Setter methods
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public void setService_fee(double service_fee) {
		this.service_fee = service_fee;
	}
	public void setInterest_rate(double interest_rate) {
		this.interest_rate = interest_rate;
	}
	public void setOverdraft_fee(double overdraft_fee) {
		this.overdraft_fee = overdraft_fee;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	// Getter methods
	public String getAccount_number() {
		return account_number;
	}
	public String getAccount_type() {
		return account_type;
	}
	public double getService_fee() {
		return service_fee;
	}
	public double getInterest_rate() {
		return interest_rate;
	}
	public double getOverdraft_fee() {
		return overdraft_fee;
	}
	public double getBalance() {
		return balance;
	}
	
	// Return account data
	   public String toString() {
	      return (account_number + account_type + service_fee + interest_rate + overdraft_fee + balance) ;
	   }
}
