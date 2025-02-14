package bankingApp;

import java.util.ArrayList;
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
	      
	      //Get last name of new customer
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
	      
	      // Add new customer to customer array list
	      customers.add(newCustomer);
	      
	      // Display created customer data
	      System.out.println("customer data: \ncustomer_id: " + newCustomer.getCustomer_id() + "\ncustomer_ssn: " + newCustomer.getCustomer_ssn() + "\ncustomer_lastname: " + newCustomer.getCustomer_lastname() + "\ncustomer_firstname: " + newCustomer.getCustomer_firstname() + "\ncustomer_address: " + newCustomer.getCustomer_street() + "\ncustomer_city: " + newCustomer.getCustomer_city() + "\ncustomer_state: " + newCustomer.getCustomer_state() + "\ncustomer_zip: " + newCustomer.getCustomer_zip() + "\ncustomer_phone: " + newCustomer.getCustomer_phone());
      }
      // Close Scanner object
      input.close();
   }
}
