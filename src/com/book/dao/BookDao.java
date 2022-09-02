package com.book.dao;

import java.util.List;
import java.util.Set;

import com.book.pojo.Book;

public interface BookDao {
	
	public boolean addBook(Book b);
	public boolean updateBook(Book b);
	public boolean deleteBook(Integer bookId);
	
    
	public List<Book> showAllBooks();
	public List<Book> showBookByAuthor(String author);
	public List<Book> showBookByCategory(String category);
	public List<Book> showBookByName(String bookName);
	
	public Book showBookById(Integer bookId);
	
	public Set<String> getAllCategories();
	public Set<String> getAllAuthors();
	
	
	
  }
