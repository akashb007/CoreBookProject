package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.pojo.Order;
import com.book.util.DBConnectivity;

public class OrderDaoImpl implements OrderDAO {
	

	Connection con=null;
	PreparedStatement ps=null;
	String sql=null;
	ResultSet rs=null;
	Order o1=null;
	List<Order> olist=null;
	
	
	@Override
	public Order placeOrder(Order o) {
 
		con=DBConnectivity.makeConnection();
		
		sql="insert into order_9607(email, orderDate, status,  bill,  dropLocation) values (?,?,?,?,?)";
		
		try {
			
			ps=con.prepareStatement(sql);
			
			ps.setString(1, o.getEmail());
			ps.setString(2, o.getOrderDate());
			ps.setString(3, o.getStatus());
			ps.setDouble(4, o.getBill());
			ps.setString(5, o.getDropLocation());
			
			
			int i=ps.executeUpdate();
			
			if(i>0) {
				
				new CartDaoImpl().clearCart(o.getEmail());
				
				sql="select * from order_9607 where email=? and orderDate=?";
				
				ps=con.prepareStatement(sql);
				
				ps.setString(1, o.getEmail());
				ps.setString(2, o.getOrderDate());
				
				rs=ps.executeQuery();
				
				if(rs.next()) {
					
					   o1=new Order();
					   
					   o1.setOrderId(rs.getInt("orderId"));
					   o1.setEmail(rs.getString("email"));
					   o1.setOrderDate(rs.getString("orderDate"));
					   o1.setStatus(rs.getString("status"));
					   o1.setBill(rs.getDouble("bill"));
					   o1.setDropLocation(rs.getString("dropLocation"));
					   
					   return o1;
					   
				}
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	
	
	@Override
	public boolean cancelOrder(Integer orderId) {

        con=DBConnectivity.makeConnection();
        
        sql="update order_9607 set status=? where orderId=?";
		
		try {
			
			ps=con.prepareStatement(sql);
			
			ps.setString(1, "Cancelled");
			ps.setInt(2, orderId);
			
			
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
	public boolean updateStatus(Integer orderId, String status) {

      con=DBConnectivity.makeConnection();
      
      sql="update order_9607 set status=? where orderId=?";
		
		try {
			
			ps=con.prepareStatement(sql);
			
			ps.setString(1, status);
			ps.setInt(2, orderId);
			
			
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
	public List<Order> showMyOrderHistory(String email) {

       con=DBConnectivity.makeConnection();
       
       sql="select * from order_9607 where email=? order by orderId desc";
		
	  try {
		
		  ps=con.prepareStatement(sql);
		  
		  ps.setString(1, email);
	
		rs=ps.executeQuery();
		
		olist=new ArrayList<Order>();
		
		while(rs.next()) {
			
			o1=new Order();
			
			   o1.setOrderId(rs.getInt("orderId"));
			   o1.setEmail(rs.getString("email"));
			   o1.setOrderDate(rs.getString("orderDate"));
			   o1.setStatus(rs.getString("status"));
			   o1.setBill(rs.getDouble("bill"));
			   o1.setDropLocation(rs.getString("dropLocation"));
			   
			   olist.add(o1);
			   
		}
		   return olist;
		
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
	public List<Order> showAllOrders() {

      con=DBConnectivity.makeConnection();
      
      sql="select * from order_9607";
      
      try {
		
    	  ps=con.prepareStatement(sql);
    	  
    	  rs=ps.executeQuery();
    	  
    	  olist=new ArrayList<Order>();
  		
  		while(rs.next()) {
  			
  			o1=new Order();
  			
  			   o1.setOrderId(rs.getInt("orderId"));
  			   o1.setEmail(rs.getString("email"));
  			   o1.setOrderDate(rs.getString("orderDate"));
  			   o1.setStatus(rs.getString("status"));
  			   o1.setBill(rs.getDouble("bill"));
  			   o1.setDropLocation(rs.getString("dropLocation"));
  			   
  			   olist.add(o1);
  			   
  		}
  		   return olist;
    	  
    	  
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
