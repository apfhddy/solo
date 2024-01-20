package detail.Order_Total;

import java.sql.Date;

public class Order_Total_DTO {
	private int orderTotal_no;
	private Date orderDate;
	private int paymentType_no;

	
	public Order_Total_DTO() {}


	public Order_Total_DTO(int orderTotal_no, Date orderDate, int paymentType_no) {
		super();
		this.orderTotal_no = orderTotal_no;
		this.orderDate = orderDate;
		this.paymentType_no = paymentType_no;
	}


	public int getOrderTotal_no() {
		return orderTotal_no;
	}


	public void setOrderTotal_no(int orderTotal_no) {
		this.orderTotal_no = orderTotal_no;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public int getPaymentType_no() {
		return paymentType_no;
	}


	public void setPaymentType_no(int paymentType_no) {
		this.paymentType_no = paymentType_no;
	}

	
	
}
