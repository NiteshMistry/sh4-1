package com.sunbeam.sh4.jsp_shop;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDao implements AutoCloseable {
	public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/sh4";
	public static final String DB_USER = "nilesh";
	public static final String DB_PASS = "nilesh";

	private Connection con;
	private PreparedStatement stmt;
	
	static {
		try {
			Class.forName(DB_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() throws Exception {
		con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	}
	
	public void close() {
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
		}
	}

/*	// Not required for this assignment	
	public int deleteBook(int id) throws Exception {
		String sql = "DELETE FROM BOOKS WHERE ID=?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			int cnt = stmt.executeUpdate();
			return cnt;
		} finally {
			if(stmt!=null)
				stmt.close();
		}
	}
	
	public int insertBook(Book b) throws Exception {
		String sql = "INSERT INTO BOOKS VALUES(?,?,?,?,?)";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, b.getId());
			stmt.setString(2, b.getName());
			stmt.setString(3, b.getAuthor());
			stmt.setString(4, b.getSubject());
			stmt.setDouble(5, b.getPrice());
			int cnt = stmt.executeUpdate();
			return cnt;
		} finally {
			if(stmt!=null)
				stmt.close();
		}
	}
		
	public int updateBook(Book b) throws Exception {
		String sql = "UPDATE BOOKS SET NAME=?, AUTHOR=?, SUBJECT=?, PRICE=? WHERE ID=?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, b.getName());
			stmt.setString(2, b.getAuthor());
			stmt.setString(3, b.getSubject());
			stmt.setDouble(4, b.getPrice());
			stmt.setInt(5, b.getId());
			int cnt = stmt.executeUpdate();
			return cnt;
		} finally {
			if(stmt!=null)
				stmt.close();
		}
	}
		
	public List<Book> getAllBooks() throws Exception {
		String sql = "SELECT ID,NAME,AUTHOR,SUBJECT,PRICE FROM BOOKS";
		List<Book> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Book b = new Book();
				b.setId( rs.getInt("ID") );
				b.setName( rs.getString("NAME") );
				b.setAuthor( rs.getString("AUTHOR") );
				b.setSubject( rs.getString("SUBJECT") );
				b.setPrice( rs.getDouble("PRICE") );
				list.add(b);
			}
		} finally {
			if(rs!=null)
				rs.close();
			if(stmt!=null)
				stmt.close();
		}
		return list;
	}
*/	
	
	public List<Book> getBooks(String subject) throws Exception {
		String sql = "SELECT ID,NAME,AUTHOR,SUBJECT,PRICE FROM BOOKS WHERE SUBJECT=?";
		List<Book> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, subject);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Book b = new Book();
				b.setId( rs.getInt("ID") );
				b.setName( rs.getString("NAME") );
				b.setAuthor( rs.getString("AUTHOR") );
				b.setSubject( rs.getString("SUBJECT") );
				b.setPrice( rs.getDouble("PRICE") );
				list.add(b);
			}
		} finally {
			if(rs!=null)
				rs.close();
			if(stmt!=null)
				stmt.close();
		}
		return list;
	}
	
	public Book getBook(int id) throws Exception {
		String sql = "SELECT ID,NAME,AUTHOR,SUBJECT,PRICE FROM BOOKS WHERE ID=?";
		Book b = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				b = new Book();
				b.setId( rs.getInt("ID") );
				b.setName( rs.getString("NAME") );
				b.setAuthor( rs.getString("AUTHOR") );
				b.setSubject( rs.getString("SUBJECT") );
				b.setPrice( rs.getDouble("PRICE") );
			}
		} finally {
			if(rs!=null)
				rs.close();
			if(stmt!=null)
				stmt.close();
		}
		return b;
	}
	
	public List<String> getSubjects() throws Exception {
		ResultSet rs = null;
		List<String> list = new ArrayList<>();
		String sql = "SELECT DISTINCT SUBJECT FROM BOOKS";
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String subject = rs.getString("SUBJECT");
				list.add(subject);
			}
		} finally {
			if(rs!=null)
				rs.close();
			if(stmt!=null)
				stmt.close();
		}
		return list;		
	}
}






