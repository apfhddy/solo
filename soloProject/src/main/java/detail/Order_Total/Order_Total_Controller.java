package detail.Order_Total;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import common.ControllerPath;
import detail.Orders.Orders_Service;
import detail.User_Order.User_Order_DTO;
import detail.User_Order.User_Order_Service;
import detail.Users.Users_DTO;

@Controller
public class Order_Total_Controller implements ControllerPath{
	private Order_Total_Service order_Total_Service;
	private Orders_Service orders_Service;
	private User_Order_Service user_Order_Service;
	
	public Order_Total_Controller(Order_Total_Service order_Total_Service,Orders_Service orders_Service,
			User_Order_Service user_Order_Service) {
		this.order_Total_Service = order_Total_Service;
		this.orders_Service = orders_Service;
		this.user_Order_Service = user_Order_Service;
	}
	
	
	@RequestMapping("order/check")
	public String orderCheck() {
		return ORDER+"orderCheck.jsp";
	}

	@RequestMapping("order/payment")
	public String orderPayment() {
		return ORDER+"orderPayment.jsp";
	}
	
	@RequestMapping("order/pay")
	public String orderPay(HttpSession session) {
		
		List<Map<String,Object>> orderList = (List<Map<String,Object>>)session.getAttribute("orderList");
		
		int orderTotal_no = order_Total_Service.getNextNo();
		
		boolean next = (order_Total_Service.insertOrderTotal(new Order_Total_DTO(orderTotal_no,null, 0))) == 1;
		
		if(next)
			for(Map<String,Object> oneMap : orderList) {
				orders_Service.insertOrders(oneMap,orderTotal_no);
			}
		
		
		if(session.getAttribute("login") != null) {
			int user_no = ((Users_DTO)session.getAttribute("login")).getUser_no();
			user_Order_Service.insertUserOrder(new User_Order_DTO(0, orderTotal_no, user_no));
		}
		
		
		session.removeAttribute("orderList");
		
		
		
		
		return "redirect:/";
	}
	
	
}
