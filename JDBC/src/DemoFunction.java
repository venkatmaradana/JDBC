import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;


public class DemoFunction {
	
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String DB_USER = "system";
	private static final String DB_PASSWORD = "xe";
	
	public static void main(String[] args) throws Exception {
        
		Class.forName(DB_DRIVER);
		
		Connection dbConnection = DriverManager.getConnection(
				DB_CONNECTION, DB_USER,DB_PASSWORD);
				CallableStatement cstmt = dbConnection.prepareCall("{call ?:=getSal (?)}");
		cstmt.registerOutParameter(1, Types.INTEGER);
		cstmt.setInt(2, 100);
		
		cstmt.execute();
		
		int sal = cstmt.getInt(1);
		System.out.println("Salary..."+sal);
	}
}
