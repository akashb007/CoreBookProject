package com.book.pojo;

public class Order {

  	private Integer orderId;
  	private String email;
  	private String orderDate;
  	private String status;
  	private Double bill;
	private String dropLocation;
  	
  	
	
	
  	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Order(Integer orderId, String email, String orderDate, String status, Double bill) {
		super();
		this.orderId = orderId;
		this.email = email;
		this.orderDate = orderDate;
		this.status = status;
		this.bill = bill;
	}


  

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", email=" + email + ", orderDate=" + orderDate + ", status=" + status
				+ ", bill=" + bill + ", dropLocation=" + dropLocation + "]";
	}



	public Integer getOrderId() {
		return orderId;
	}



	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getOrderDate() {
		return orderDate;
	}



	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Double getBill() {
		return bill;
	}



	public void setBill(Double bill) {
		this.bill = bill;
	}



	public String getDropLocation() {
		return dropLocation;
	}



	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}
  	
  	
	
	
 }
