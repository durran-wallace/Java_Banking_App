package bankingApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAcctApp {
   
   public static void main(String[] args) {
      List<Customer> customers = new ArrayList<>();
	   
	   // Get Scanner object for input
      Scanner input = new Scanner(System.in);
      
      while (true) {
          System.out.print("Would you like to enter a new customer? (y/n): ");
          String response = input.nextLine().toLowerCase();

          if (!response.equals("n") && !response.equals("y")) {
              System.out.println("Please enter 'y' or 'n'");
              continue;
          } else if (response.equals("n")) {
        	  break;
          }
	      // Get id for new customer
	      System.out.print("Enter Customer ID (non-blank, 5 chars max): ");
	      String cust_id = input.nextLine();
	      
	      // validate data input
	      while (cust_id.length() == 0 || !DataEntry.checkMaxStringLen(cust_id, 5)) {
	         System.out.println("Error: Customer ID must be non-blank and 5 chars max");
	         System.out.print("Enter Customer ID (non-blank, 5 chars max): ");
	         cust_id = input.nextLine();
	      }
	      
	      // Get ssn for new customer
	      System.out.print("Enter Customer SSN (must be a 9 digit number): ");
	      String cust_ssn = input.nextLine();
	      
	      // validate data input
	      while (!DataEntry.checkExactStringLen(cust_ssn, 9) || !DataEntry.checkNumString(cust_ssn)) {
	         System.out.println("Error: Customer SSN must be a 9 digit number");
	         System.out.print("Enter Customer SSN (must be a 9 digit number): ");
	         cust_ssn = input.nextLine();
	      }
	      
	      //Get last name of new customer
	      System.out.print("Enter Customer Last Name (non-blank, 20 chars max): ");
	      String cust_lastname = input.nextLine();
	      
	      while (cust_lastname.length() == 0 || !DataEntry.checkMaxStringLen(cust_lastname, 20)) {
	          System.out.println("Error: Customer Last Name must be non-blank and 20 chars max");
	          System.out.print("Enter Customer Last Name (non-blank, 20 chars max): ");
	          cust_lastname = input.nextLine();
	       }
	      
	      //Get first name of new customer
	      System.out.print("Enter Customer First Name (non-blank, 15 chars max): ");
	      String cust_firstname = input.nextLine();
	      
	      while (cust_firstname.length() == 0 || !DataEntry.checkMaxStringLen(cust_firstname, 15)) {
	          System.out.println("Error: Customer First Name must be non-blank and 15 chars max");
	          System.out.print("Enter Customer First Name (non-blank, 15 chars max): ");
	          cust_firstname = input.nextLine();
	       }
	      
	      //Get address of new customer
	      System.out.print("Enter Customer Street Address (non-blank, 20 chars max): ");
	      String cust_address = input.nextLine();
	      
	      while (cust_address.length() == 0 || !DataEntry.checkMaxStringLen(cust_address, 20)) {
	          System.out.println("Error: Customer Street Address must be non-blank and 20 chars max");
	          System.out.print("Enter Customer Street Address (non-blank, 20 chars max): ");
	          cust_address = input.nextLine();
	       }
	      
	      //Get city of new customer
	      System.out.print("Enter Customer City (non-blank, 20 chars max): ");
	      String cust_city = input.nextLine();
	      
	      while (cust_city.length() == 0 || !DataEntry.checkMaxStringLen(cust_city, 20)) {
	          System.out.println("Error: Customer City must be non-blank and 20 chars max");
	          System.out.print("Enter Customer City (non-blank, 20 chars max): ");
	          cust_city = input.nextLine();
	       }
	      
	      // Get state of new customer
	      System.out.print("Enter Customer State (non-blank, 2 chars): ");
	      String cust_state = input.nextLine();
	      
	      while (!DataEntry.checkExactStringLen(cust_state, 2) || !DataEntry.checkState(cust_state)) {
	          System.out.println("Error: Must enter state's 2 character abbreviation");
	          System.out.print("Enter Customer State (2 chars): ");
	          cust_state = input.nextLine();
	       }
	      
	      // Get zip code of new customer
	      System.out.print("Enter Customer Zip-code (5-digit number)");
	      String cust_zip = input.nextLine();
	      
	      while (!DataEntry.checkExactStringLen(cust_zip, 5) || !DataEntry.checkInt(cust_zip)) {
	    	  System.out.println("Error: Customer zip-code must be a 5 digit number.");
	    	  System.out.println("Enter Customer Zip-Code (5 digit number)");
	    	  cust_zip =input.nextLine();
	      }
	         
	      // Get phone number code of new customer
	      System.out.print("Enter Customer Phone Number(10 digit number)");
	      String cust_phone = input.nextLine();
	      
	      while (!DataEntry.checkExactStringLen(cust_phone, 10) || !DataEntry.checkNumString(cust_phone)) {
	    	  System.out.println("Error: Customer phone number must be a 10 digit number.");
	    	  System.out.println("Enter Customer Phone Number (10 digit number)");
	    	  cust_phone = input.nextLine();
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
