package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Nonselectpractise {

	public static void main(String[] args) throws SQLException {
		Connection conn1=null;
		int result=0;
		try {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		conn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		Statement stat = conn1.createStatement();
		String query = "insert into mob(Numb,Brand,Color,Model) values('100','MI','Blue','6Pro')";
		result=stat.executeUpdate(query);
		}
	catch(Exception e)
	{
	}
	finally{
		
		if(result==1)
		{
			System.out.println("added");
		}
		else
		{
			System.out.println("not added");
		}
		
conn1.close();
	}
	}
}
