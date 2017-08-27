package com.sunbeam.sh4.jsp_shop;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LoginDao implements AutoCloseable {
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
		
	public boolean checkLogin(String username, String password) throws Exception {
		String sql = "SELECT NAME, PASSWORD FROM CUSTOMERS WHERE NAME=? AND PASSWORD=?";
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			if(rs.next()) 
				return true;
		} finally {
			if(rs!=null)
				rs.close();
			if(stmt!=null)
				stmt.close();
		}
		return false;
	}
}






