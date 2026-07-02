package misc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class ConnectionDemo {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:55555/mmcoe";
		
		try {
			DriverManager.registerDriver(new Driver());
			Connection conn = DriverManager.getConnection(url, "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connection Succesful" );
	}
}
