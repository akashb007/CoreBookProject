package com.book.util;

 import java.sql.*;
 
public class DBConnectivity {

	public static Connection makeConnection() {
		
		Connection con=null;
		
	  try {
		
		  Class.forName("com.mysql.cj.jdbc.Driver");
		
		  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookproject_9607?user=root&password=root");                    
		
		  
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
		
		
		return con;
		
	}
	
	
}
