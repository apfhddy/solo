package detail.User_Address;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import common.Address;

@Controller
public class User_Address_Controller{
	final String[] charArray = {"OR", "SELECT", "INSERT", "DELETE", "UPDATE"
			 ,"CREATE", "DROP", "EXEC", "UNION"
			 ,"FETCH", "DECLARE", "TRUNCATE","[","%","=",">","<","]" };
	
	@RequestMapping("searchAddr")
	@ResponseBody
	public Map<String,Object> searchAddr(String str) throws UnsupportedEncodingException, IOException {
		Map<String,Object> returnMap = new HashMap<String, Object>(); 
		
		if(checkStr(str)) {
			returnMap.put("err", "0");
			
			String result = Address.getAddress(str);
			
			returnMap.put("result", result);
			return returnMap;
		}else {
			returnMap.put("err", "1");
			return returnMap;
		}
		
	}
	
	
	public boolean checkStr(String str) {
		String upperStr = str.toUpperCase();
		
		for(String sql : charArray) {
			   if(upperStr.contains(sql)) {
				   return false;
			   }
		}
		return true;
	}
}
