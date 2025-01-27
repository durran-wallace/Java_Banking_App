package bankingApp;

import java.util.Scanner;

public class BankAcctApp {
   
   public static void main(String[] args) {
      // Get Scanner object for input
      Scanner input = new Scanner(System.in);
      
      // Get data for new customer
      System.out.print("Enter Customer ID (non-blank, 5 chars max): ");
      String cust_id = input.nextLine();
      
      // validate data input
      while (cust_id.length() == 0 || !DataEntry.checkMaxStringLen(cust_id, 5)) {
         System.out.println("Error: Customer ID nust be non-blank and 5 chars max");
         System.out.print("Enter Customer ID (non-blank, 5 chars max): ");
         cust_id = input.nextLine();
      }
      
      // Data is valid so create new customer      
      Customer cust1 = new Customer(cust_id);
      
      // Close Scanner object
      input.close();
      
      // Display created customer data
      System.out.println("cust1 data: customer_id: " + cust1.toString());
   }
}
