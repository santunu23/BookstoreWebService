package com.santunu23.bookstorewebservice;



import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class BookRepository {
	 Connection conn=null;
     List<MyBookStore> bookstore;
     
	public BookRepository() {
		String url="jdbc:mysql://localhost:3306/booklist";
		String username="root";
		String password="618643";
	
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=(Connection) DriverManager.getConnection(url,username,password);
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public List<MyBookStore> getBooks(){
		List<MyBookStore> mybookstore=new ArrayList<>();
		MyBookStore m=new MyBookStore();
		String sql="SELECT * FROM storebooklist";
		try{
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()){
			m.setBookList(rs.getInt(2));
			m.setBookName(rs.getString(3));
			m.setBookReadCount(rs.getInt(4));
			m.setBookFileSize(rs.getInt(5));
			m.setBookPrice(rs.getInt(6));
			m.setBookLanguage(rs.getString(7));
			m.setBookWriter(rs.getString(8));
			mybookstore.add(m);
		}
		}catch(Exception e){
			System.out.println(e);
		}
		
		return mybookstore;
	}
	
	
	
	public MyBookStore getBook(int id){
		System.out.println(id);
		String sql="SELECT * FROM storebooklist WHERE bookList="+id;
		System.out.println(sql);
		MyBookStore m=new MyBookStore();
		try{
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		
		if(rs.next()){
			m.setBookList(rs.getInt(2));
			m.setBookName(rs.getString(3));
			m.setBookReadCount(rs.getInt(4));
			m.setBookFileSize(rs.getInt(5));
			m.setBookPrice(rs.getInt(6));
			m.setBookLanguage(rs.getString(7));
			m.setBookWriter(rs.getString(8));	
		}
		
		System.out.println(rs.getInt(2));
	   }
		catch(Exception e)
		{
			System.out.println(e);
		}

		return m;
	}
	
	// (bookList,bookName,bookReadCount,bookFileSize,bookPrice,bookLanguage,bookWriter)
	public void createMyBook(MyBookStore rs){
		String sql="INSERT into storebooklist(bookList,bookName,bookReadCount,bookFileSize,bookPrice,bookLanguage,bookWriter) values (?,?,?,?,?,?,?)";
		try{
			PreparedStatement st=(PreparedStatement) conn.prepareStatement(sql);
			st.setInt(1, rs.getBookList());
			st.setString(2, rs.getBookName());
			st.setInt(3, rs.getBookReadCount());
			st.setInt(4, rs.getBookFileSize());
		    st.setInt(5, rs.getBookPrice());
		    st.setString(6, rs.getBookLanguage());
		    st.setString(7, rs.getBookWriter());
			st.executeUpdate();
		   }catch(Exception e)
			{
				System.out.println(e);
			}
	}

	public void delete(int id) {
		
		String sql="DELETE FROM storebooklist WHERE bookList=?";
		try{
			PreparedStatement st=(PreparedStatement) conn.prepareStatement(sql);
		    st.setInt(1, id);
			st.executeUpdate();
		   }catch(Exception e)
			{
				System.out.println(e);
			}
}
	
public void update(MyBookStore rs) {
		
		String sql="UPDATE storebooklist set bookList=?,bookName=?,bookReadCount=?,bookFileSize=?,bookPrice=?,bookLanguage=?,bookWriter=? where bookList=?";
		try{
			PreparedStatement st=(PreparedStatement) conn.prepareStatement(sql);
			st.setInt(7, rs.getBookList());
			st.setString(1, rs.getBookName());
			st.setInt(2, rs.getBookReadCount());
			st.setInt(3, rs.getBookFileSize());
		    st.setInt(4, rs.getBookPrice());
		    st.setString(5, rs.getBookLanguage());
		    st.setString(6, rs.getBookWriter());
			st.executeUpdate();
		   }catch(Exception e)
			{
				System.out.println(e);
			}
}	
	
	

}
