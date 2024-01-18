package mainController;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import common.Address;
import common.ControllerPath;
import common.Encry;
import common.InjectionProtect;
import detail.Goods_Detail.Goods_Detail_DTO;
import detail.Goods_Detail.Goods_Detail_Service;
import detail.Set_Parts.Set_Parts_Service;
import detail.User_Address.User_Address_DTO;
import detail.User_Address.User_Address_Service;
import detail.Users.Users_DTO;
import detail.Users.Users_Service;


//첫 경로와 유효성검사 컨트롤러

@Controller
public class MainController implements ControllerPath{
	private Users_Service users_Service;
	private User_Address_Service user_Address_Service;
	private Goods_Detail_Service goods_Detail_Service;
	private Set_Parts_Service set_Parts_Service;
	
	public MainController(Users_Service users_Service,User_Address_Service user_Address_Service,Goods_Detail_Service goods_Detail_Service,
			Set_Parts_Service set_Parts_Service) {
		this.users_Service = users_Service;
		this.user_Address_Service = user_Address_Service;
		this.goods_Detail_Service = goods_Detail_Service;
		this.set_Parts_Service = set_Parts_Service;
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

	@RequestMapping("addr/change")
	@ResponseBody
	public void addrChange(HttpSession session,int v) {
		Users_DTO user_DTO = (Users_DTO)session.getAttribute("login");
		user_DTO.setUserAddr_no(v);
		users_Service.userUpdate(user_DTO);
	}
	
	
	@RequestMapping("getItemDetail")
	@ResponseBody
	public Map<String,Object> getItemDetail(int v) {
		List<Map<String,Object>> tableList = goods_Detail_Service.getGoodsDetailList(v);
		Map<Integer,List<Map<String,Object>>> setMap = new HashMap<>();
		for(Map<String,Object> one : tableList) {
			int set = Integer.parseInt(String.valueOf(one.get("SETCHECK")));
			if(set == 1) {
				int no = Integer.parseInt(String.valueOf(one.get("GOODSDETAIL_NO")));
				List<Map<String,Object>> list = set_Parts_Service.getSetList(no);
				if(!list.isEmpty())
					setMap.put(no, list);
			}
		}
		Map<String,Object> resultMap = new HashMap<String, Object>();
		resultMap.put("tableList", tableList);
		resultMap.put("setMap", setMap);
		return resultMap;
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
	
	
	
	
	@RequestMapping("test")
	@ResponseBody
	public void test(String json,HttpSession session) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper om = new ObjectMapper();
		
		Map<String,List<Map<String,Object>>> orderMap = new HashMap<String, List<Map<String,Object>>>();
		

		
		
		Map<String,Object> jsonMap = om.readValue(json, new TypeReference<Map<String, Object>>() {});
	
		for(String key : jsonMap.keySet()) {
			List<List<Map<String,Object>>> jsonList = (List<List<Map<String,Object>>>)jsonMap.get(key);
			orderMap.put(key, new ArrayList<Map<String,Object>>());
			for(List<Map<String,Object>> parts : jsonList) {
				List<Integer> menuNo = new ArrayList<Integer>();
				List<String> menuName = new ArrayList<String>();
				
				for(Map<String,Object> part : parts) {
					menuNo.add((Integer)part.get("no"));
					menuName.add((String)part.get("name"));
				}
				int index = listIndexSearch(orderMap.get(key), menuNo);
				
				if(index == -1) {
					Map<String,Object> parameterMap = new HashMap<String, Object>();
					List<Map<String,Object>> goodsList = goods_Detail_Service.getGoodsDetailList(Integer.parseInt(key)); 
					parameterMap.put("menuNo", menuNo);
					parameterMap.put("menuNo", menuNo);
					parameterMap.put("cnt",1);
					orderMap.get(key).add(parameterMap);
				}else {
					orderMap.get(key).get(index).compute("cnt", (k,v) -> (int)v+1);
				}
			}
		}
		session.setAttribute("orderMap", orderMap);
	}
	
	public int listIndexSearch(List<Map<String,Object>> list,List<Integer> target) {
		for(int i = 0; i < list.size(); i++) {
			if(((List<Integer>)list.get(i).get("menuNo")).equals(target)) {
				return i;
			}
		}
		
		return -1;
	}

	
	
//	@RequestMapping("re")
//	public String redirect(HttpServletRequest req) {
//		req.setAttribute("a", 1);
//		return "/";
//		return "redirect:/";//포워드와 리다이렉트 차이 실험
//	}
	
}
