package detail.User_Order;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class User_Order_Controller {
	private User_Order_Service user_Order_Service;
	
	public User_Order_Controller(User_Order_Service user_Order_Service) {
		this.user_Order_Service = user_Order_Service;
	}
	
	
	
	
	
}
