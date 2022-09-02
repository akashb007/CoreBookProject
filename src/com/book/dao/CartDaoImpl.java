package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.pojo.Book;
import com.book.pojo.Cart;
import com.book.util.DBConnectivity;

public class CartDaoImpl implements CartDAO {

	Connection con=null;
	PreparedStatement ps=null;
	String sql=null;
	ResultSet rs=null;
	Cart c=null;
	List<Cart> clist=null;
	
	
	@Override
	public boolean addToCart(Cart c) {
        
      con=DBConnectivity.makeConnection();
      
      sql="insert into cart_9607(bookId,email,quantity) values (?,?,?)";
      
      try {
		
    	  ps=con.prepareStatement(sql);
		
		 ps.setInt(1, c.getBookId());
    	 ps.setString(2, c.getEmail()); 
    	 ps.setInt(3, c.getQuantity()); 
    	 
    	int i= ps.executeUpdate();
    	 
    	if(i>0)
    		return true;
    	
    	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	 }
      
  	return false;
  }

	
	
	@Override
	public boolean deleteCartItem(Integer cartId) {

        con=DBConnectivity.makeConnection();
        
        sql="delete from cart_9607 where cartId=?";
        
        try {
			
        	ps=con.prepareStatement(sql);
			
			ps.setInt(1, cartId);
        	
        	int i=ps.executeUpdate();
        	
			if(i>0)
				return true;
        	
        	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
		
		
		return false;
	}

	
	
	@Override
	public boolean updateQuantity(Integer quantity, Integer cartId) {

       con=DBConnectivity.makeConnection();
       
       sql="update cart_9607 set quantity=? where cartId=?";
       
       try {
		
    	   ps=con.prepareStatement(sql);
		
		   ps.setInt(1, quantity);
		   ps.setInt(2, cartId);
		   
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
	public boolean clearCart(String email) {

      con=DBConnectivity.makeConnection();
      
      sql="delete from cart_9607 where email=?";
		
	try {
	
		ps=con.prepareStatement(sql);
		
		ps.setString(1, email);
		
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
	public List<Cart> showMyCart(String email) {

       con=DBConnectivity.makeConnection();
       
       sql="select * from cart_9607 where email=?";
       
       try {
		
    	   ps=con.prepareStatement(sql);
    	   
    	   ps.setString(1, email);
    	   
    	   rs=ps.executeQuery();
    	   
    	   clist= new ArrayList<>();
    	   
    	   while(rs.next()) {
    		   
    		 c=new Cart();
    		 
    		   c.setCartId(rs.getInt(1));
    		   c.setBookId(rs.getInt(2));
    		   c.setEmail(rs.getString(3));
    		   c.setQuantity(rs.getInt(4));
    		
   //  In cart table we have stored only bookId.In order to see all other details of
   // 	that book we are fetching details of that book from book_9607 table	   
    		   
    		  Book b=new BookDaoImpl().showBookById(rs.getInt("bookId"));
    		  
    		  c.setB(b);
    		  
    		  clist.add(c);
    		   
    	   }
    		   return clist;
   
       } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }

	   return null;
	}

	
	
	@Override
	public Cart showCartById(Integer cartId) {

      con=DBConnectivity.makeConnection();
      
      sql="select * from cart_9607 where cartId=?";
      
      try {
	
    	  ps=con.prepareStatement(sql);
		
		  ps.setInt(1, cartId);
		  
		  rs=ps.executeQuery();
		  
		  if(rs.next()) {
			  
			  c=new Cart();
			  
			  c.setCartId(rs.getInt(1));
			  c.setBookId(rs.getInt(2));
			  c.setEmail(rs.getString(3));
			  c.setQuantity(rs.getInt(4));
			
			  Book b=new BookDaoImpl().showBookById(rs.getInt("bookId"));
			  
			  c.setB(b);
			  
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

}
