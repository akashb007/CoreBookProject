package com.book.test;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.book.dao.BookDaoImpl;
import com.book.pojo.Book;

public class BookTest {

	public static void main(String[] args) {
    
	Scanner sc=new Scanner(System.in);	
  	
	Book b=null;
	BookDaoImpl bimpl=new BookDaoImpl();
	
	List<Book> blist=null;
	
	boolean exit=false;
	boolean flag;
	
	 Integer bookId;
	 String bookName;
	 String author;
	 String category;
	 String description;
	 Double price;
	 Integer noOfBooks;
	
	
	do {
		
		System.out.println("Please choose the options given below...");
		
		System.out.println("1-----> Add book");
		System.out.println("2-----> Show all books");
		System.out.println("3-----> Update book");
		System.out.println("4-----> Delete book");
		System.out.println("5-----> Search book by author name");
		System.out.println("6-----> Search book by category");
		System.out.println("7-----> Search book by bookName");
		System.out.println("8-----> Show all authors");
		System.out.println("9-----> Shoe all categories");
		
		
		int option=sc.nextInt();
		sc.nextLine();
		
		switch(option) {
		
		case 1:
			
			System.out.println("Enter book name:-");
			bookName=sc.nextLine();
			
			System.out.println("Enter author name:-");
			author=sc.nextLine();
			
			System.out.println("Enter category of the book:-");
			category=sc.nextLine();
			
			System.out.println("Enter description of the book:-");
			description=sc.nextLine();
			
			System.out.println("Enter price of the book:-");
			price=sc.nextDouble();
			sc.nextLine();
			
			System.out.println("Enter number of books in stock:-");
			noOfBooks=sc.nextInt();
			sc.nextLine();
			
			
			b=new Book();
			
			b.setBookName(bookName);
			b.setAuthor(author);
			b.setCategory(category);
			b.setDescription(description);
			b.setNoOfBooks(noOfBooks);
			b.setPrice(price);
			
			flag=bimpl.addBook(b);
			
			if(flag)
				System.out.println("Book details added successfully");
			
			else
				System.out.println("Error while adding boook details");
			
			break;
		
			
		case 2:
			
			blist=bimpl.showAllBooks();
			
			if(blist!=null && blist.isEmpty()!=true) {
				
				for(Book b1: blist) {
					
					System.out.println(b1);
					System.out.println("________________________________________________________________");
				}
			}
			else
				System.out.println("Something wrong...Could not fetch book list!!");
			
			break;
			
			
		case 3:
			   System.out.println("Enter Id of book you want to update");
			   bookId=sc.nextInt();
			   sc.nextLine();
			   
			   b=bimpl.showBookById(bookId);
			  
			  if(b!=null) {
				  
				  System.out.println("Your book details...\n"+b);
				  System.out.println("\nAre you sure you want to update this book? Answer in yes or no");
			 
			       String choice=sc.next().toLowerCase();
			       sc.nextLine();
			  
			       if(choice.equals("yes")) {
			    	   
			    	   System.out.println("Enter book name:-");
						bookName=sc.nextLine();
						
						System.out.println("Enter author name:-");
						author=sc.nextLine();
						
						System.out.println("Enter category of the book:-");
						category=sc.nextLine();
						
						System.out.println("Enter description of the book:-");
						description=sc.nextLine();
						
						System.out.println("Enter price of the book:-");
						price=sc.nextDouble();
						sc.nextLine();
						
						System.out.println("Enter number of books in stock:-");
						noOfBooks=sc.nextInt();
						sc.nextLine();
						
						b=new Book(bookId, bookName, author, category, description, price, noOfBooks);
			    	   
			    	    flag=bimpl.updateBook(b);
			    	    
			    	    if(flag)
			    	    	System.out.println("Book updated successfully");
			    	    else
			    	    	System.out.println("Error while updating book...");
			    	
			       }
			       else if(choice.equals("no")) {
			    	   
			    	   System.out.println("No problem!!!");
			       }
			       else
			    	   System.out.println("Please give answer in yes or no only");
			  
			  }
			  else
				  System.out.println("No book found with this Id!!");
			break;
			
		case 4:
			
			System.out.println("Enter Id of book to be deleted");
			bookId=sc.nextInt();
			sc.nextLine();
			
			b=bimpl.showBookById(bookId);
			
			if(b!=null) {
				
				System.out.println("Your book details\n"+b);
				System.out.println("\nAre you sure you want to delete it?Answer in yes or no");
				
				 String choice=sc.next().toLowerCase();
			       sc.nextLine();
			  
			       if(choice.equals("yes")) {
			    	   
			    	   
			    	    flag=bimpl.deleteBook(bookId);
			    	    
			    	    if(flag)
			    	    	System.out.println("Book deleted successfully");
			    	    else
			    	    	System.out.println("Error while deleting book...");
			    	
			       }
			       else if(choice.equals("no")) {
			    	   
			    	   System.out.println("No problem!!!");
			       }
			       else
			    	   System.out.println("Please give answer in yes or no only");
			  
				
			}
			else
				System.out.println("No book found by this Id");
			
			
			break;
			
		case 5:
			
			System.out.println("Enter author name whose books you want to search");
			author=sc.nextLine();
			
			blist=bimpl.showBookByAuthor(author);
			
			if(blist!=null && blist.isEmpty()!=true) {
				
				for(Book b1: blist) {
					System.out.println(b1);
					System.out.println("_____________________________________________________");
				}
				
			}
			
			break;
			
			
		case 6:
			
			  System.out.println("Enter category whose books you want to search");
			  category=sc.next().toLowerCase();
			  sc.nextLine();
			  
			  blist=bimpl.showBookByCategory(category);
			
				if(blist!=null && blist.isEmpty()!=true) {
					
					for(Book b1: blist) {
						System.out.println(b1);
						System.out.println("_____________________________________________________");
					}	
				}
				  
			break;
			
		
		case 7:
            System.out.println("Enter name of book you want to search");			
			bookName=sc.nextLine();
			
			blist=bimpl.showBookByName(bookName);
			
			if(blist!=null && blist.isEmpty()!=true) {
				
			  for(Book b1:blist) {
				  
				  System.out.println(b1);
				  System.out.println("______________________________________________");		  
			  }
				
			}
			
			break;
			
		
		case 8:
			   Set<String> authors= bimpl.getAllAuthors();
			    
			  if(authors!=null && authors.isEmpty()!=true) {
				 
			  System.out.println("\nAll authors=");	  
				  for(String a: authors)
					  System.out.println(a);
				  
			  }
			   
			   System.out.println("_______________________________________");
			   
			break;
			
		
		
		case 9:
			
			 Set<String> categories=bimpl.getAllCategories();
			
		    if(categories!=null && categories.isEmpty()!=true) {
 		    	
		    	
		    System.out.println("\nAll categories=");	
		    	
               for(String c: categories)
            	   System.out.println(c);
               
		    }
			 
			 System.out.println("_________________________________________");
			
		    break;	 
			 
			 
		}
		
		
	}
	  while(exit==false);
		
		
	}

 }
