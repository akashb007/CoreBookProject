package com.book.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.book.dao.CartDaoImpl;
import com.book.dao.LoginDaoImpl;
import com.book.dao.OrderDaoImpl;
import com.book.pojo.Cart;
import com.book.pojo.Order;

public class OrderTest {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		boolean exit=false;
		int option;
		
		 Integer orderId;
	     String orderDate;
	  	 String status;
	  	 Double bill;
		 String dropLocation;
	  	
	  	 Order o=null;
	  	 OrderDaoImpl oimpl=new OrderDaoImpl();
	  	 List<Order> olist=null;
		
		  
	    System.out.println("Please login...");
	    
	    System.out.println("Enter your email id:-");
	    String email=sc.nextLine();
	    
	    System.out.println("Enter password:-");
		String password=sc.nextLine();
		
		boolean flag=new LoginDaoImpl().checkCustomer(email, password);
	    
		if(flag) {
			
			System.out.println("Login successful.You can now place order...");
		
		 List<Cart> clist=new CartDaoImpl().showMyCart(email);
		 
		
		 if(clist==null || clist.isEmpty()==true) {
			 
			 System.out.println("Your cart is empty.Please add books to your cart first.");
			 
		     do {
		    	   
		   
		    	   System.out.println("2-----> Show my order history");
		    	   System.out.println("3-----> Cancel my order");
		    	   
		    	   
		    	   
		    	   option=sc.nextInt();
		    	   sc.nextLine();
		    	   
		    	 switch(option) {
		    	 
		    	
		    		 
		    	 case 2: 
		    		      
		    		    olist=oimpl.showMyOrderHistory(email);
		    		    
		    		    if(olist!=null && olist.isEmpty()!=true) {
		    		    	
		    		        Iterator<Order> it=olist.iterator();
		    		        
		    		        while(it.hasNext()) {
		    		        	
		    		        	o=it.next();
		    		        	
		    		        	System.out.println("Order Id: "+o.getOrderId());
		    		        	System.out.println("Amount paid: "+o.getBill());
		    		        	System.out.println("Ordered on date: "+o.getOrderDate());
		    		        	System.out.println("Delivery location: "+o.getDropLocation());
		    		        	System.out.println("Status: "+o.getStatus());
		    		        	
		    		        	System.out.println("___________________________________________________________");
		    		        }
		    		    	
		    		    }
		    		    
		    		    else
		    		    System.out.println("You have not purchased any books yet.");	
		    		    	
		    		    	
		    		   break;
		    		   
		    		   
		    	 case 3:  
		    		    System.out.println("Enter the order Id that needs to be cancelled");
		    		    orderId=sc.nextInt();
		    		    sc.nextLine();
		    		    
		    		    flag=oimpl.cancelOrder(orderId);
		    		    
		    		   if(flag)
		    			   System.out.println("Your order has been cancelled....");
		    		   
		    		   else 
		    			   System.out.println("Error while cancelliing order");
		    		   
		    		   break;
		    		   
		    	
		    	 }
		    	   
		       } 
		       while(exit==false);
			 
				 
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
			 
	          
	    	  
	    	  System.out.println("1-----> Place order for the items in cart");
	    	  option=sc.nextInt();
	    	  sc.nextLine();
	    	  
	    	  
	   if(option==1) {
	    		  

	    		   System.out.println("Confirm your address for delivering order");
	    		   dropLocation=sc.nextLine();
	    		   
	    		/*
	    		 *    Date today=new Date();
	    		 *    orderDate=today.toString();
	    		 */
	    		   
	    		   DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss");
	    		   orderDate=LocalDateTime.now().format(format);
	    		   
	    		   status="Processing";
	    		   
	    		   o=new Order();
	    		   
	    		   o.setBill(total);
	    		   o.setEmail(email);
	    		   o.setDropLocation(dropLocation);
	    		   o.setOrderDate(orderDate);
	    		   o.setStatus(status);
	    		   
	    		   Order o1=oimpl.placeOrder(o);
	    		   
	    		   if(o1!=null) {
	    			 
	    			  System.out.println("Your order has been placed.Thank you..."); 
	    			  System.out.println("*****Your order details*****"); 
	    			  
	    			  System.out.println("Order no: "+o1.getOrderId());
	    			  System.out.println("Total amount paid: "+o1.getBill());
	    			  System.out.println("Delivery adderss: "+o1.getDropLocation());
	    			  
	    			  LocalDate date=LocalDate.parse(o1.getOrderDate(), format);
	    			  
	    			  LocalDate deliver=date.plusDays(5);
	    			  
	    			  format=DateTimeFormatter.ofPattern("dd LLLL yyyy");
	    			  String d=deliver.format(format);
	    			  System.out.println("Your order will be delivered before: "+d);
	    			   
	    			  System.out.println("________________________________________________________________");
	    			  
	    		   }
	    		   else
	    			   System.out.println("Sorry your order could not be placed!!");
	    	   
	    		   
	    		
	    		   
	    	 
	    		  
	    		  
	    	  }
	          
	          
		  }
	   
		}
	}

}
