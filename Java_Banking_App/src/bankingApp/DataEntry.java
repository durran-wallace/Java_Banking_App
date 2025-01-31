package bankingApp;

public class DataEntry {

	// Validation of string data with no limit
	public static boolean checkString(String dataInput) {
		boolean valid = dataInput instanceof String;
		return valid;
	}
	
	// Validation of max string length
	public static boolean checkMaxStringLen(String dataInput, int maxLength) {
		boolean valid = true;
		if (dataInput.length() > maxLength) {
         valid = false;
		} 
		return valid;
    }
	
	// Validation of exact string length
	public static boolean checkExactStringLen(String dataInput, int exactLength) {
		boolean valid = true;
		if (dataInput.length() != exactLength) {
			valid = false;
		}
		return valid;
	}
	
	// Validation of string with only numeric characters
	public static boolean checkNumString(String dataInput) {
		boolean valid = true;
		for (int i = 0; i < dataInput.length(); i++) {
			if (!Character.isDigit(dataInput.charAt(i))){
				valid = false;
			}
		}
		return valid;
	}
	
	// Validation of int data
	public static boolean checkInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
		
	// Validation of int data with range limit
	
	
	// Validation of decimal data
	
	
	// Validation of decimal data with range limit
	
	
	// Validation of date input
	
	
	// Validation of state abbreviation
	public static boolean checkState(String input) {
		boolean valid = false;
		String cust_state = input;
		String[] States = {
		        "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA",
		        "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD",
		        "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
		        "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC",
		        "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"
		    };
		for (int i = 0; i < 50; i++) {
			if(cust_state.toUpperCase().equals(States[i])) {
				valid = true;
				break;
			}
		}
	   	return valid;    
	}
	
	
}
