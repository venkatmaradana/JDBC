import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DemoSelectArrayType {

	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String DB_USER = "system";
	private static final String DB_PASSWORD = "xe";
	
	public static void main(String[] args) throws Exception {

		
        Class.forName(DB_DRIVER);
		
		Connection dbConnection = DriverManager.getConnection(
				DB_CONNECTION, DB_USER,DB_PASSWORD);
		
		
		Statement pstmt = dbConnection.createStatement();   
        ResultSet rs= pstmt.executeQuery("SELECT * FROM PERSONALDETAILS2");
         
        while(rs.next()) {
        	int eid = rs.getInt(1);
        	String name = rs.getString(2);
        	
        	Array a = rs.getArray(3);
        	ResultSet visaNos = a.getResultSet();
        	StringBuffer VISA_NOS = new StringBuffer("");
        	while(visaNos.next()) {
        		String visaNo = visaNos.getString(2);
        		VISA_NOS.append(visaNo+", ");
        	}
        	
        	System.out.println("EID: "+eid);
        	System.out.println("ENAME: "+name);
        	System.out.println("VISA: "+VISA_NOS);
        	System.out.println("========================");
        }
	}    
}
