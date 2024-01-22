package detail.Orders;

import java.util.List;
import java.util.Map;

import detail.Order_Parts.Order_Parts_DAO;

public class Orders_Service {
	private Orders_DAO orders_DAO;
	private Order_Parts_DAO order_Parts_DAO;
	
	public Orders_Service(Orders_DAO orders_DAO,Order_Parts_DAO order_Parts_DAO) {
		this.orders_DAO = orders_DAO;
		this.order_Parts_DAO = order_Parts_DAO;
	}
	
	public int insertOrders(Map<String,Object> oneMap,int orderTotal_no) {
		Orders_DTO dto = new Orders_DTO();
		int orders_no = orders_DAO.getNextNo();

		dto.setOrders_no(orders_no);
		dto.setOrderTotal_no(orderTotal_no);
		dto.setGoodsDetail_no((int)oneMap.get("mainNo"));
		dto.setCnt((int)oneMap.get("cnt"));
		
		boolean next = (orders_DAO.insertOrders(dto)) == 1;
		if(next)
			order_Parts_DAO.insertOrderParts((List<Integer>)oneMap.get("menus"),orders_no);
		
		return 0;
	}
}
