package detail.User_Address;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import common.ControllerPath;
import common.DB;

@Controller
public class User_Address_Controller implements ControllerPath{
	private User_Address_Service user_Address_Service;
	
	public User_Address_Controller(User_Address_Service user_Address_Service) {
		this.user_Address_Service = user_Address_Service;
	}
	
	@RequestMapping("myPage/addr")
	public String myPageAddress(HttpServletRequest req) {
		return MYPAGE+"addrInput.jsp";
	}

	@RequestMapping("myPage/addr/update")
	public String addrUpdate(HttpSession session,User_Address_DTO dto,int addressType) {
		
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("significant", dto.getSignificant());
		map.put("detail", dto.getDetail());
		map.put("location", dto.getLocation());
		map.put("user_no", DB.bigDecimal(DB.sessionUnBoxing(session, "login").get("USER_NO")));
		map.put("num", addressType);
		user_Address_Service.rownumUpdate(map);
		
		return "redirect:/myPage";
	}
	
	@RequestMapping("myPage/addr/delete")
	public String addrDelete(HttpSession session,int addressType) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("user_no", DB.bigDecimal(DB.sessionUnBoxing(session, "login").get("USER_NO")));
		map.put("num", addressType);
		user_Address_Service.addrDelete(map);
		
		return "redirect:/myPage";
	}
	
	@RequestMapping("myPage/addr/add")
	public String addrinsert(HttpSession session,User_Address_DTO dto) {
		dto.setUser_no(DB.bigDecimal(DB.sessionUnBoxing(session, "login").get("USER_NO")));
		user_Address_Service.addrInsert(dto);
		return "redirect:/myPage";
	}
	
	
}
