import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;


public class DemoCallableStatement {

	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String DB_USER = "system";
	private static final String DB_PASSWORD = "xe";
	
	public static void main(String[] args) throws Exception {
        
		Class.forName(DB_DRIVER);
		
		Connection dbConnection = DriverManager.getConnection(
				DB_CONNECTION, DB_USER,DB_PASSWORD);
		
		CallableStatement cstmt = dbConnection.prepareCall("{call createEmployee (?,?,?)}");
		cstmt.setInt(1, 300);
		cstmt.setString(2, "amar3");
		cstmt.setInt(3, 300);
		
		cstmt.execute();
		
		System.out.println("Record inserted...");
		

	}

}
