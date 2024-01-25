package detail.User_Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.search.IntegerComparisonTerm;

import detail.Order_Parts.Order_Parts_DAO;
import detail.Order_Total.Order_Total_DAO;
import detail.Orders.Orders_DAO;

public class User_Order_Service {
	private User_Order_DAO user_Order_DAO;
	private Order_Total_DAO order_Total_DAO;
	private Orders_DAO orders_DAO;
	private Order_Parts_DAO order_Parts_DAO;
	
	public User_Order_Service(User_Order_DAO user_Order_DAO,Order_Total_DAO order_Total_DAO,
			Orders_DAO orders_DAO,Order_Parts_DAO order_Parts_DAO) {
		this.user_Order_DAO = user_Order_DAO;
		this.order_Total_DAO = order_Total_DAO;
		this.orders_DAO = orders_DAO;
		this.order_Parts_DAO = order_Parts_DAO;
	}
	
	public int insertUserOrder(User_Order_DTO dto) {
		return user_Order_DAO.insertUserOrder(dto);
	}
	
	public List<Map<String,Object>> getUserOrderList(int user_no){
		List<Map<String,Object>> userOrderList = user_Order_DAO.getUserOrderList(user_no);
		
		for(Map<String,Object> map : userOrderList) {
			int orderTotal_no = Integer.parseInt(String.valueOf(map.get("ORDERTOTAL_NO")));
			List<Map<String,Object>> ordersMap = orders_DAO.getOrders(orderTotal_no);
			for(Map<String,Object> ordersOneMap : ordersMap) {
				int orders_no = Integer.parseInt(String.valueOf(ordersOneMap.get("ORDERS_NO")));
				List<String> orderPartsName = order_Parts_DAO.getOrderPartsName(orders_no);
				ordersOneMap.put("menuNames", orderPartsName);
			}
			map.put("orders", ordersMap);
		}

			
		
		
		
		return userOrderList;
	}
}
