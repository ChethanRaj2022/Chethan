package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class SelectQu {

	public static void main(String[] args) throws Throwable {
	
		Connection conn=null;
		try {
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			conn=DriverManager.getConnection("jdbc:mysql://loclahost:3306/students", "root", "root");
			Statement stat = conn.createStatement();
			String query="select * from student_info";
			ResultSet resultset=stat.executeQuery(query);
			while(resultset.next()) {
				System.out.println(resultset.getInt(1));
			}
			
		}
		catch(Exception e)
		{
			
		}
		finally {
			conn.close();
		}

	}

}
