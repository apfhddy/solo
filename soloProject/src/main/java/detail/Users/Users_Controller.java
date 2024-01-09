package detail.Users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import common.ControllerPath;
import common.DB;
import detail.User_Address.User_Address_DTO;
import detail.User_Address.User_Address_Service;

@Controller
public class Users_Controller implements ControllerPath{
	private Users_Service users_Service;
	private User_Address_Service user_Address_Service;
	
	public Users_Controller(Users_Service users_Service,User_Address_Service user_Address_Service) {
		this.users_Service = users_Service;
		this.user_Address_Service = user_Address_Service;
	}
	
	public void service() {
		System.out.println("dd");
	}
	
	@RequestMapping("join/addr")
	public String joinInput1(HttpSession session) {
		session.setAttribute("join", new HashMap<String, Object>());
		return LOGIN+"joinAddrInput.jsp";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("join/detail")
	public String joinInput2(HttpSession session,User_Address_DTO dto){
		((Map<String,Object>)session.getAttribute("join")).put("addr", dto);
		return LOGIN+"joinDetailInput.jsp";
	}
	

	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("join/certified")
	public String test(HttpSession session,Users_DTO dto) {
		((Map<String,Object>)session.getAttribute("join")).put("detail", dto);
		insertData(session);
		return "redirect:/";
	}
	
	@SuppressWarnings("unchecked")
	public void insertData(HttpSession session) {
		Map<String,Object> userData = (Map<String,Object>)session.getAttribute("join");
		
		int success = users_Service.insertUser(userData);
		
		if(success == 1) {
			session.removeAttribute("join");
		}
	}
	
	@RequestMapping("myPage")
	public String myPage(HttpServletRequest req) {
		List<User_Address_DTO> addrList = user_Address_Service.allAddrList(DB.bigDecimal(DB.sessionUnBoxing(req.getSession(), "login").get("USER_NO")));
		req.setAttribute("addrList", addrList);
		return MYPAGE+"address.jsp";
	}
	
	
	
	
}
