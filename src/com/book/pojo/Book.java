package com.book.pojo;

public class Book {
	
	private Integer bookId;
	private String bookName;
	private String author;
	private String category;
	private String description;
	private Double price;
	private Integer noOfBooks;
	
	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public Book(Integer bookId, String bookName, String author, String category, String description, Double price,
			Integer noOfBooks) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.category = category;
		this.description = description;
		this.price = price;
		this.noOfBooks = noOfBooks;
	}


	
	@Override
	public String toString() {
		return "\nBookId=" + bookId + "\nName=" + bookName + "\nAuthor=" + author + "\nCategory=" + category
				+ "\nDescription=" + description + "\nPrice=" + price + "\nNo.Of Books=" + noOfBooks;
	}


	
	public Integer getBookId() {
		return bookId;
	}


	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Integer getNoOfBooks() {
		return noOfBooks;
	}


	public void setNoOfBooks(Integer noOfBooks) {
		this.noOfBooks = noOfBooks;
	}
	
	
	

}
