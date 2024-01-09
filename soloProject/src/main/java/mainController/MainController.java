package mainController;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
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
import detail.Users.Users_Service;


//첫 경로와 유효성검사 컨트롤러

@Controller
public class MainController implements ControllerPath{
	private Users_Service useus_Service;
	
	public MainController(Users_Service useus_Service) {
		this.useus_Service = useus_Service;
	}
	
	
	@RequestMapping("/")
	public String home(HttpServletRequest req) {
		return HOME;
	}
	
	
	
	
	
	//주소 데이터 유효성 검사
	@RequestMapping("searchAddr")
	@ResponseBody
	public Map<String,Object> searchAddr(String str) throws UnsupportedEncodingException, IOException {
		Map<String,Object> returnMap = new HashMap<String, Object>(); 
		
		if(InjectionProtect.checkStr(str)) {
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
	@RequestMapping("login/check")
	@ResponseBody
	public String loginCheck(HttpServletRequest req,String id,String pw) {
		
		if(!InjectionProtect.checkStr(id)) {
			return "003"; 
		}
		
		Map<String,Object> users_MAP = useus_Service.userData(id);
		pw = Encry.encry(pw, (String)users_MAP.get("SALT"));
		
		if(!((String)users_MAP.get("PW")).equals(pw)) {
			return "001";
		}
		
		req.getSession().setAttribute("login", users_MAP);
		
		
		return "777";
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
