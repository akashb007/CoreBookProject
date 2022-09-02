package com.book.test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.book.dao.OrderDaoImpl;
import com.book.pojo.Order;

public class OrderTestAdmin {

	public static void main(String[] args) {

	Scanner sc=new Scanner(System.in);	
     boolean exit=false;
     
     Integer orderId;
     String orderDate;
  	 String status;
  	 Double bill;
	 String dropLocation;
  	
  	 Order o=null;
  	 OrderDaoImpl oimpl=new OrderDaoImpl();
  	 List<Order> olist=null;
  	 boolean flag;
     
     do {
    	 
    	 System.out.println("***** Admin Authorities *****");
    	 System.out.println("1-----> Show all orders");
    	 System.out.println("2-----> Update status of order");
    	 
    	 
    	 int option=sc.nextInt();
    	 sc.nextLine();
    	 
    	 
    	switch(option) {
    	
    	case 1: 
    		
    		olist=oimpl.showAllOrders();
    		
  		    if(olist!=null && olist.isEmpty()!=true) {
		    	
		        Iterator<Order> it=olist.iterator();
		        
		        while(it.hasNext()) {
		        	
		        	o=it.next();
		        	
		        	System.out.println("Order Id: "+o.getOrderId());
		        	System.out.println("Amount paid: "+o.getBill());
		        	System.out.println("Ordered on date: "+o.getOrderDate());
		        	System.out.println("Delivery location: "+o.getDropLocation());
		        	System.out.println("Status: "+o.getStatus());
		        	System.out.println("Customer email: "+o.getEmail());
		         	
		        	System.out.println("___________________________________________________________");
		        }    	
		    }
  		    
  		    else
  		    	System.err.println("No one has ordered any books yet");
		
    	break;
    	
    	
    	case 2:
    		    
    		System.out.println("Enter order Id of the order for which status has to be changed");
    		orderId=sc.nextInt();
    		sc.nextLine();
    		
    		System.out.println("Enter the new status");
    		status=sc.nextLine();
    		
    		flag=oimpl.updateStatus(orderId, status);
    		
    		if(flag)
    			System.out.println("Status updated successfully");
    		else
    			System.out.println("Error while updating status");
    		
    		
    		break;
      	}
    	 
     }
     while(exit==false);
		
		

	}

}
