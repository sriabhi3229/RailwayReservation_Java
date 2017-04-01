package railwayreservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

	
		static Connection c;
		static Connection connect()
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				c=DriverManager.getConnection("jdbc:mysql://localhost:3306/namrta","root","namrta");
				System.out.println("Connected");
				
			}
			catch(ClassNotFoundException cs)
			{
				cs.printStackTrace();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			return c;
			
		}
		
			
		
		// TODO Auto-generated method stub

	

}
