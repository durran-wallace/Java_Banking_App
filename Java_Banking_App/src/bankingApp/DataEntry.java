package bankingApp;

public class DataEntry {

	   // Validation of max string length   
	   public static boolean checkMaxStringLen(String customer_id, int maxLength) {
	      boolean valid = true;
	      if (customer_id.length() > maxLength) {
	         valid = false;
	      } 
	      return valid;
	   }
	
}
