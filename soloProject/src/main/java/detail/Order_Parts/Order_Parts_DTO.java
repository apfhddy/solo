package detail.Order_Parts;

public class Order_Parts_DTO {
	private int orderParts_no;
	private int orders_no;
	private int goodsDetail_no;
	
	public Order_Parts_DTO() {}

	public Order_Parts_DTO(int orderParts_no, int orders_no, int goodsDetail_no) {
		super();
		this.orderParts_no = orderParts_no;
		this.orders_no = orders_no;
		this.goodsDetail_no = goodsDetail_no;
	}

	public int getOrderParts_no() {
		return orderParts_no;
	}

	public void setOrderParts_no(int orderParts_no) {
		this.orderParts_no = orderParts_no;
	}

	public int getOrders_no() {
		return orders_no;
	}

	public void setOrders_no(int orders_no) {
		this.orders_no = orders_no;
	}

	public int getGoodsDetail_no() {
		return goodsDetail_no;
	}

	public void setGoodsDetail_no(int goodsDetail_no) {
		this.goodsDetail_no = goodsDetail_no;
	}

	
}
