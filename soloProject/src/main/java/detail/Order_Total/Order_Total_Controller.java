package detail.Order_Total;

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
	
	
}
