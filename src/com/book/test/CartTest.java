package com.book.test;

import java.util.List;
import java.util.Scanner;

import com.book.dao.BookDaoImpl;
import com.book.dao.CartDaoImpl;
import com.book.dao.LoginDaoImpl;
import com.book.pojo.Book;
import com.book.pojo.Cart;


public class CartTest {
	
	public static void main(String[] args) {

    Scanner sc=new Scanner(System.in);
    boolean exit=false;
    
    
      Integer cartId;
	  Integer bookId;
	  Integer quantity;
      Book b;
	  
      Cart c=null;
	  CartDaoImpl cimpl=new CartDaoImpl();
	  boolean f;
      
	  List<Cart> clist=null;
	  
	  
	  
    System.out.println("Please login...");
    
    System.out.println("Enter your email id:-");
    String email=sc.nextLine();
    
    System.out.println("Enter password:-");
	String password=sc.nextLine();
	
	boolean flag=new LoginDaoImpl().checkCustomer(email, password);
    
    if(flag) {
    	
    	System.out.println("Login successful...");
	     
	     do {
	    	 
	    	 System.out.println("Please enter one of the options given below...");
	    	 System.out.println("1-----> Add to cart");
	    	 System.out.println("2-----> Show my cart");
	    	 System.out.println("3-----> Update quantity");
	    	 System.out.println("4-----> Delete item from cart");
	    	 System.out.println("5-----> Clear my cart");
	    	 System.out.println("6-----> Get item  by cartId");
	    	 
	    	 
	    	 int option=sc.nextInt();
	    	 sc.nextLine();
	    	 
	    	 
	     switch(option) {
	     
	     case 1:
	    	 
	    	  List<Book> blist=new BookDaoImpl().showAllBooks();
	    	  
	    	  System.out.println("All the books available=>");
	    	  for(Book b1:blist) {
	    		  
	    		  System.out.println(b1);
	    		  System.out.println("_________________________________________________________");
	    	  }
	    	
	    	 System.out.println("Enter the Id of book you want to add to cart");
	         bookId=sc.nextInt();
	         sc.nextLine();
	         
	         System.out.println("Enter the no of books you want to buy");
	    	 quantity=sc.nextInt();
	    	 sc.nextLine();
	    	 
	    	 c=new Cart();
	    	 c.setBookId(bookId);
	    	 c.setEmail(email);
	    	 c.setQuantity(quantity);
	    	 
	    	 f=cimpl.addToCart(c);
	    	 
	    	 if(f)
	    		 System.out.println("Books added to cart successfully");
	    	 else
	    		 System.out.println("Error while adding books to cart");
	    	 
	    	 
	        break;
	     
	     
	     case 2:
	    	 
	    	 clist=cimpl.showMyCart(email);
	    	 
	     if(clist.isEmpty() || clist==null) {
	    	 
	    	 System.out.println("You have not added any books to the cart yet.please browse though our collection and add to cart");
	    	 System.out.println("___________________________________________________________________________________________________");	 
	     }
	     else {
	    	 
	    	 System.out.println("*****Your cart details*****");
	    	 
	    	 double total=0;
	    	 
	    	 for(Cart c1: clist) {
	    		 
	    		 System.out.println("Cart Id: "+c1.getCartId());
	    		 System.out.println("Book name: "+c1.getB().getBookName());
	    		 System.out.println("Book price: "+c1.getB().getPrice());
	    		 System.out.println("Quantity: "+c1.getQuantity());
	    	     
	    		 double net=c1.getB().getPrice()* c1.getQuantity();
	    		 System.out.println("Net price: "+ net);
	    	 
	    		 total+=net;
	    		 
	    		 System.out.println("");
	    		 
	    	 }
	    	  System.out.println("Total amount payable= "+total);
	    	  System.out.println("________________________________________________________");
	     }
	     
	      break;
	      
	      
	     case 3:
	    	 
	       System.out.println("Enter the cart id of the item for which you want to change quantity ");
	       cartId=sc.nextInt();
	       sc.nextLine();
	       
	       System.out.println("Enter the new quantity of books you want to purchase");
	       quantity=sc.nextInt();
	       sc.nextLine();
	       
	       f=cimpl.updateQuantity(quantity, cartId);
	       
	       if(f)
	    	   System.out.println("The quantity of book in your cart has been updated");
	     
	       else
	    	   System.out.println("Error while updating quantity");
	     
	       break;
	       
	       
	     case 4:
	    	 
	    	  System.out.println("Enter cartId of item which is to be deleted");   
	    	  cartId=sc.nextInt();
	    	  sc.nextLine();
	    	 
	    	  f=cimpl.deleteCartItem(cartId);
	    	  
	    	  if(f)
	    		  System.out.println("item deleted from cart successfully");
	    	      System.out.println("_________________________________________________");
	    	  break;
	    	  
	    	  
	     case 5:
	    	    
	    	   clist=cimpl.showMyCart(email);
	    	 
	    	   if(clist.isEmpty() || clist==null) {
	  	    	 
	  	    	 System.out.println("You have not added any books to the cart yet.please browse though our collection and add to cart");
	  	    	 System.out.println("_____________________________________________________________________________________________________");	 
	  	     }
	  	     else {
	  	    	 
	  	    	 System.out.println("*****Your cart details*****");
	  	    	 
	  	    	 double total=0;
	  	    	 
	  	    	 for(Cart c1: clist) {
	  	    		 
	  	    		 System.out.println("Cart Id: "+c1.getCartId());
	  	    		 System.out.println("Book name: "+c1.getB().getBookName());
	  	    		 System.out.println("Book price: "+c1.getB().getPrice());
	  	    		 System.out.println("Quantity: "+c1.getQuantity());
	  	    	     
	  	    		 double net=c1.getB().getPrice()* c1.getQuantity();
	  	    		 System.out.println("Net price: "+ net);
	  	    	 
	  	    		 total+=net;
	  	    		 
	  	    		 System.out.println("");
	  	    		 
	  	    	 }
	  	    	  System.out.println("Total amount payable= "+total);
	  	    	  System.out.println("________________________________________________________");
	  	     
	  	     
	  	       System.out.println("Do you want to clear your cart? Enter yes or no");
	  	       String choice=sc.nextLine().toLowerCase();
	  	       
	  	       if(choice.equals("yes")) {
	  	    	   
	  	    	       flag=cimpl.clearCart(email);
	  	    	   
	  	    	    if(flag) {
	  	    	    	System.out.println("Your cart is cleared seccessfully");
	  	    	        System.out.println();
	  	    	    }
	  	    	    else
	  	    	    	System.out.println("Error while clearing cart");
	  	    	    
	  	     }
	  	       
	  	       else if(choice.equals("no"))
	  	    	   System.out.println("Thank you...keep browsing!!");
	  	       
	  	       else
	  	    	   System.out.println("Please answer in yes or no only");
	  	     
	  	     }
	    	   
	        break;
	       
	       
	     case 6:
	    	     
	    	   System.out.println("Enter the cartId of item to be displayed");
	    	   cartId=sc.nextInt();
	    	   sc.nextLine();
	    	   
	    	   c=cimpl.showCartById(cartId);
	    	 
	    	 if(c==null)
	    		 System.out.println("Did not find any item with given cart Id.Please try again");
	    	   
	    	 else
	    	 {
	    		 
	    		System.out.println("\n*******Detailed view of Cart item*******"); 
	    		 
	    		b=c.getB(); 
	    	    System.out.println("Book name: "+b.getBookName());
	    		System.out.println("Author: "+b.getAuthor()); 
	    		System.out.println("Price: "+b.getPrice()); 
	    		System.out.println("Description: "+b.getDescription());
	    		
	    		double net=c.getB().getPrice()*c.getQuantity();
	    		System.out.println("Net price: "+net);
	    		System.out.println("_______________________________________________________");
	    		
	    	  }
	    	 
          break;	       
	       
	       }
	    	 
	     }
	     
	     while(exit==false) ;
	
        }
     
    else
    	System.out.println("Error while login.Please login again...");
    
    
	}

}
