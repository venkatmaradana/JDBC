import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class DemoPreparedStatement {

	
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String DB_USER = "system";
	private static final String DB_PASSWORD = "xe";
	
	public static void main(String[] args) throws Exception {

		
        Class.forName(DB_DRIVER);
		
		Connection dbConnection = DriverManager.getConnection(
				DB_CONNECTION, DB_USER,DB_PASSWORD);
		
		
		PreparedStatement pstmt = dbConnection.prepareStatement("INSERT INTO EMPLOYEE VALUES(?,?,?)");
        pstmt.setInt(1, 203);
        pstmt.setString(2, "amar2");
        pstmt.setInt(3, 20003);
        
		/*PreparedStatement pstmt = dbConnection.prepareStatement("UPDATE EMPLOYEE SET SALARY = ? WHERE EID = ?");
        pstmt.setInt(1, 40003);
        pstmt.setInt(2, 203);*/
		
		/*PreparedStatement pstmt = dbConnection.prepareStatement("DELETE EMPLOYEE WHERE EID = ?");
        pstmt.setInt(1, 300);*/
       
		int rowCount = pstmt.executeUpdate();
		
		if(rowCount > 0) {
			System.out.println("Record inserted..."+rowCount);
		}
	}
}
