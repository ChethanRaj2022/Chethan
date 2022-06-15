package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UnitTest {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		String ProjectName="6Pro";
		try {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		Statement stat = conn.createStatement();
		String query ="select * from mob";
		ResultSet result=stat.executeQuery(query);
		while(result.next()) {
		String actProjectName=result.getString(4);
		if(actProjectName.equals(ProjectName)) {
			System.out.println("project present");
		}
		else {
			System.out.println("project not present");
		}
		}
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			conn.close();
		}

	}

}
