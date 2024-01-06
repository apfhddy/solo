package detail.User_Address;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class User_Address_Controller{

	@RequestMapping("searchAddr")
	public void searchAddr() {
		System.out.println("dd");
	}
}
