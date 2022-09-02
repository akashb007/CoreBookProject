package com.book.dao;

import java.util.List;

import com.book.pojo.Cart;

public interface CartDAO {

	public boolean addToCart(Cart c);
	public boolean deleteCartItem(Integer cartId);
	public boolean updateQuantity(Integer quantity, Integer cartId);      
	public boolean clearCart(String email);
	
	public List<Cart> showMyCart(String email);  // it will show all items put by a particular customer
	
	public Cart showCartById(Integer cartId);   // it will show only one item in the cart with given cartId
	
  }
