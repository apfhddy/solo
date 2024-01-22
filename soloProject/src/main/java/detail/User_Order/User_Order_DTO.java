package detail.User_Order;

public class User_Order_DTO {
	private int userOrder_no;
	private int orderTotal_no;
	private int user_no;
	
	public User_Order_DTO() {}

	public User_Order_DTO(int userOrder_no, int orderTotal_no, int user_no) {
		super();
		this.userOrder_no = userOrder_no;
		this.orderTotal_no = orderTotal_no;
		this.user_no = user_no;
	}

	public int getUserOrder_no() {
		return userOrder_no;
	}

	public void setUserOrder_no(int userOrder_no) {
		this.userOrder_no = userOrder_no;
	}

	public int getOrderTotal_no() {
		return orderTotal_no;
	}

	public void setOrderTotal_no(int orderTotal_no) {
		this.orderTotal_no = orderTotal_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	
	
}
