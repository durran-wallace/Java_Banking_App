package bankingApp;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class BankAcctApp {
   
   public static void main(String[] args) {
      List<Customer> customers = new ArrayList<>();
      Boolean running = true;
	   
	   // Get Scanner object for input
      Scanner input = new Scanner(System.in);
      
      while (running) {
    	  
    	  boolean valid_data = false;
    	  
    	  // Prompt to add customer or end loop
    	  while (!valid_data) {    		  
    		  try {	    	  
		          System.out.print("Would you like to enter a new customer? (y/n): ");
		          String response = input.nextLine().toLowerCase();
		          
		          // Validate input
		          if (!response.equals("n") && !response.equals("y")) {
		              throw new IllegalArgumentException("Input must be 'y' or 'n'.");
	          } 
	          
	          valid_data = true;
	          
	          if (response.equals("n")) {
	        	  return;
	          }
    		  
    		  } catch (IllegalArgumentException e) {
		          System.out.println("Error: " + e.getMessage());
	          }    		  
    	  }
    	  
	      // Get id for new customer
	      valid_data = false;
	      String cust_id = "";
	      while(!valid_data) {
	    	  try {
	    		  // Get id for new customer
	    	      System.out.print("Enter Customer ID (non-blank, 5 chars max): ");
	    	      cust_id = input.nextLine();
	    	      if (cust_id.length() == 0 || !DataEntry.checkMaxStringLen(cust_id, 5)) {
	    	    	  throw new IllegalArgumentException("Customer ID cannot be blank and must contain a maximum of 5 characters");
	    	      }
	    	      valid_data = true;
	    	  } catch (IllegalArgumentException e) {
	    		  System.out.println("Error: " + e.getMessage());
	    	  }
	      }
	     
	   // Get ssn for new customer 
	     valid_data = false;
	     String cust_ssn = "";
	     while(!valid_data) {
	    		try {	    			
	    			System.out.print("Enter Customer SSN (must be a 9 digit number): ");
	    		    cust_ssn = input.nextLine();
	    		    if (!DataEntry.checkExactStringLen(cust_ssn, 9) || !DataEntry.checkNumString(cust_ssn)) {
	    		         throw new IllegalArgumentException("Customer SSN cannot be blank, can only contain numeric characters, and must be exactly 9 digits.");
	    		    }
	    			valid_data = true;
	    		} catch (IllegalArgumentException e) {
	    			System.out.println("Error: " + e.getMessage());
	    		}
	    	}
	      
	      // Get last name of new customer
	      valid_data = false;
	      String cust_lastname = "";
	      while(!valid_data) {
	    	  try {
	    		  System.out.print("Enter Customer Last Name (non-blank, 20 chars max): ");
	    	      cust_lastname = input.nextLine();
	    	      if (cust_lastname.length() == 0 || !DataEntry.checkMaxStringLen(cust_lastname, 20)) {
	    	          throw new IllegalArgumentException("Customer Last Name cannot be blank and must contain a maximum of 20 characters.");
	    	      }
	    	      valid_data = true;	    	      
	    	  } catch (IllegalArgumentException e) {
	    			System.out.println("Error: " + e.getMessage());
	    	  }
	      }
	      
	      //Get first name of new customer
	      valid_data = false;
	      String cust_firstname = "";
	      while(!valid_data) {
	    	  try {
	    		  System.out.print("Enter Customer First Name (non-blank, 15 chars max): ");
	    	      cust_firstname = input.nextLine();
	    	      if (cust_firstname.length() == 0 || !DataEntry.checkMaxStringLen(cust_firstname, 15)) {
	    	          throw new IllegalArgumentException("Customer First Name cannot be blank and must contain a maximum of 15 characters.");
	    	      }
	    	      valid_data = true;	    	      
	    	  } catch (IllegalArgumentException e) {
	    			System.out.println("Error: " + e.getMessage());
	    	  }
	      }
	      
	      //Get address of new customer
	      valid_data = false;
	      String cust_address = "";
	      while(!valid_data) {
	    	  try {
	    		  System.out.print("Enter Customer Address (non-blank, 20 chars max): ");
	    	      cust_address = input.nextLine();
	    	      if (cust_address.length() == 0 || !DataEntry.checkMaxStringLen(cust_address, 20)) {
	    	          throw new IllegalArgumentException("Customer Address cannot be blank and must contain a maximum of 20 characters.");
	    	      }
	    	      valid_data = true;	    	      
	    	  } catch (IllegalArgumentException e) {
	    			System.out.println("Error: " + e.getMessage());
	    	  }
	      }
	      
	      //Get city of new customer
	      valid_data = false;
	      String cust_city = "";
	      while(!valid_data) {
	    	  try {
	    		  System.out.print("Enter Customer City (non-blank, 20 chars max): ");
	    	      cust_city = input.nextLine();
	    	      if (cust_city.length() == 0 || !DataEntry.checkMaxStringLen(cust_city, 20)) {
	    	          throw new IllegalArgumentException("Customer City cannot be blank and must contain a maximum of 20 characters.");
	    	      }
	    	      valid_data = true;	    	      
	    	  } catch (IllegalArgumentException e) {
	    			System.out.println("Error: " + e.getMessage());
	    	  }
	      }
	      
	      // Get state of new customer
	      valid_data = false;
	      String cust_state = "";
	      while(!valid_data) {
	    	  try {
	    		  System.out.print("Enter Customer State abbreviated(non-blank, 2 chars): ");
	    	      cust_state = input.nextLine();
	    	      if (!DataEntry.checkExactStringLen(cust_state, 2) || !DataEntry.checkState(cust_state)) {
	    	          throw new IllegalArgumentException("Customer State cannot be blank and must contain the states two character abbreviation.");
	    	      }
	    	      valid_data = true;	    	      
	    	  } catch (IllegalArgumentException e) {
	    			System.out.println("Error: " + e.getMessage());
	    	  }
	      }
	      
	      // Get zip code of new customer
	      valid_data = false;
	      String cust_zip = "";
	      while(!valid_data) {
	     		try {	    			
	    			System.out.print("Enter Customer Zip (must be a 5 digit number): ");
	    		    cust_zip = input.nextLine();
	    		    if (!DataEntry.checkExactStringLen(cust_zip, 5) || !DataEntry.checkNumString(cust_zip)) {
	    		         throw new IllegalArgumentException("Customer Zip cannot be blank, can only contain numeric characters, and must be exactly 5 digits.");
	    		    }
	    			valid_data = true;
	    		} catch (IllegalArgumentException e) {
	    			System.out.println("Error: " + e.getMessage());
	    		}
	      }
	         
	      // Get phone number code of new customer
	      valid_data = false;
	      String cust_phone = "";
	      while(!valid_data) {
	     		try {	    			
	    			System.out.print("Enter Customer Phone (must be a 10 digit number): ");
	    		    cust_phone = input.nextLine();
	    		    if (!DataEntry.checkExactStringLen(cust_phone, 10) || !DataEntry.checkNumString(cust_phone)) {
	    		         throw new IllegalArgumentException("Customer Phone cannot be blank, can only contain numeric characters, and must be exactly 10 digits.");
	    		    }
	    			valid_data = true;
	    		} catch (IllegalArgumentException e) {
	    			System.out.println("Error: " + e.getMessage());
	    		}
	      }
	   
	      // Data is valid so create new customer      
	      Customer newCustomer = new Customer(cust_id, cust_ssn, cust_lastname, cust_firstname, cust_address, cust_city, cust_state, cust_zip, cust_phone);
	      
	      // Add accounts
	      List<Account> accounts = new ArrayList<>();
		  boolean addingAccounts = true;
			
		  while (addingAccounts) {
		      // Step 1: Prompt to add an account
		      boolean validAccountInput = false;
		      String accountChoice = "";

		      while (!validAccountInput) {
		          try {
		              System.out.print("Would you like to enter a new account for this customer? (y/n): ");
		              accountChoice = input.nextLine().trim().toLowerCase();

		              if (!accountChoice.equals("y") && !accountChoice.equals("n")) {
		                  throw new IllegalArgumentException("Invalid input. Please enter 'y' or 'n'.");
		              }
		              validAccountInput = true;
		          } catch (IllegalArgumentException e) {
		              System.out.println("Error: " + e.getMessage());
		          }
		      }

		      // If the user selects "no", exit to adding another customer
		      if (accountChoice.equals("n")) {
		          break;
		      }

		      // Step 2: Collect Account Details
		      valid_data = false;
		      String account_num = "";
		      while(!valid_data) {
		    	  try {
		    		  // Get account number for new account
		    	      System.out.print("Enter Account Number (5 characters max) ");
		    	      account_num = input.nextLine();
		    	      if (account_num.length() == 0 || !DataEntry.checkMaxStringLen(account_num, 5)) {
		    	    	  throw new IllegalArgumentException("Account number cannot be blank and must contain a maximum of 5 characters");
		    	      }
		    	      valid_data = true;
		    	  } catch (IllegalArgumentException e) {
		    		  System.out.println("Error: " + e.getMessage());
		    	  }
		      }

		      String acct_type = "";
		      while (true) {
		          try {
		              System.out.print("Enter Account Type ('CHK' or 'SAV'): ");
		              acct_type = input.nextLine().trim().toUpperCase();
		              if (!acct_type.equals("CHK") && !acct_type.equals("SAV")) {
		                  throw new IllegalArgumentException("Must input either 'CHK' or 'SAV'.");
		              }
		              break;
		          } catch (IllegalArgumentException e) {
		              System.out.println("Error: " + e.getMessage());
		          }
		      }

		      Account newAccount;
		      if (acct_type.equals("CHK")) {
		          newAccount = new CheckingAccount(account_num);
		      } else {
		          newAccount = new SavingsAccount(account_num);
		      }

		      accounts.add(newAccount);
		      newCustomer.setAccounts(accounts);  // Attach accounts to customer immediately

		      // Step 3: Process Transactions After Adding an Account
		      boolean makingTransactions = true;
		      while (makingTransactions) {
		          boolean validTransactionInput = false;
		          String transactionChoice = "";

		          while (!validTransactionInput) {
		              try {
		                  System.out.print("Would you like to make a transaction for this account? (y/n): ");
		                  transactionChoice = input.nextLine().trim().toLowerCase();

		                  if (!transactionChoice.equals("y") && !transactionChoice.equals("n")) {
		                      throw new IllegalArgumentException("Invalid input. Please enter 'y' or 'n'.");
		                  }
		                  validTransactionInput = true;
		              } catch (IllegalArgumentException e) {
		                  System.out.println("Error: " + e.getMessage());
		              }
		          }

		          // If the user selects "no", exit transactions and go back to adding another account
		          if (transactionChoice.equals("n")) {
		        	  if (newAccount.getBalance() > 0) {
			        	  newAccount.setBalance(newAccount.getBalance() * (1 + newAccount.getInterest_rate()));
			        	  System.out.println("\nApplying " + newAccount.getInterest_rate() + "% earned interest.");
			        	  System.out.println("\nNew balance with accrued interest: " + newAccount.getBalance() + "\n");
			              break;
		        	  } else {
		        		  System.out.println("\nNo interest accrued. Current balance is: " + newAccount.getBalance() + "\n");
		        		  break;
		        	  }
		          }

		          // Ask for Transaction Type (DEP or WTH)
		          boolean validTransactionType = false;
		          String transactionType = "";

		          while (!validTransactionType) {
		              try {
		                  System.out.print("Enter transaction type (DEP/WTH): ");
		                  transactionType = input.nextLine().trim().toUpperCase();

		                  if (!transactionType.equals("DEP") && !transactionType.equals("WTH")) {
		                      throw new IllegalArgumentException("Invalid transaction type. Please enter 'DEP' or 'WTH'.");
		                  }
		                  validTransactionType = true;
		              } catch (IllegalArgumentException e) {
		                  System.out.println("Error: " + e.getMessage());
		              }
		          }

		          // Step 5: Ask for Transaction Amount
		          boolean validAmount = false;
		          double amount = 0.0;

		          while (!validAmount) {
		              try {
		                  System.out.print("Enter transaction amount: ");
		                  String amountInput = input.nextLine();
		                  amount = Double.parseDouble(amountInput);

		                  if (amount <= 0) {
		                      throw new IllegalArgumentException("Transaction amount must be greater than zero.");
		                  }

		                  validAmount = true;
		              } catch (NumberFormatException e) {
		                  System.out.println("Error: Invalid number format. Please enter a valid numeric amount.");
		              } catch (IllegalArgumentException e) {
		                  System.out.println("Error: " + e.getMessage());
		              }
		          }

		          // Step 6: Process Transaction
		          if (transactionType.equals("DEP")) {
		              newAccount.deposit(amount);
		          } else if (transactionType.equals("WTH")) {
		              newAccount.withdrawal(amount);
		          }

		          // Step 7: Display Formatted Transaction Details
		          System.out.println("\nTransaction Details:");
		          System.out.printf("%-15s %-15s %-10s %-15s %-10s %-10s %-15s %-10s%n",
		                            "Customer ID", "Account No.", "Type", "Date", "Txn Type", "Amount", "Fees", "Balance");
		          System.out.printf("%-15s %-15s %-10s %-15s %-10s $%-9.2f $%-14.2f $%-9.2f%n",
		                            newCustomer.getCustomer_id(),
		                            newAccount.getAccount_number(),
		                            newAccount.getAccount_type(),
		                            LocalDate.now(),
		                            transactionType,
		                            amount,
		                            newAccount.getService_fee(),
		                            newAccount.getBalance());

		          System.out.println("\nUpdated Balance: $" + newAccount.getBalance() + "\n");
		      }
		  }


	      
	      // Add new customer to customer array list
	      customers.add(newCustomer);
	      
	      // Display created customer data
	      System.out.println("\nCustomer Data:");
	      System.out.printf("%-20s %-20s %-20s %-20s %-20s%n", 
	                        "Customer ID", "SSN", "Last Name", "First Name", "Address");
	      System.out.printf("%-20s %-20s %-20s %-20s %-20s%n", 
	                        newCustomer.getCustomer_id(), 
	                        newCustomer.getCustomer_ssn(), 
	                        newCustomer.getCustomer_lastname(), 
	                        newCustomer.getCustomer_firstname(), 
	                        newCustomer.getCustomer_street());
	      System.out.println("");
	      System.out.printf("%-20s %-20s %-20s %-20s%n", 
	                        "City", "State", "Zip", "Phone");
	      System.out.printf("%-20s %-20s %-20s %-20s%n", 
	                        newCustomer.getCustomer_city(), 
	                        newCustomer.getCustomer_state(), 
	                        newCustomer.getCustomer_zip(), 
	                        newCustomer.getCustomer_phone());

	      // Display customer accounts
	      if (newCustomer.getAccounts().isEmpty()) {
	    	    System.out.println("No accounts available.");
	    	} else {
	    	    for (Account acct : newCustomer.getAccounts()) {
	    	    	System.out.println("\nAccount Data:");

	    	    	System.out.printf("%-20s %-15s %-15s %-15s %-15s %-15s%n", 
	    	    	                  "Account Number", "Account Type", "Service Fee", "Interest Rate", "Overdraft Fee", "Balance");

	    	    	System.out.printf("%-20s %-15s $%-14.2f %-15.2f $%-14.2f $%-14.2f%n", 
	    	    	                  acct.getAccount_number(), 
	    	    	                  acct.getAccount_type(), 
	    	    	                  acct.getService_fee(), 
	    	    	                  acct.getInterest_rate(), 
	    	    	                  acct.getOverdraft_fee(), 
	    	    	                  acct.getBalance());
	    	    	System.out.println("");

	    	    }
	    	}
      	  }
      // Close Scanner object
      input.close();
   }
}
