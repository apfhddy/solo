package mainController;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import common.Address;
import common.ControllerPath;
import common.Encry;
import common.InjectionProtect;
import detail.User_Address.User_Address_DTO;
import detail.User_Address.User_Address_Service;
import detail.Users.Users_DTO;
import detail.Users.Users_Service;


//첫 경로와 유효성검사 컨트롤러

@Controller
public class MainController implements ControllerPath{
	private Users_Service users_Service;
	private User_Address_Service user_Address_Service;
	
	public MainController(Users_Service users_Service,User_Address_Service user_Address_Service) {
		this.users_Service = users_Service;
		this.user_Address_Service = user_Address_Service;
	}
	
	
	@RequestMapping("/")
	public String home(HttpServletRequest req) {
		
		if(req.getSession().getAttribute("login") != null) {
			int user_no = ((Users_DTO)req.getSession().getAttribute("login")).getUser_no();
			List<User_Address_DTO> userAddrList = user_Address_Service.getAddrList(user_no); 
			req.setAttribute("userAddrList", userAddrList);
		}
		
		return HOME;
	}
	
	
	
	
	
	//주소 데이터 유효성 검사
	@RequestMapping("searchAddr")
	@ResponseBody
	public Map<String,Object> searchAddr(String str) throws UnsupportedEncodingException, IOException {
		Map<String,Object> returnMap = new HashMap<String, Object>(); 
		
		if(InjectionProtect.checkSQL(str)) {
			returnMap.put("err", "0");
			
			String result = Address.getAddress(str);
			
			returnMap.put("result", result);
			return returnMap;
		}else {
			returnMap.put("err", "1");
			return returnMap;
		}
		
	}
	
	//회원가입 내용 체크
	@RequestMapping("join/deatilCheck")
	@ResponseBody
	public int deatilCheck() {
		return 0;
	}
	
	//로그인 여기있는 이유 어드민도 로그인 하니 
	@RequestMapping("check/login")
	@ResponseBody
	public Map<String,Object> loginCheck(HttpServletRequest req,String id,String pw) {
		
//		if(!InjectionProtect.checkStr(id)) {
//			return "003"; 
//		}
		Map<String,Object> returnMap = new HashMap<String, Object>();
		
		boolean err = users_Service.loginCheck(id, pw);
		returnMap.put("err", err);
		
		if(err) {
			returnMap.put("code", "003");
		}
		
		return returnMap;
	}
	
	@RequestMapping("check/emailOrPhone")
	@ResponseBody
	public boolean checkEmailOrPhone(int type,String value){
		
		return users_Service.checkEmailOrPhone(type,value);
	}
	
	@RequestMapping("check/password")
	@ResponseBody
	public boolean checkPassword(HttpSession session,String pw) {
		Users_DTO user_DTO = (Users_DTO)session.getAttribute("login");
		String salt = user_DTO.getSalt();
		return user_DTO.getPw().equals(Encry.encry(pw, salt));
	}
	
	
	
	@RequestMapping("login")
	public String login(HttpSession session,String id,String pw) {
		
		Users_DTO users_DTO = users_Service.userSelect(id);
		if(users_DTO == null)return "에러페이지";
		
		pw = Encry.encry(pw,users_DTO.getSalt()); 
		
		if(!((String)users_DTO.getPw()).equals(pw))return "에러페이지";
		
		session.setAttribute("login", users_DTO);
		
		return "redirect:/";
	}
	
	
	@RequestMapping("login/logOut")
	public String logOut(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
	
	
	
	
	
	
	
	

	
	
//	@RequestMapping("re")
//	public String redirect(HttpServletRequest req) {
//		req.setAttribute("a", 1);
//		return "/";
//		return "redirect:/";//포워드와 리다이렉트 차이 실험
//	}
	
}
