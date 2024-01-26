package detail.User_Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import detail.Order_Parts.Order_Parts_Service;
import detail.Order_Total.Order_Total_Service;
import detail.Parts_ChangeList.Parts_ChangeList_Service;

@Controller
public class User_Order_Controller {
	private User_Order_Service user_Order_Service;
	private Order_Total_Service order_Total_Service;
	private Order_Parts_Service order_Parts_Service;
	private Parts_ChangeList_Service parts_ChangeList_Service;
	
	public User_Order_Controller(User_Order_Service user_Order_Service,Order_Total_Service order_Total_Service,
			Order_Parts_Service order_Parts_Service,Parts_ChangeList_Service parts_ChangeList_Service) {
		this.user_Order_Service = user_Order_Service;
		this.order_Total_Service = order_Total_Service;
		this.order_Parts_Service = order_Parts_Service;
		this.parts_ChangeList_Service = parts_ChangeList_Service;
	}
	
	@RequestMapping("orderList/repurchase")
	public String Repurchase(int order_id,HttpSession session) {
		List<Map<String,Object>> orders = order_Total_Service.getOders(order_id);
		for(Map<String,Object> oneMap : orders) {
			int orders_no = Integer.parseInt(String.valueOf(oneMap.get("ORDERS_NO")));
			List<Map<String,Object>> parts = order_Parts_Service.getOrderParts(orders_no);
			List<Integer> menus = new ArrayList<Integer>();
			List<String> menuNames = new ArrayList<String>();
			
			for(Map<String,Object> oneParts : parts) {
				menus.add(Integer.parseInt(String.valueOf(oneParts.get("GOODSDETAIL_NO"))));
				menuNames.add((String)oneParts.get("NAME"));
			}
			int main_no = Integer.parseInt(String.valueOf(oneMap.get("MAINNO")));
			oneMap.put("MAINNO", main_no);
			oneMap.put("CNT", Integer.parseInt(String.valueOf(oneMap.get("CNT"))));
			oneMap.put("PRICE", parts_ChangeList_Service.partsSumPrice(main_no, menus));
			oneMap.put("menus", menus);
			oneMap.put("menuNames", menuNames);
		}
		
		session.setAttribute("orderList", orders);
		return "redirect:/menu";
	}
	
	
	
}
