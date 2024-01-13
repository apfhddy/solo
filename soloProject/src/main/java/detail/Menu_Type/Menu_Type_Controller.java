package detail.Menu_Type;

import org.springframework.stereotype.Controller;

import common.ControllerPath;

@Controller
public class Menu_Type_Controller implements ControllerPath{
	private Menu_Type_Service menu_Type_Service;
	
	public Menu_Type_Controller(Menu_Type_Service menu_Type_Service) {
		this.menu_Type_Service = menu_Type_Service;
	}
	
	

	
}
