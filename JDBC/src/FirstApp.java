import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class FirstApp {

	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String DB_USER = "system";
	private static final String DB_PASSWORD = "xe";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
       
		Class.forName(DB_DRIVER);
		
		Connection dbConnection = DriverManager.getConnection(
				DB_CONNECTION, DB_USER,DB_PASSWORD);
		
		Statement statement = dbConnection.createStatement();
		
		/*ResultSet rs = statement.executeQuery("select * from employee");
		List<Employee> empList = new ArrayList<Employee>();
		Employee emp = null;
		while(rs.next()) {
			int eid = rs.getInt(1);
			String ename = rs.getString(2);
			int sal = rs.getInt(3);
					
			emp = new Employee();
			emp.setEid(eid);
			emp.setName(ename);
			emp.setSal(sal);
			
			empList.add(emp);
		}
		
		System.out.println(empList);
        */
		/*int insertedRows = statement.executeUpdate("insert into employee values(200,'amar',12000)");
		
		System.out.println(insertedRows+" rows inserted.");*/
		
		//boolean flag = statement.execute("select * from employee");
		boolean flag = statement.execute("insert into employee values(201,'amar1',20000)");
		System.out.println(flag);
		
		if(flag) {
			ResultSet rs = statement.getResultSet();
			List<Employee> empList = new ArrayList<Employee>();
			Employee emp = null;
			while(rs.next()) {
				int eid = rs.getInt(1);
				String ename = rs.getString(2);
				int sal = rs.getInt(3);
						
				emp = new Employee();
				emp.setEid(eid);
				emp.setName(ename);
				emp.setSal(sal);
				
				empList.add(emp);
			}
			
			System.out.println(empList);
		} else {
			
			int insertedRows = statement.getUpdateCount();
			
			System.out.println(insertedRows+" rows inserted.");
		}
		
	}

}
