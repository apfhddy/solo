package detail.Order_Total;

import java.sql.Date;

public class Order_Total_DTO {
	private int orderTotal_no;
	private int goodsDetail_no;
	private int paymentType_no;
	private Date orderDate;

	
	public Order_Total_DTO() {}


	public Order_Total_DTO(int orderTotal_no, int goodsDetail_no, int paymentType_no, Date orderDate) {
		super();
		this.orderTotal_no = orderTotal_no;
		this.goodsDetail_no = goodsDetail_no;
		this.paymentType_no = paymentType_no;
		this.orderDate = orderDate;
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


	public int getPaymentType_no() {
		return paymentType_no;
	}


	public void setPaymentType_no(int paymentType_no) {
		this.paymentType_no = paymentType_no;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	
	
}
