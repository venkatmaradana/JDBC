import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class DemoInsertBLOB {
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String DB_USER = "system";
	private static final String DB_PASSWORD = "xe";
	
	public static void main(String[] args) throws Exception {

		
        Class.forName(DB_DRIVER);
		
		Connection dbConnection = DriverManager.getConnection(
				DB_CONNECTION, DB_USER,DB_PASSWORD);
		
		
		PreparedStatement pstmt = dbConnection.prepareStatement("INSERT INTO PERSONALDETAILS VALUES(?,?)");
        pstmt.setInt(1, 100);
        
        File f = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg");
        FileInputStream fis = new FileInputStream(f);
        int fileLength = (int)f.length();
        
        pstmt.setBinaryStream(2, fis, fileLength);
        
        int rowCount = pstmt.executeUpdate();
		
		if(rowCount > 0) {
			System.out.println("Record inserted..."+rowCount);
		}
	}
}
