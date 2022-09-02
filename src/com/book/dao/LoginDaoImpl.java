package com.book.dao;

 import java.sql.*;

import com.book.util.DBConnectivity;
 
  public class LoginDaoImpl implements LoginDAO{

	Connection con=null;
	PreparedStatement ps=null;
	String sql=null;
	ResultSet rs=null;
	
	
	@Override
	public boolean checkCustomer(String email, String password) {
 
     con=DBConnectivity.makeConnection();
     
     sql="select * from customer_9607 where email=? and password=?";
		
     try {
		ps=con.prepareStatement(sql);
		
		ps.setString(1, email);
		ps.setString(2, password);
		
       rs=ps.executeQuery();
		
	  if(rs.next())
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

}
