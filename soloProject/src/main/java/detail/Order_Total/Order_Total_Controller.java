package detail.Order_Total;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import common.ControllerPath;

@Controller
public class Order_Total_Controller implements ControllerPath{
	private Order_Total_Service order_Total_Service;
	
	public Order_Total_Controller(Order_Total_Service order_Total_Service) {
		this.order_Total_Service = order_Total_Service;
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
		
		for(Map<String,Object> oneMap : orderList) {
			System.out.println(oneMap.toString());
		}
		
		
		
		
		
		return "redirect:/";
	}
	
	
}
