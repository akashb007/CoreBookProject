package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.pojo.Customer;
import com.book.util.DBConnectivity;

public class CustomerDaoImpl implements CustomerDAO {

	 Connection con=null;
	 String sql=null;
	 PreparedStatement ps=null;
	 ResultSet rs=null;
	 List<Customer> clist=null;
	 Customer c=null;
	 
	
	@Override
	public boolean addCustomer(Customer c) {

       con=DBConnectivity.makeConnection();
       
       sql="insert into customer_9607(fname,lname,caddress,contact,email,password) values (?,?,?,?,?,?)";                                  
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setString(1, c.getFname());
			ps.setString(2, c.getLname());
			ps.setString(3, c.getCaddress());
			ps.setString(4, c.getContact());
			ps.setString(5, c.getEmail());
			ps.setString(6, c.getPassword());
			
			int i=ps.executeUpdate();
			
			if(i>0)
				return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  finally {
			  
			  try {
				ps.close();
				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		
		
		return false;
	}

	
	
	@Override
	public boolean updateCustomer(Customer c) {
 
       con=DBConnectivity.makeConnection();
       
       sql="update customer_9607 set fname=?, lname=?, caddress=?, contact=?, email=? ,password=? where custId=?";
		
       try {
		
    	   ps=con.prepareStatement(sql);
		
		  ps.setString(1, c.getFname());
		  ps.setString(2, c.getLname());
		  ps.setString(3, c.getCaddress());
		  ps.setString(4, c.getContact());
		  ps.setString(5, c.getEmail());
		  ps.setString(6, c.getPassword());
		  ps.setInt(7, c.getCustId());
		  
		  int i=ps.executeUpdate();
		  
		  if(i>0)
               
			  return true;

		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       
       finally {
    	   
    	   try {
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       }
		
		return false;
	}

	
	
	@Override
	public boolean deleteCustomer(Integer custId) {

        con=DBConnectivity.makeConnection();
        
        sql="delete from customer_9607 where custId=?";
        
        try {
			
        	ps=con.prepareStatement(sql);
			
			ps.setInt(1, custId);
			
			int i=ps.executeUpdate();
			
			if(i>0) 
				return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
          finally {
        	  
        	  try {
				
        		  ps.close();
				  con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          }
        	
		return false;
	}

	
	
	@Override
	public List<Customer> showAllCustomer() {

       con=DBConnectivity.makeConnection();
       
       sql="select * from customer_9607 order by fname";
       
       try {
		
    	   ps=con.prepareStatement(sql);
		
		  rs=ps.executeQuery();
		  clist=new ArrayList<>();
		  
		  while(rs.next()) {
			  
			  c=new Customer();
			  
			 c.setCustId(rs.getInt(1));
			 c.setFname(rs.getString(2));
			 c.setLname(rs.getString(3));
			 c.setCaddress(rs.getString(4));
			 c.setContact(rs.getString(5));
			 c.setEmail(rs.getString(6));
			 c.setPassword(rs.getString(7));
			 
			 clist.add(c);
			 
		  }
		     return clist;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       finally {
    	   try {
			
    		   ps.close();
			   con.close();
			  
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       }
       
		
		
		
		return null;
	}

	
	
	@Override
	public Customer showCustomerByEmail(String cemail) {
 
         con=DBConnectivity.makeConnection();
         
         sql="select * from customer_9607 where email=?";
         
         try {
			
        	 ps=con.prepareStatement(sql);
			
			 ps.setString(1, cemail);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				
				 c=new Customer();
				   
				   c.setCustId(rs.getInt(1));
				   c.setFname(rs.getString(2));
				   c.setLname(rs.getString(3));
				   c.setCaddress(rs.getString(4));
				   c.setContact(rs.getString(5));
				   c.setEmail(rs.getString(6));
				   c.setPassword(rs.getString(7));
				   
				   return c;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         finally {
           	 
      	      try {
				ps.close();
				con.close();
			
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       }
       
		return null;
	}

	
	
	@Override
	public Customer showCustomerById(Integer custId) {

        con=DBConnectivity.makeConnection();
        
        sql="select * from customer_9607 where custId=?";
        
        try {
			ps=con.prepareStatement(sql);
			
		ps.setInt(1, custId);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				
				   c=new Customer();
				   
				   c.setCustId(rs.getInt(1));
				   c.setFname(rs.getString(2));
				   c.setLname(rs.getString(3));
				   c.setCaddress(rs.getString(4));
				   c.setContact(rs.getString(5));
				   c.setEmail(rs.getString(6));
				   c.setPassword(rs.getString(7));
				   
				   return c;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           finally {
       	 
       	      try {
				ps.close();
				con.close();
			
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
		return null;
	}

	
	
	@Override
	public List<Customer> showCustomerByFname(String fname) {
		
		
		con=DBConnectivity.makeConnection();
		
		sql="select * from customer_9607 where fname=?";
		
		try {
			
			ps=con.prepareStatement(sql);
			
			ps.setString(1, fname);
			
			rs=ps.executeQuery();
			
			clist=new ArrayList<>();
			
			while(rs.next()) {
				
				c=new Customer();
				
				c.setCustId(rs.getInt(1));
				c.setFname(rs.getString(2));
				c.setLname(rs.getString(3));
				c.setCaddress(rs.getString(4));
				c.setContact(rs.getString(5));
				c.setEmail(rs.getString(6));
				c.setPassword(rs.getString(7));
				
				clist.add(c);
				
			}
			   return clist;
			   
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 finally {
	       	 
      	      try {
				ps.close();
				con.close();
			
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       }
		
		return null;
	}
	

 }
