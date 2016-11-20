import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import oracle.jdbc.driver.OracleTypes;


public class DemoFunctionCursor {

	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String DB_USER = "system";
	private static final String DB_PASSWORD = "xe";
	
	public static void main(String[] args) throws Exception {
        
		Class.forName(DB_DRIVER);
		
		Connection dbConnection = DriverManager.getConnection(
				DB_CONNECTION, DB_USER,DB_PASSWORD);
				CallableStatement cstmt = dbConnection.prepareCall("{call ?:=getEmployees (?)}");
		cstmt.registerOutParameter(1, OracleTypes.CURSOR);
		cstmt.setInt(2, 15000);
		
		cstmt.execute();
		
		ResultSet rs = (ResultSet)cstmt.getObject(1);
		
		while(rs.next()) {
			int eid = rs.getInt(1);
			String name = rs.getString(2);
			int sal = rs.getInt(3);
			System.out.println("Eid: "+eid);
			System.out.println("Name: "+name);
			System.out.println("Salary: "+sal);
			System.out.println("-------------------");
		}
	}
}
