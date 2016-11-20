import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;


public class DemoInsertArrayType {
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String DB_USER = "system";
	private static final String DB_PASSWORD = "xe";
	
	public static void main(String[] args) throws Exception {

		
        Class.forName(DB_DRIVER);
		
		Connection dbConnection = DriverManager.getConnection(
				DB_CONNECTION, DB_USER,DB_PASSWORD);
		
		
		PreparedStatement pstmt = dbConnection.prepareStatement("INSERT INTO PERSONALDETAILS2 VALUES(?,?,?)");
        
		pstmt.setInt(1, 200);
		pstmt.setString(2, "amar1");
		
		//1st way
		String[] visaNos = {"CANADA", "NZ", "AU"};
		ArrayDescriptor ad = ArrayDescriptor.createDescriptor("VISA_NOS", dbConnection);
		ARRAY ar = new ARRAY(ad, dbConnection, visaNos);
		
		pstmt.setArray(3, ar);
		
		//2nd way
		//String[] visaNos1 = {"CANADA", "NZ", "AU"};
		//Array a = dbConnection.createArrayOf("VARCHAR", visaNos1);
		//pstmt.setArray(3, a);
        
        int rowCount = pstmt.executeUpdate();
		
		if(rowCount > 0) {
			System.out.println("Record inserted..."+rowCount);
		}
	}
}
