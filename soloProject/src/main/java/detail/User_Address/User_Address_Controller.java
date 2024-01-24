package detail.User_Address;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import common.ControllerPath;
import detail.Users.Users_DTO;

@Controller
public class User_Address_Controller implements ControllerPath{
	private User_Address_Service user_Address_Service;
	
	public User_Address_Controller(User_Address_Service user_Address_Service) {
		this.user_Address_Service = user_Address_Service;
	}
	
	@RequestMapping("myPage/addr/form")
	public String myPageAddress(HttpServletRequest req) {
		return MYPAGE+"addrInput.jsp";
	}

	@RequestMapping("myPage/addr/form/update")
	public String addrUpdate(HttpSession session,User_Address_DTO dto,int addressType) {
		
		List<User_Address_DTO> addrList = ((List<User_Address_DTO>)session.getAttribute("address"));
		
		if(addrList.size() < addressType)return "에러페이지";
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("significant", dto.getSignificant());
		map.put("detail", dto.getDetail());
		map.put("location", dto.getLocation());
		map.put("user_no", ((Users_DTO)session.getAttribute("login")).getUser_no());
		map.put("num", addressType);
		user_Address_Service.rownumUpdate(map);
		
		dto.setUserAddr_no(addrList.get(addressType-1).getUserAddr_no());
		dto.setUser_no(addrList.get(addressType-1).getUser_no());
		
		addrList.set(addressType-1, dto);
		return "redirect:/myPage/addr";
	}
	
	@RequestMapping("myPage/addr/delete")
	public String addrDelete(HttpSession session,int addressType) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("user_no", ((Users_DTO)session.getAttribute("login")).getUser_no());
		map.put("num", addressType);
		user_Address_Service.addrDelete(map);
		
		((List<User_Address_DTO>)session.getAttribute("address")).remove(addressType-1);
		
		return "redirect:/myPage/addr";
	}
	
	@RequestMapping("myPage/addr/form/add")
	public String addrinsert(HttpSession session,User_Address_DTO dto) {
		int userAddr_no = user_Address_Service.getNextNo();
		dto.setUserAddr_no(userAddr_no);
		dto.setUser_no(((Users_DTO)session.getAttribute("login")).getUser_no());
		user_Address_Service.addrInsert(dto);
		
		((List<User_Address_DTO>)session.getAttribute("address")).add(dto);
		return "redirect:/myPage/addr";
	}
	
	
}
