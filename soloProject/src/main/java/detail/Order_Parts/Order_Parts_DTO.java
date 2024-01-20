package detail.Order_Parts;

public class Order_Parts_DTO {
	private int orderParts_no;
	private int orderTotal_no;
	private int goodsDetail_no;
	
	public Order_Parts_DTO() {}

	public Order_Parts_DTO(int orderParts_no, int orderTotal_no, int goodsDetail_no) {
		super();
		this.orderParts_no = orderParts_no;
		this.orderTotal_no = orderTotal_no;
		this.goodsDetail_no = goodsDetail_no;
	}

	public int getOrderParts_no() {
		return orderParts_no;
	}

	public void setOrderParts_no(int orderParts_no) {
		this.orderParts_no = orderParts_no;
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
