package util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Formatter {
	
	/**
	 * Method responsible for rounding off a given double
	 * 
	 * @param value value to be rounded
	 * @param decimalPlaces number of decimal places after rounding
	 * @return the rounded double
	 */
	public static double round(double value, int decimalPlaces) {
		
	    if (decimalPlaces < 0) {
	    	throw new IllegalArgumentException();
	    }
	 
	    BigDecimal bd = new BigDecimal(Double.valueOf(value));
	    
	    bd = bd.setScale(decimalPlaces, RoundingMode.HALF_UP);
	    
	    return bd.doubleValue();
	    
	}

}
