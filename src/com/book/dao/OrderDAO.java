package com.book.dao;

import java.util.List;

import com.book.pojo.Order;

public interface OrderDAO {
	
	public Order placeOrder(Order o);
	public boolean cancelOrder(Integer orderId);
	public boolean updateStatus(Integer orderId, String status);
	
	public List<Order> showMyOrderHistory(String email);
	public List<Order> showAllOrders();
	

}
