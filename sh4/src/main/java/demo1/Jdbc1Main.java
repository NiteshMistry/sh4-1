package demo1;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Jdbc1Main {
	private static Properties props = new Properties();
	public static void loadProperties() {
		try(InputStream in = Jdbc1Main.class.getResourceAsStream("/jdbc.properties")) {
			props.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception {
		loadProperties();
		Class.forName(props.getProperty("db.driver"));
		Connection con = DriverManager.getConnection(
								props.getProperty("db.url"), 
								props.getProperty("db.user"), 
								props.getProperty("db.pass"));
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT SYSDATE()");
		if(rs.next()) {
			Date result = rs.getDate(1);
			System.out.println(result);
		}
		con.close();
	}
}
