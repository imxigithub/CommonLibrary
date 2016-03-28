package library.coship.com.androicommlibrary.com.coship.library.tools;

import android.text.TextUtils;

public class NumberUtil {
	
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return  if conver fail and return default value
	 */
	public static int converToInt(String intStr, int defValue ){
		
		try {
				return Integer.parseInt(intStr);
		} catch (Exception e) {
			e.printStackTrace();
			return defValue;
		}
	}
	
	public static long converToLong(String longStr,long defValue){
		try {
			return Long.parseLong(longStr);
		} catch (Exception e) {
			// TODO: handle exception
			return defValue;
		}
	}
	
	public static Double converToDouble(String doubleStr,double defValue){
			try {
				return Double.parseDouble(doubleStr);
			} catch (Exception e) {
				// TODO: handle exception
				return defValue;
			}
	}
	
	public static float converToFloat(String floatStr,float defValue){
		try {
			return Float.parseFloat(floatStr);
		} catch (Exception e) {
			// TODO: handle exception
			return defValue;
		}
	}
	
	public static char[] converToChar(String charString,char defValue[]){
			try {
				return charString.toCharArray();
			} catch (Exception e) {
				// TODO: handle exception
				return defValue;
			}
	}
	
	
	public static Integer converToInteger(String intString){
		
			try {
					return Integer.getInteger(intString);
			} catch (Exception e) {
				//handle exception
			}
		return null;
	}
	
	public static Long converToLong(String longStr){
		
		try {
				return Long.valueOf(longStr);
		} catch (Exception e) {
			//handle exception
		}
	return null;
}
	
	public static Double converToDouble(String dStr){
		
		try {
				return Double.valueOf(dStr);
		} catch (Exception e) {
			//handle exception
		}
	return null;
}
	
    public static Float convertToFloat(String fStr) {
        try {
            return Float.parseFloat(fStr);
        } catch (NumberFormatException e) {
            //e.printStackTrace();
        }
        return null;
    }
	
	
}
