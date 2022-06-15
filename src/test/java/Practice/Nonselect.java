package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Nonselect {

	public static void main(String[] args) throws SQLException  {
		Connection conn=null;
		int result = 0;
		try {
			//register to database
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			//connect to database
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
			 //create query
			 Statement stat = conn.createStatement();
			 String query="insert into student_info(regno,firstname,midname,lastname) values('2','anu','sha','m')";
			 //execute query
			 result = stat.executeUpdate(query);
		}
		catch(Exception e)
		{
		}
		finally {
			if(result==1)
			{
				System.out.println("added");
			}
			else
			{
				System.out.println("not added");
			}
			 
	
		conn.close();

	}

}}
