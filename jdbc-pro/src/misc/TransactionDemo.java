package misc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDemo {

	public static void main(String[] args) {
		String sql1 = "insert into cust values (15, 'Nik', 'Noida')";
		String sql2 = "update people set city='Madurai' where cid=11";
		String sql3 = "delete from cust where id=14";
		Connection conn = null;
		try {
			conn = JdbcFactory.getConnection();
			conn.setAutoCommit(false);
			
			Statement stmt = conn.createStatement();
			stmt.addBatch(sql1);
			stmt.addBatch(sql2);
			stmt.addBatch(sql3);
			
			stmt.executeBatch();
			conn.commit();
			System.out.println("Transaction completed!");
		} catch (SQLException e) {
			System.out.println("Transaction failed due to...");
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}