package common;

public class InjectionProtect {
	static final String[] charArray = {"OR", "SELECT", "INSERT", "DELETE", "UPDATE"
			,"CREATE", "DROP", "EXEC", "UNION"
			,"FETCH", "DECLARE", "TRUNCATE","[","%","=",">","<","]" ,"'","\""};
	
	public static boolean checkStr(String str) {
		String upperStr = str.toUpperCase();
		
		for(String sql : charArray) {
			   if(upperStr.contains(sql)) {
				   return false;
			   }
		}
		return true;
	}
}
