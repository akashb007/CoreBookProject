package com.book.test;

import java.util.List;
import java.util.Scanner;

import com.book.dao.CustomerDaoImpl;
import com.book.pojo.Customer;

public class CustomerTest {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Customer c=null;
		
		CustomerDaoImpl cimpl=new CustomerDaoImpl();
		
		List<Customer> clist=null;
		    
	boolean exit=false;	
	boolean flag;
	
		Integer custId;
		String fname;
	    String lname;
	    String caddress;
	    String contact;
	    String email;
		String password;
		  
	do {
		
		System.out.println("\nPlease choose the options given below...");
		
		System.out.println("1-----> Add customer");
		System.out.println("2-----> Show all costomers");
		System.out.println("3-----> Update customer");
	    System.out.println("4-----> Delete customer");
		System.out.println("5-----> Search customer by Id");
		System.out.println("6-----> Search customer by email");
		System.out.println("7-----> Search customer by first name");
		
		
	   int option=sc.nextInt();
	   sc.nextLine();
	   
	   switch(option) {
	   
	   case 1:
		      System.out.println("Enter customer first name");
	          fname=sc.next();
	          sc.nextLine();
	          
	          System.out.println("Enter customer last name");
	          lname=sc.nextLine();
	          
	          System.out.println("Enter customer address");
	          caddress=sc.nextLine();
	          
	          
	          System.out.println("Enter customer contact");
	          contact=sc.nextLine();
	          
	          System.out.println("Enter customer email");
	          email=sc.nextLine();
	         
	          System.out.println("Enter password");
	          password=sc.nextLine();
	          
	          c=new Customer();
	          
	          c.setFname(fname);
	          c.setLname(lname);
	          c.setCaddress(caddress);
	          c.setContact(contact);
	          c.setEmail(email);
	          c.setPassword(password);
	          
	        flag=cimpl.addCustomer(c);  
	          
	        if(flag)
	        	System.out.println("Customer added successfully");
	        
	        else
	        	System.out.println("Error while adding customer");
	        
	        break;
	        
	        
	   case 2:
		      
		     clist=cimpl.showAllCustomer();
	        
	        if(clist!=null && clist.isEmpty()!=true) {
	        	
	        	for(Customer c1: clist) {
	        		
	        		System.out.println(c1);
	        		System.out.println("_________________________________________________________");
	        		
	        	}
	        	
	        }
	        else
	        	System.out.println("Something went wrong...Could not fetch list");
	        
	        break;
	        
	        
	   case 3:
		       System.out.println("Enter Id of customer you want to update");
		       custId=sc.nextInt();
		       sc.nextLine();
		       
		       c=cimpl.showCustomerById(custId);
		       
		       if(c!=null) {
		    	   
		    	   System.out.println("Your customer details are\n"+c);
		    	   System.out.println("\nAre you sure you want to update this customer? Answer in yes or no");
		    	   
		    	   String choice=sc.next();
		    	   sc.nextLine();
		    	   
		    	   if(choice.equals("yes")) {
		    		   
		    		  System.out.println("Enter customer first name");
		 	          fname=sc.next();
		 	          sc.nextLine();
		 	          
		 	          System.out.println("Enter customer last name");
		 	          lname=sc.nextLine();
		 	          
		 	          System.out.println("Enter customer address");
		 	          caddress=sc.nextLine();
		 	          
		 	          
		 	          System.out.println("Enter customer contact");
		 	          contact=sc.nextLine();
		 	          
		 	          System.out.println("Enter customer email");
		 	          email=sc.nextLine();
		 	         
		 	          System.out.println("Enter password");
		 	          password=sc.nextLine();
		 	          
		    		    
		    		c=new Customer(custId, fname, lname, caddress, contact, email, password);
		    		
		    		flag=cimpl.updateCustomer(c);
		    		
		    		if(flag)
		    			System.out.println("Customer updated successfully");
		    		
		    		else
		    			System.out.println("Error while updating customer");
		    		   
		    	   }
		    	   else if(choice.equals("no")) {
		    		   
		    		   System.out.println("No problem");
		    	   }
		    	   else
		    		   System.out.println("Please give answer in yes or no only");
		    		   
		       }
		    		   
		       else
		    	   System.out.println("No customer found with this Id");
		       
	       break; 
	       
	       
	   case 4:
		       System.out.println("Enter Id of customer you want to delete");
		       custId=sc.nextInt();
		       sc.nextLine();
		       
		       c=cimpl.showCustomerById(custId);
	       
	           if(c!=null) {
	        	   
	        	    System.out.println("\nYour customer details"+c);
					System.out.println("\nAre you sure you want to delete it?Answer in yes or no");
					
					 String choice=sc.next().toLowerCase();
				     sc.nextLine();
	        	   
	        	   
				     if(choice.equals("yes")) {
				    	 
				    	 flag=cimpl.deleteCustomer(custId);
				    	 
				    	 if(flag)
				    		 System.out.println("Customer deleted successfully");
				    	 
				    	 else
				    		 System.out.println("Error while deleting customer");
				    	 
				    	 
				     }
				     else if(choice.equals("no"))
				    	   System.out.println("No problem");
				     
				     else
				    	 System.out.println("Please give answer in yes or no only");
	           }
	           else
	        	   System.out.println("No customer found by this id");
	       
	      break;  
	   
	      
	   case 5:
		   
		            System.out.println("\nEnter Id of customer you want to search");
	       
		            custId=sc.nextInt();
	                sc.nextLine();
	          
	              c=cimpl.showCustomerById(custId);
	              
	              if(c!=null) {
	            	  
	            	  System.out.println("\nYour customer details"+c);
	            	  System.out.println("_______________________________________________________");
					  
	              }
	               
	              else
		        	   System.out.println("No customer found by this id");
	              
	           break;
	      
	      
	   case 6:
		  
		        System.out.println("\nEnter Email of customer you want to search");
	      
	            email=sc.next();
	            sc.nextLine();
	            
	            c=cimpl.showCustomerByEmail(email);
	            
	            if(c!=null) {
	            	
	            	  System.out.println("\nYour customer details"+c);
	            	  System.out.println("_______________________________________________________");
			      	
	            }
	            else
		        	   System.out.println("No customer found by this Email");
	       
	       break;
	
	      
	   case 7:
		    
		       System.out.println("\nEnter First Name of customer you want to search");
		   
		       fname=sc.next();
		       sc.nextLine();
		       
		       clist=cimpl.showCustomerByFname(fname);
		       
		       if(clist!=null && clist.isEmpty()!=true) {
		    	   
		    	   for(Customer c1: clist) {

		            	  System.out.println("\nYour customer details "+c1);
		            	  System.out.println("_______________________________________________________");
				      	
		    	   }
		     	   
		       }
		       else
		    	   System.out.println("No customer found with this name");
		        
	      break;
	      
	      
	      
	   }
	   
	}
	   while(exit==false);	
		
	}

}
