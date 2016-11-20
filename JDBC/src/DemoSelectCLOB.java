import java.io.FileOutputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DemoSelectCLOB {
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String DB_USER = "system";
	private static final String DB_PASSWORD = "xe";
	
	public static void main(String[] args) throws Exception {

		
        Class.forName(DB_DRIVER);
		
		Connection dbConnection = DriverManager.getConnection(
				DB_CONNECTION, DB_USER,DB_PASSWORD);
		
		
		Statement pstmt = dbConnection.createStatement();   
        ResultSet rs= pstmt.executeQuery("SELECT * FROM PERSONALDETAILS1");
         
        while(rs.next()) {
        	int eid = rs.getInt(1);
        	Reader is = rs.getCharacterStream(2);
        	
        	FileOutputStream fos = new FileOutputStream("D:\\abc\\myclob.txt");
        	
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
