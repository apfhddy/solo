package common;

import java.util.Map;

import javax.servlet.http.HttpSession;

public class DB {
	
	@SuppressWarnings("unchecked")
	public static Map<String,Object> sessionUnBoxing(HttpSession session, String key){
		return (Map<String,Object>)session.getAttribute(key);
	}
	
	public static int bigDecimal(Object o) {
		return Integer.parseInt(String.valueOf(o));
	}
}
