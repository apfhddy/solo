package common;

public class InjectionProtect {
	static final String[] sqlArray = {"OR", "SELECT", "INSERT", "DELETE", "UPDATE"
			,"CREATE", "DROP", "EXEC", "UNION"
			,"FETCH", "DECLARE", "TRUNCATE"};
	
	static final String[] charArray = {
			"[","%","=",">","<","]" ,"'","\""};
	
	
	
	public static boolean checkSQL(String str) {
		String upperStr = str.toUpperCase();
		
		if(!checkChar(upperStr))return false;
		
		for(String sql : sqlArray) {
			   if(upperStr.contains(sql)) {
				   return false;
			   }
		}
		return true;
	}
	
	public static boolean checkChar(String str) {
		for(String sql : sqlArray) {
			if(str.contains(sql)) {
				return false;
			}
		}
		return true;
	}
}
