package railwayreservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Deleteid1 {
public Deleteid1(int id)
{
String s="Delete from reservation where pid=?";
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
String s1="Delete from passenger where pid=?";
Connection con1=MyConnection.connect();
try{
	PreparedStatement ps1=con1.prepareStatement(s1);
	ps1.setInt(1, id);
	ps1.executeUpdate();
}
catch(SQLException se){
	se.printStackTrace();
}
String s2="Delete from namelist where pid=?";
Connection con2=MyConnection.connect();
try{
	PreparedStatement ps2=con2.prepareStatement(s2);
	ps2.setInt(1, id);
	ps2.executeUpdate();
}
catch(SQLException se){
	se.printStackTrace();
}
}
}
