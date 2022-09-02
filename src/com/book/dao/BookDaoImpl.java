package com.book.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.sql.*;

import com.book.pojo.Book;
import com.book.util.DBConnectivity;

public class BookDaoImpl implements BookDao {

	Connection con=null;
	String sql=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	List<Book> blist=null;
	Book b=null;
	
	
	@Override
	public boolean addBook(Book b) {
  
        con=DBConnectivity.makeConnection();
        
		sql="insert into book_9607(bookName, author, category, description,  price,  noOfBooks) values (?, ? ,? ,?, ?, ?)";                      
		
	   try {
		
		   ps=con.prepareStatement(sql);
		   
		   ps.setString(1, b.getBookName());
		   ps.setString(2, b.getAuthor());
		   ps.setString(3, b.getCategory());
		   ps.setString(4, b.getDescription());
		   ps.setDouble(5, b.getPrice());
		   ps.setInt(6, b.getNoOfBooks());
		   
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
	public boolean updateBook(Book b) {

       con=DBConnectivity.makeConnection();
       
       sql="update book_9607 set bookName=?, author=?, category=?, description=?,  price=?,  noOfBooks=? where bookId=?";
		
	   try {
		ps=con.prepareStatement(sql);
		
		ps.setString(1, b.getBookName());
		ps.setString(2, b.getAuthor());
		ps.setString(3, b.getCategory());
		ps.setString(4, b.getDescription());
		ps.setDouble(5, b.getPrice());
		ps.setInt(6, b.getNoOfBooks());
		ps.setInt(7, b.getBookId());
		
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
	public boolean deleteBook(Integer bookId) {

		con=DBConnectivity.makeConnection();
		
		sql="delete from book_9607 where bookId=?";
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, bookId);
			
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
	public List<Book> showAllBooks() {

        con=DBConnectivity.makeConnection();
        
        sql="select * from book_9607 order by bookName";
		
        try {
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			blist=new ArrayList<>();
			
			while(rs.next()) {
				
				b=new Book();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setCategory(rs.getString(4));
				b.setDescription(rs.getString(5));
				b.setPrice(rs.getDouble(6));
				b.setNoOfBooks(rs.getInt(7));
				
		     	blist.add(b);
			
	     	}
			  return blist;
			
			
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
	public List<Book> showBookByAuthor(String author) {

        con=DBConnectivity.makeConnection();
        
        sql="select * from book_9607 where author=?";
        
        try {
			ps=con.prepareStatement(sql);
			
			ps.setString(1, author);
			
			rs=ps.executeQuery();
			blist=new ArrayList<>();
			
			while(rs.next()) {
				
				b=new Book();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setCategory(rs.getString(4));
				b.setDescription(rs.getString(5));
				b.setPrice(rs.getDouble(6));
				b.setNoOfBooks(rs.getInt(7));
				
				
				blist.add(b);
			}
			  return blist;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  finally {
			  try {
				ps.close();
				con.close();
				rs.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		
		return null;
	}

	
	
	
	@Override
	public List<Book> showBookByCategory(String category) {


        con=DBConnectivity.makeConnection();
        
        sql="select * from book_9607 where category=?";
        
        try {
			ps=con.prepareStatement(sql);
			
			ps.setString(1, category);
			
			rs=ps.executeQuery();
			blist=new ArrayList<>();
			
			while(rs.next()) {
				
				b=new Book();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setCategory(rs.getString(4));
				b.setDescription(rs.getString(5));
				b.setPrice(rs.getDouble(6));
				b.setNoOfBooks(rs.getInt(7));
				
				
				blist.add(b);
			}
			  return blist;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  finally {
			  try {
				ps.close();
				con.close();
				rs.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		
		return null;
	}

	
	
	@Override
	public List<Book> showBookByName(String bookName) {
 
		con=DBConnectivity.makeConnection();
		
		sql="select * from book_9607 where bookName like ?";
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setString(1, "%"+bookName+"%");
			
			rs=ps.executeQuery();
			
            blist=new ArrayList<>();
			
			while(rs.next()) {
				
				b=new Book();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setCategory(rs.getString(4));
				b.setDescription(rs.getString(5));
				b.setPrice(rs.getDouble(6));
				b.setNoOfBooks(rs.getInt(7));
			
				blist.add(b);
			}
			  return blist;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  finally {
			  try {
				ps.close();
				con.close();
				rs.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		
		return null;
	}

	
	
	
	@Override
	public Set<String> getAllCategories() {
 

		  con=DBConnectivity.makeConnection();
	         
	         sql="select category from book_9607";
			 
			 try {
				ps=con.prepareStatement(sql);
				
				rs=ps.executeQuery();
		
	// Here TreeSet is used since it removes duplicates and categories will be sorted in alphabetical order.			
			Set<String> categories=new TreeSet<String>();
			
			while(rs.next()) {
				
				categories.add(rs.getString(1));
			}
			  
			 return categories;
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			 
			 finally {
				  try {
					
					  ps.close();
					  con.close();
					  rs.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }
	   
		return null;
	}

	
	
	
	@Override
	public Set<String> getAllAuthors() {

		  con=DBConnectivity.makeConnection();
	         
	         sql="select author from book_9607";
			 
			 try {
				ps=con.prepareStatement(sql);
				
				rs=ps.executeQuery();
		
	// Here TreeSet is used since it removes duplicates and authors will be sorted in alphabetical order.			
			Set<String> authors=new TreeSet<String>();
			
			while(rs.next()) {
				
				authors.add(rs.getString(1));
			}
			  
			 return authors;
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			 
			 finally {
				  try {
					
					  ps.close();
					  con.close();
					  rs.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }
			
		
		return null;
	}




	@Override
	public Book showBookById(Integer bookId) {

         con=DBConnectivity.makeConnection();  
		
         sql="select * from book_9607 where bookId=?";
         
         try {
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, bookId);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				
				b=new Book();
				b.setBookId(rs.getInt(1));
                b.setBookName(rs.getString(2));
			    b.setAuthor(rs.getString(3));
			    b.setCategory(rs.getString(4));
			    b.setDescription(rs.getString(5));
			    b.setPrice(rs.getDouble(6));
			    b.setNoOfBooks(rs.getInt(7));
			    
			    return b;
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





