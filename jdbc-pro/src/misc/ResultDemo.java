package misc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultDemo {

	public static void main(String[] args) throws Exception {
		String sql = "select * from cust";
		try {
			Connection conn = JdbcFactory.getConnection();
			
			Statement stmt = conn.createStatement();
			
			//Executing DQL operaton and getting results into ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData meta = rs.getMetaData();
			for(int i=1; i<=meta.getColumnCount(); i++)
				System.out.print(meta.getColumnName(i) + "\t");
			System.out.println();
			
			while(rs.next()) {
				System.out.println(rs.getInt("cid") + ", " + ", " + rs.getString(2) + ", " +  rs.getString(3));
			}
			

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}