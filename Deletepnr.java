package railwayreservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Deletepnr {

	public Deletepnr(int pno)
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
	}

}
