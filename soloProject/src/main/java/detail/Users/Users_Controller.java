package detail.Users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import common.ControllerPath;
import common.Encry;
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
	
	
	@RequestMapping("/join/addr")
	public String joinInput1(HttpSession session) {
		return LOGIN+"joinAddrInput.jsp";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("join/detail")
	public String joinInput2(HttpSession session,User_Address_DTO dto){
		session.setAttribute("join", new HashMap<String, Object>());
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
		List<User_Address_DTO> addrList = user_Address_Service.allAddrList(((Users_DTO)req.getSession().getAttribute("login")).getUser_no());
		req.setAttribute("addrList", addrList);
		return MYPAGE+"address.jsp";
	}
	
	
	@RequestMapping("myPage/userData")
	public String userData() {
		return MYPAGE+"userData.jsp";
	}
	
	@RequestMapping("myPage/userData/update")
	public String userUpdate(HttpSession session,String name,int gender,String phone) {
		Users_DTO user_DTO = (Users_DTO)session.getAttribute("login");
		user_DTO.setName(name);
		user_DTO.setGender(gender);
		user_DTO.setPhone(phone);
		
		users_Service.userUpdate(user_DTO);
		return "redirect:/";
	}
	
	@RequestMapping("myPage/password")
	public String myPassword() {
		return MYPAGE+"passwordUpdate.jsp";
	}
	
	@RequestMapping("myPage/password/Update")
	public String passwordUpdate(HttpSession session,String nowPassword,String newPassword,String newPasswordCheck) {
		
		
		Users_DTO users_DTO = (Users_DTO)session.getAttribute("login");
		if(!newPassword.equals(newPasswordCheck))return "나중에 처리할거";
		
		nowPassword = Encry.encry(nowPassword, users_DTO.getSalt());
		if(!users_DTO.getPw().equals(nowPassword))return "나중에 처리할거";
		
		String salt = Encry.getSalt();
		newPassword = Encry.encry(newPassword, salt);
		
		users_DTO.setSalt(salt);
		users_DTO.setPw(newPassword);
		
		users_Service.userUpdate(users_DTO);
		
		
		return "redirect:/";
	}
	
	
	
}
