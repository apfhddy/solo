package detail.Menu_Type;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import common.ControllerPath;
import detail.Category_Type.Category_Type_DTO;
import detail.Category_Type.Category_Type_Service;
import detail.Goods.Goods_Service;

@Controller
public class Menu_Type_Controller implements ControllerPath{
	private Menu_Type_Service menu_Type_Service;
	private Category_Type_Service category_Type_Service;
	private Goods_Service goods_Service;
	
	public Menu_Type_Controller(Menu_Type_Service menu_Type_Service,Category_Type_Service category_Type_Service,Goods_Service goods_Service) {
		this.menu_Type_Service = menu_Type_Service;
		this.category_Type_Service = category_Type_Service;
		this.goods_Service = goods_Service;
	}
	
	@RequestMapping("menu")
	public String menu(HttpServletRequest req) {
		String menuTypeStr = req.getParameter("menuType_no");
		String cate_id = req.getParameter("cate_id");
		if(menuTypeStr == null) {
			return "redirect:/menu?menuType_no=1&cate_id=1";
		};
		int menuType_no = menuTypeStr == null ? 1 : Integer.parseInt(menuTypeStr);
		int category_no = cate_id == null ? 1 : Integer.parseInt(cate_id);
		
		

		
		List<Menu_Type_DTO> menuTypeList = menu_Type_Service.getChoiceSortList(menuType_no);
		
		List<Category_Type_DTO> categoryList = category_Type_Service.getCategoryList(menuType_no); 
		
		
		List<Map<String,Object>> goodsList = category_no == 1 ? goods_Service.getOrderDescList(menuType_no) : goods_Service.getGoodsList(menuType_no,category_no);
		
		
		req.setAttribute("menuTypeList", menuTypeList);
		req.setAttribute("categoryList", categoryList);
		req.setAttribute("goodsList", goodsList);
		req.setAttribute("choice", category_no);
		
		
		return MENU+"menu.jsp";
	}

	
}
