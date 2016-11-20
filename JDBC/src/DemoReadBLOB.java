import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DemoReadBLOB {
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String DB_USER = "system";
	private static final String DB_PASSWORD = "xe";
	
	public static void main(String[] args) throws Exception {

		
        Class.forName(DB_DRIVER);
		
		Connection dbConnection = DriverManager.getConnection(
				DB_CONNECTION, DB_USER,DB_PASSWORD);
		
		
		Statement pstmt = dbConnection.createStatement();   
        ResultSet rs= pstmt.executeQuery("SELECT * FROM PERSONALDETAILS");
         
        while(rs.next()) {
        	int eid = rs.getInt(1);
        	InputStream is = rs.getBinaryStream(2);
        	
        	FileOutputStream fos = new FileOutputStream("D:\\abc\\myblob.jpg");
        	
        	int i = is.read();
        	
        	while(i != -1 ) {
        		fos.write(i);
        		i = is.read();
        	}
        	fos.close();
        } 
	      System.out.println("File received...");
	   }
}
