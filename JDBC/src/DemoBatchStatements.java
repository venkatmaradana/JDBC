import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class DemoBatchStatements {private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:XE";
private static final String DB_USER = "system";
private static final String DB_PASSWORD = "xe";

public static void main(String[] args) throws Exception {

	
    Class.forName(DB_DRIVER);
	
	Connection dbConnection = DriverManager.getConnection(
			DB_CONNECTION, DB_USER,DB_PASSWORD);
	
	
	PreparedStatement pstmt = dbConnection.prepareStatement("INSERT INTO EMPLOYEE VALUES(?,?,?)");
    pstmt.setInt(1, 208);
    pstmt.setString(2, "amar8");
    pstmt.setInt(3, 20008);
    
    pstmt.addBatch();
    
    pstmt.setInt(1, 209);
    pstmt.setString(2, "amar9");
    pstmt.setInt(3, 20009);

    pstmt.addBatch();
    
    int[] updatedRows= pstmt.executeBatch();
    
    for(int i=0; i<updatedRows.length; i++) {
    	System.out.println(updatedRows[i]);
    }
  }
}
