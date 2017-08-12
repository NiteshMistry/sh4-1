package com.sh4.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContactDao implements AutoCloseable {
	public static String DB_DRIVER = "com.mysql.jdbc.Driver";
	public static String DB_URL = "jdbc:mysql://localhost:3306/sh4";
	public static String DB_USER = "nilesh";
	public static String DB_PASS = "nilesh";
	private Connection con;

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

	public List<Contact> getContacts() throws Exception {
		List<Contact> list = new ArrayList<>();
		String sql = "SELECT * FROM contacts";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					int id = rs.getInt("ID");
					String name =  rs.getString("NAME");
					String mail =  rs.getString("EMAIL");
					String mobile =  rs.getString("MOBILE");
					Contact c = new Contact(id, name, mail, mobile);
					list.add(c);
				}
			}
		}
		return list;
	}
	
	public int addContact(Contact c) throws Exception {
		String sql = "INSERT INTO contacts VALUES (?,?,?,?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, c.getId());
			stmt.setString(2, c.getName());
			stmt.setString(3, c.getMail());
			stmt.setString(4, c.getMobile());
			int cnt = stmt.executeUpdate();
			return cnt;
		}
	}
	
	public int updateContact(Contact c) throws Exception {
		String sql = "UPDATE contacts SET NAME=?, EMAIL=?, MOBILE=? WHERE ID=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, c.getName());
			stmt.setString(2, c.getMail());
			stmt.setString(3, c.getMobile());
			stmt.setInt(4, c.getId());
			int cnt = stmt.executeUpdate();
			return cnt;
		}
	}
	
	public int deleteContact(int id) throws Exception {
		String sql = "DELETE FROM contacts WHERE ID=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			int cnt = stmt.executeUpdate();
			return cnt;
		}
	}
	
}





