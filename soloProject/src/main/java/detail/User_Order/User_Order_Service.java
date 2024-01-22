package detail.User_Order;

public class User_Order_Service {
	private User_Order_DAO user_Order_DAO;
	
	public User_Order_Service(User_Order_DAO user_Order_DAO) {
		this.user_Order_DAO = user_Order_DAO;
	}
	
	public int insertUserOrder(User_Order_DTO dto) {
		return user_Order_DAO.insertUserOrder(dto);
	}
}
