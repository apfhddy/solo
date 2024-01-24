package mainController;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.security.auth.NTSidUserPrincipal;

import common.Address;
import common.ControllerPath;
import common.Encry;
import common.InjectionProtect;
import detail.Goods_Detail.Goods_Detail_Service;
import detail.Parts_ChangeList.Parts_ChangeList_Service;
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
	private Parts_ChangeList_Service parts_ChangeList_Service;
	
	public MainController(Users_Service users_Service,User_Address_Service user_Address_Service,Goods_Detail_Service goods_Detail_Service,
			Set_Parts_Service set_Parts_Service,Parts_ChangeList_Service parts_ChangeList_Service) {
		this.users_Service = users_Service;
		this.user_Address_Service = user_Address_Service;
		this.goods_Detail_Service = goods_Detail_Service;
		this.set_Parts_Service = set_Parts_Service;
		this.parts_ChangeList_Service = parts_ChangeList_Service;
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
		for(User_Address_DTO add_DTO : (List<User_Address_DTO>)session.getAttribute("address")) {
			if(add_DTO.getUserAddr_no() == v) {
				session.setAttribute("mainAddr", add_DTO);
			}
		}
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

				for(Map<String,Object> oneParts : list) {
					int partsChangeNo = Integer.parseInt(String.valueOf(oneParts.get("PARTSCHANGE_NO")));
					if(partsChangeNo != 0) {
						List<Map<String,Object>> partsChengeList = parts_ChangeList_Service.getPartsChangeList(partsChangeNo);
						oneParts.put("partsChangeList", partsChengeList);
					}
				}
				
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
		
		List<User_Address_DTO> addrList = user_Address_Service.getAddrList(users_DTO.getUser_no()); 
		
		for(User_Address_DTO add_DTO : addrList) {
			if(add_DTO.getUserAddr_no() == users_DTO.getUserAddr_no()) {
				session.setAttribute("mainAddr", add_DTO);
			}
		}
		
		session.setAttribute("login", users_DTO);
		session.setAttribute("address", addrList);
		
		
		
		return "redirect:/";
	}
	
	
	@RequestMapping("login/logOut")
	public String logOut(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("test")
	@ResponseBody
	public boolean test(String json,HttpSession session) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper om = new ObjectMapper();
		
		List<Map<String,Object>> jsonMap = om.readValue(json, new TypeReference<List<Map<String,Object>>>() {});
		
		
		List<Map<String,Object>> orderList = (session.getAttribute("orderList")) != null ? 
				(List<Map<String,Object>>)session.getAttribute("orderList") : new ArrayList<Map<String,Object>>();
		
		for(int i = 0 ; i < jsonMap.size(); i++) {
			int index = listIndexOf(orderList, jsonMap.get(i));
			if(index == -1) {
				Map<String,Object> goodsMap = goods_Detail_Service.getOneGoods((int)jsonMap.get(i).get("mainNo"),(List<Integer>)jsonMap.get(i).get("menus"));
				jsonMap.get(i).put("menuNames", goods_Detail_Service.getMenuNames((List<Integer>)jsonMap.get(i).get("menus")));
				jsonMap.get(i).putAll(goodsMap);
				orderList.add(jsonMap.get(i));
			}else {
				int  total = (int)orderList.get(index).get("cnt")+(int)jsonMap.get(i).get("cnt");
				
				if(total > 10) {
					int totalM = total - 10;
					total = 10;
					jsonMap.get(i).put("cnt",totalM);
					i--;
				}
				
				orderList.get(index).put("cnt", total);
			}
		}
		
		
		session.setAttribute("orderList", orderList);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("order/delete")
	@ResponseBody
	public boolean orderDelete(int v,HttpSession session) {
		List<Map<String,Object>> order = (List<Map<String,Object>>)session.getAttribute("orderList");
		order.remove(v);
		if(order.isEmpty()) session.removeAttribute("orderList");
		return true;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping("order/updateForm")
	@ResponseBody
	public Map<String,Object> orderUpdateForm(int v,HttpSession session) {
		List<Map<String,Object>> order = (List<Map<String,Object>>)session.getAttribute("orderList");
		return order.get(v);
	}
	
	
	
	@SuppressWarnings("unchecked")
	public int listIndexOf(List<Map<String,Object>> list,Map<String,Object> target) {
		for(int i = 0; i < list.size(); i++) {
			boolean equals = (int)list.get(i).get("mainNo") == (int)target.get("mainNo") && ((List<Integer>)list.get(i).get("menus")).equals((List<Integer>)target.get("menus")) && (int)list.get(i).get("cnt") != 10; 
			if(equals) {
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
