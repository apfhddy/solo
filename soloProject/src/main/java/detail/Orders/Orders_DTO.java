package detail.Orders;

public class Orders_DTO {
	private int orders_no;
	private int orderTotal_no;
	private int goodsDetail_no;
	
	public Orders_DTO() {}

	public Orders_DTO(int orders_no, int orderTotal_no, int goodsDetail_no) {
		super();
		this.orders_no = orders_no;
		this.orderTotal_no = orderTotal_no;
		this.goodsDetail_no = goodsDetail_no;
	}

	public int getOrders_no() {
		return orders_no;
	}

	public void setOrders_no(int orders_no) {
		this.orders_no = orders_no;
	}

	public int getOrderTotal_no() {
		return orderTotal_no;
	}

	public void setOrderTotal_no(int orderTotal_no) {
		this.orderTotal_no = orderTotal_no;
	}

	public int getGoodsDetail_no() {
		return goodsDetail_no;
	}

	public void setGoodsDetail_no(int goodsDetail_no) {
		this.goodsDetail_no = goodsDetail_no;
	}
	
	
}
