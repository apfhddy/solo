package detail.Order_Total;

import java.util.Map;

public class Order_Total_Service {
	private Order_Total_DAO order_Total_DAO;
	
	public Order_Total_Service(Order_Total_DAO order_Total_DAO) {
		this.order_Total_DAO = order_Total_DAO;
	}
	
	public int getNextNo() {
		return order_Total_DAO.getNextNo();
	}
	
	public int insertOrderTotal(Order_Total_DTO dto) {
		return order_Total_DAO.insertOrderTotal(dto);
	}
	
	
	
	
}
