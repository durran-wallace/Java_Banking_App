package bankingApp;

public class Customer {
	
	   // Instance variables
	   private String customer_id;
	   private String customer_lastname;
	   private String customer_firstname;
	   private String customer_street;
	   private String customer_city;
	   private String customer_state;
	   private String customer_zip;
	   private String customer_phone;
	   
	   
	   // Create new customer   
	   public Customer(String cust_id, String cust_lastname,String cust_firstname, String cust_street, String cust_city, String cust_state, String cust_zip, String cust_phone) {
	      customer_id = cust_id;
	      customer_lastname = cust_lastname;
	      customer_firstname = cust_firstname;
	      customer_street = cust_street;
	      customer_city = cust_city;
	      customer_state = cust_state;
	      customer_zip = cust_zip;
	      customer_phone = cust_phone;
	   }
	   
	// Setters
	   public void setCustomer_id(String customer_id) {
	       this.customer_id = customer_id;
	   }

	   public void setCustomer_lastname(String customer_lastname) {
	       this.customer_lastname = customer_lastname;
	   }

	   public void setCustomer_firstname(String customer_firstname) {
	       this.customer_firstname = customer_firstname;
	   }

	   public void setCustomer_street(String customer_street) {
	       this.customer_street = customer_street;
	   }

	   public void setCustomer_city(String customer_city) {
	       this.customer_city = customer_city;
	   }

	   public void setCustomer_state(String customer_state) {
	       this.customer_state = customer_state;
	   }

	   public void setCustomer_zip(String customer_zip) {
	       this.customer_zip = customer_zip;
	   }

	   public void setCustomer_phone(String customer_phone) {
	       this.customer_phone = customer_phone;
	   }

	   // Getters
	   public String getCustomer_id() {
	       return customer_id;
	   }

	   public String getCustomer_lastname() {
	       return customer_lastname;
	   }

	   public String getCustomer_firstname() {
	       return customer_firstname;
	   }

	   public String getCustomer_street() {
	       return customer_street;
	   }

	   public String getCustomer_city() {
	       return customer_city;
	   }

	   public String getCustomer_state() {
	       return customer_state;
	   }

	   public String getCustomer_zip() {
	       return customer_zip;
	   }

	   public String getCustomer_phone() {
	       return customer_phone;
	   }
	   
	   // Return customer data
	   public String toString() {
	      return (customer_id + customer_lastname + customer_firstname + customer_street + customer_city + customer_state + customer_zip + customer_phone) ;
	   }
}
