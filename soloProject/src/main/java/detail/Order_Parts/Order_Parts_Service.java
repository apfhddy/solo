package detail.Order_Parts;

import java.util.List;
import java.util.Map;

public class Order_Parts_Service {
	private Order_Parts_DAO order_Parts_DAO;
	
	public Order_Parts_Service(Order_Parts_DAO order_Parts_DAO) {
		this.order_Parts_DAO = order_Parts_DAO;
	}
	
	public List<Map<String,Object>> getOrderParts(int orders_no){
		return order_Parts_DAO.getOrderParts(orders_no);
	}
	
}	
