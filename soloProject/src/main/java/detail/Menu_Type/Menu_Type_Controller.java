package detail.Menu_Type;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import common.ControllerPath;
import detail.Category.Category_DTO;
import detail.Category.Category_Service;

@Controller
public class Menu_Type_Controller implements ControllerPath{
	private Menu_Type_Service menu_Type_Service;
	private Category_Service category_Service;
	
	public Menu_Type_Controller(Menu_Type_Service menu_Type_Service,Category_Service category_Service) {
		this.menu_Type_Service = menu_Type_Service;
	}
	
	@RequestMapping("menu")
	public String menu(HttpServletRequest req) {
		int menuType_no = 2;
		int cate_id = 2;

		
		List<Menu_Type_DTO> menuTypeList = menu_Type_Service.getChoiceSortList(menuType_no);
		
		List<Category_DTO> categoryList = category_Service.getCategoryList(menuType_no); 
		
		req.setAttribute("menuTypeList", menuTypeList);
		return MENU+"menu.jsp";
	}

	
}
