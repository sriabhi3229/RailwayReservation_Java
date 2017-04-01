package railwayreservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Deleteid1 {
public Deleteid1(int id)
{
String s="Delete from passenger	 where pid=?";
Connection con=MyConnection.connect();
try
{
	PreparedStatement ps=con.prepareStatement(s);
	ps.setInt(1, id);
	ps.executeUpdate();

}
catch(SQLException se)
{
	se.printStackTrace();
}
}
}
