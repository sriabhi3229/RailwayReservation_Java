package railwayreservation;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.border.LineBorder;



import java.awt.Color;
import java.awt.Dialog;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JList;
import javax.swing.JScrollPane;

public class TrainChart extends JDialog  {
	
	private JTable table;
	int e=10;
	public TrainChart() {
		
		getContentPane().setLayout(null);

		String s="select * from train_list";
		int cnt=0,r=0,c=0;
		String columns[]={"train_id","train_name","arrival_time","departure_time","source","destination"};
		Connection con=MyConnection.connect();
		try
		{
			PreparedStatement ps=con.prepareStatement(s);

			ResultSet rs=ps.executeQuery();
			rs.last();
			cnt=rs.getRow();
			rs.beforeFirst();
			String data[][]=new String[cnt][7];
			while(rs.next())
			{
				data[r][c]=rs.getString("train_id");
				++c;
				data[r][c]=rs.getString("train_name");
				++c;
						data[r][c]=rs.getString("arrival_time");
						++c;
								data[r][c]=rs.getString("departure_time");
								++c;
										data[r][c]=rs.getString("source");
										++c;
												data[r][c]=rs.getString("destination");
												++c;
			r++;
			c=0;
			}
		
		JTable jt=new JTable(data,columns);
		JScrollPane jsp=new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
jt.setAutoResizeMode(jt.AUTO_RESIZE_OFF);
setSize(400,400);
setLayout(null);
setModal(true);
setTitle("Train Chart");
jsp.setBounds(0,0,400,360);
add(jsp);
		setModal(true);
		setVisible(true);
	}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new TrainChart();
		// TODO Auto-generated method stub

	}

}
