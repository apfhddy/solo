package detail.Users;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.cglib.proxy.Dispatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import common.ControllerPath;
import common.Encry;
import common.MailSendService;
import detail.Certified_Type.Certified_Type_DTO;
import detail.Certified_Type.Certified_Type_Service;
import detail.Terms.Terms_DTO;
import detail.Terms.Terms_Service;
import detail.User_Address.User_Address_DTO;
import detail.User_Address.User_Address_Service;
import detail.User_Order.User_Order_Service;
import detail.User_Terms.User_Terms_DAO;
import detail.User_Terms.User_Terms_Service;
import detail.User_Terms.User_Terms_DTO;

@Controller
public class Users_Controller implements ControllerPath{
	private Users_Service users_Service;
	private User_Address_Service user_Address_Service;
	private Certified_Type_Service certified_Type_Service;
	private Terms_Service terms_Service;
	private User_Terms_Service user_Terms_Service;
	private User_Order_Service user_Order_Service;
	
	private MailSendService mailSendService;
	
	private Map<String,Object> certifiedsMap = new HashMap<String, Object>(); 
	
	public Users_Controller(Users_Service users_Service,User_Address_Service user_Address_Service,
			Certified_Type_Service certified_Type_Service,MailSendService mailSendService,Terms_Service terms_Service,
			User_Terms_Service user_Terms_Service,User_Order_Service user_Order_Service) {
		this.users_Service = users_Service;
		this.user_Address_Service = user_Address_Service;
		this.certified_Type_Service = certified_Type_Service;
		this.terms_Service = terms_Service;
		this.user_Terms_Service = user_Terms_Service;
		this.user_Order_Service = user_Order_Service;
		
		this.mailSendService = mailSendService;
	}
	
	
	@RequestMapping("/join/addr")
	public String joinInput1(HttpSession session) {
		return LOGIN+"joinAddrInput.jsp";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("join/detail")
	public String joinInput2(HttpServletRequest req,User_Address_DTO dto){
		if(dto.getLocation() == null)return "에러페이지";
		if(dto.getDetail().isEmpty())return "에러페이지";

		req.getSession().setAttribute("join", new HashMap<String, Object>());
		((Map<String,Object>)req.getSession().getAttribute("join")).put("addr", dto);
		
		List<Certified_Type_DTO> certifiedList = certified_Type_Service.getTypeList();
		
		List<Terms_DTO> termsList = terms_Service.getTermsList();
		
		req.setAttribute("certifiedList", certifiedList);
		req.setAttribute("termsList", termsList);
		
		return LOGIN+"joinDetailInput.jsp";
	}
	

	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("join/certified")
	public String test(HttpServletRequest req,Users_DTO dto) {
		String pwCk = req.getParameter("pwCk");
		String emailCk = req.getParameter("emailCk");
		
		if(!dto.getEmail().equals(emailCk))return  "에러페이지";
		if(dto.getPhone().length() != 11)return "에러페이지";
		try {Integer.parseInt(dto.getPhone());}catch (NumberFormatException e) {return "에러페이지";}
		if(!users_Service.checkEmailOrPhone(0,dto.getEmail()) || !users_Service.checkEmailOrPhone(1,dto.getPhone()))return "에러페이지";
		if(!dto.getPw().equals(pwCk))return  "에러페이지";
		
		User_Terms_DTO[] userTerms = new User_Terms_DTO[terms_Service.getTermsSu()];
		for(int i = 0; i < userTerms.length; i++) {
			userTerms[i] = new User_Terms_DTO();
			userTerms[i].setTerms_no(i+1);
			userTerms[i].setChecked(req.getParameter("terms"+(i+1)) == null ? 0 : 1);
		}
		
		
		((Map<String,Object>)req.getSession().getAttribute("join")).put("userTerms", userTerms);
		((Map<String,Object>)req.getSession().getAttribute("join")).put("detail", dto);
		Map<String,Object> putMap = ((Map<String,Object>)req.getSession().getAttribute("join")); 
		Thread thead = new Thread() {
			@Override
			public void run() {
				String key = String.valueOf(UUID.randomUUID());
				mailSendService.joinEmail(key,dto.getEmail(),dto.getName());
				certifiedsMap.put(key,putMap);
			}
		};
		
		thead.start();
		
		
		return LOGIN+"certified.jsp";
	}
	
	@RequestMapping("join/insert")
	@SuppressWarnings("unchecked")
	public String insert(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String key = req.getParameter("code");
		Map<String,Object> certifiedMap = (Map<String,Object>)certifiedsMap.get(key);
		if(certifiedMap == null)return "에러페이지";
		
		if(users_Service.insertUser(certifiedMap) == 1) {
			certifiedsMap.remove(key);
		}
		
		
		return "redirect:/";
	}
	
	
	@RequestMapping("myPage")
	public String myPage(HttpServletRequest req) {
		return "redirect:myPage/userOrder";
	}
	@RequestMapping("myPage/addr")
	public String address(HttpServletRequest req) {
		return MYPAGE+"address.jsp";
	}
	
	
	@RequestMapping("myPage/userData")
	public String userData(HttpServletRequest req) {
		int user_no = ((Users_DTO)req.getSession().getAttribute("login")).getUser_no();
		
		List<Certified_Type_DTO> certifiedList = certified_Type_Service.getTypeList();
		List<Map<String,Object>> userTermsList = user_Terms_Service.getUserTermsList(user_no);
		req.setAttribute("certifiedList",certifiedList);
		req.setAttribute("userTermsList",userTermsList);
		return MYPAGE+"userData.jsp";
	}
	
	@RequestMapping("myPage/userData/update")
	public String userUpdate(HttpServletRequest req,String name,int gender,String phone) {
		Users_DTO user_DTO = (Users_DTO)req.getSession().getAttribute("login");
		user_DTO.setName(name);
		user_DTO.setGender(gender);
		user_DTO.setPhone(phone);
		
		User_Terms_DTO[] userTerms = new User_Terms_DTO[terms_Service.getTermsSu()];
		for(int i = 0; i < userTerms.length; i++) {
			userTerms[i] = new User_Terms_DTO();
			userTerms[i].setUser_no(user_DTO.getUser_no());
			userTerms[i].setTerms_no(i+1);
			userTerms[i].setChecked(req.getParameter("terms"+(i+1)) == null ? 0 : 1);
			user_Terms_Service.userTermsUpdate(userTerms[i]);
		}
		
		users_Service.userUpdate(user_DTO);
		return "redirect:/";
	}
	
	@RequestMapping("myPage/password")
	public String myPassword() {
		return MYPAGE+"passwordUpdate.jsp";
	}
	
	@RequestMapping("myPage/password/Update")
	public String passwordUpdate(HttpSession session,String nowPw,String newPw,String newPwCk) {
		
		
		Users_DTO users_DTO = (Users_DTO)session.getAttribute("login");
		if(!newPw.equals(newPwCk))return "에러페이지";
		
		nowPw = Encry.encry(nowPw, users_DTO.getSalt());
		if(!users_DTO.getPw().equals(nowPw))return "에러페이지";
		
		String salt = Encry.getSalt();
		newPw = Encry.encry(newPw, salt);
		
		users_DTO.setSalt(salt);
		users_DTO.setPw(newPw);
		
		users_Service.userUpdate(users_DTO);
		
		
		return "redirect:/";
	}
	
	@RequestMapping("myPage/userOrder")
	public String userOrder(HttpServletRequest req) {
		int user_no = ((Users_DTO)req.getSession().getAttribute("login")).getUser_no();
		List<Map<String,Object>> resultrList = user_Order_Service.getUserOrderList(user_no);
		
		req.setAttribute("orderList", resultrList);
		return MYPAGE+"userOrder.jsp";
	}
	
	
	@RequestMapping("findPassword")
	public String findPassword() {
		return LOGIN+"findPassword.jsp";
	}
}
