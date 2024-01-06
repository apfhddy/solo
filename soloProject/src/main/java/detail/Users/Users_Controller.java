package detail.Users;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import common.ControllerPath;

@Controller
public class Users_Controller implements ControllerPath{
	private Users_Service users_Service;
	
	public Users_Controller(Users_Service users_Service) {
		this.users_Service = users_Service;
	}
	
	@RequestMapping("join/addr")
	public String joinInput1(HttpServletRequest req) {
		System.out.println(req.getAttribute("a"));
		return LOGIN+"joinInput.jsp";
	}
}
