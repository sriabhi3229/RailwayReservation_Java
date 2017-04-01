package railwayreservation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.print.attribute.standard.PDLOverrideSupported;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JEditorPane;
import java.awt.Font;

public class PNREnquiry extends JDialog implements ActionListener {
	private JTextField pn;
	JButton check,back;
	String seat,waiting,pname,date,source,destination;
	JEditorPane pd;
	int pnr,pd1;
	String pnr1,name1,source1,dest1,date1,seats="confirmed ",waits="no";
	public PNREnquiry() {
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.BLACK);
		
		JLabel lblNewLabel = new JLabel("PNR No.");
		lblNewLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 16));
		lblNewLabel.setForeground(new Color(220, 220, 220));
		lblNewLabel.setBounds(113, 49, 89, 17);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PNR Details");
		lblNewLabel_1.setFont(new Font("Showcard Gothic", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(new Color(220, 220, 220));
		lblNewLabel_1.setBounds(113, 113, 113, 23);
		getContentPane().add(lblNewLabel_1);
		
		 check = new JButton("Check");
		 check.setMnemonic(KeyEvent.VK_C);
		check.setBounds(113, 298, 89, 23);
		getContentPane().add(check);
		
		 back = new JButton("Back");
		 back.setMnemonic(KeyEvent.VK_B);
		back.setBounds(281, 298, 89, 23);
		getContentPane().add(back);
		
		pn = new JTextField();
		pn.setBounds(269, 48, 86, 20);
		getContentPane().add(pn);
		pn.setColumns(10);
		
		pd = new JEditorPane();
		pd.setBounds(269, 112, 171, 144);
		getContentPane().add(pd);
		check.addActionListener(this);
		back.addActionListener(this);
		setTitle("PNR Enquiry");
		setSize(500,400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new PNREnquiry();
		
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		
		if(ob==back)
		{
			new HomePage1();
			dispose();
		}
		
		else if(ob==check)
		{
			
			
			
			pnr=Integer.parseInt(pn.getText());
			 
			
			String s1="Select esource,edestination,edate,pid from reservation where epnr=?";
			Connection con1=MyConnection.connect();
			try{
				
				
				PreparedStatement ps1=con1.prepareStatement(s1);
				ps1.setInt(1,pnr);
				 ResultSet rs1=ps1.executeQuery();
				 while(rs1.next()){
					  source1=rs1.getString("esource");
					  dest1=rs1.getString("edestination");
					  date1=String.valueOf(rs1.getString("edate"));
					  pd1=rs1.getInt("pid");
				 }
				 System.out.println(pd1);
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			
			
		String s2="select pname from passenger where pid=?";
			Connection con2=MyConnection.connect();
			try{
				PreparedStatement ps2=con2.prepareStatement(s2);
				ps2.setInt(1,pd1);
				ResultSet rs2=ps2.executeQuery();
				while(rs2.next()){
				 name1=rs2.getString("pname");
				}
				System.out.println(name1);
				
				
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			
			
			String s3="insert into pnrenquiry(epnrno,passname,seatcon,wait,esource,edsti,doj)values(?,?,?,?,?,?,?)";
			Connection con3=MyConnection.connect();
			try{
				PreparedStatement ps3=con3.prepareStatement(s3);
				ps3.setInt(1, pnr);
				ps3.setString(2, name1);
				ps3.setString(3, seats);
				ps3.setString(4, waits);
				ps3.setString(5, source1);
				ps3.setString(6, dest1);
				ps3.setString(7, date1);
				ps3.executeUpdate();
			}
		
		
		catch(SQLException se){
				se.printStackTrace();
			}
			System.out.println("inserted successfully");
			
			
		String s="select * from pnrenquiry where epnrno=?";
		Connection con=MyConnection.connect();
		try
		{
			PreparedStatement ps=con.prepareStatement(s);
			ps.setInt(1,pnr );
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				pname=rs.getString("passname");
				seat=rs.getString("seatcon");
				waiting=rs.getString("wait");
				source=rs.getString("esource");
				destination=rs.getString("edsti");
				date= String.valueOf(rs.getString("doj"));
				String msg = "name :" + pname + "\n" + "Confirmation :" + seat + "\n" +"waiting :" + waiting + "\n" +"source :" + source + "\n" +"destination :" + destination + "\n" +"Date Of Journey :" + date;
				pd.setText(msg);
			}
		}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
	}
}
