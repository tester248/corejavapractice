package misc;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PreparedDemo {

	public static void main(String[] args) throws Exception {
		
		String sql = "insert into mmcoe.cust values (?, ?, ?)";
		
		Connection conn = JdbcFactory.getConnection();
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, Integer.parseInt(args[0]));
		stmt.setString(2, args[1]);
		stmt.setString(3, args[2]);
		
		int rows = stmt.executeUpdate();
		System.out.println(rows + " rows updated");
	}
}