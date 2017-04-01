package railwayreservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Deletepnr {

	public Deletepnr(int pno,int pi)
	{
		String s="Delete from reservation where epnr=?";
		Connection con=MyConnection.connect();
		try
		{
			PreparedStatement ps=con.prepareStatement(s);
			ps.setInt(1, pno);
			
			ps.executeUpdate();
			
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		System.out.println("deleted");
		
		String s1="Delete from pnrenquiry where epnrno=?";
		Connection con2=MyConnection.connect();
		try
		{
			PreparedStatement ps2=con2.prepareStatement(s1);
			ps2.setInt(1, pno);
			
			ps2.executeUpdate();
			
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}

}
