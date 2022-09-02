package com.book.pojo;

public class Cart {
	
	 private Integer cartId;
	 private Integer bookId;
	 private String email;
     private Integer quantity;
     private Book b;
	
     
     
     public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Cart(Integer cartId, Integer bookId, String email, Integer quantity, Book b) {
		super();
		this.cartId = cartId;
		this.bookId = bookId;
		this.email = email;
		this.quantity = quantity;
		this.b = b;
	}



	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", bookId=" + bookId + ", email=" + email + ", quantity=" + quantity + ", b="
				+ b + "]";
	}



	public Integer getCartId() {
		return cartId;
	}



	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}



	public Integer getBookId() {
		return bookId;
	}



	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Integer getQuantity() {
		return quantity;
	}



	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}



	public Book getB() {
		return b;
	}



	public void setB(Book b) {
		this.b = b;
	}
    
     
     
     
    
}
