package railwayreservation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class PNREnquiry extends JDialog implements ActionListener {
	private JTextField pn;
	JButton check,back;
	String seat,waiting,pname,date,source,destination;
	JEditorPane pd;
	int pnr;
	public PNREnquiry() {
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.pink);
		
		JLabel lblNewLabel = new JLabel("PNR No.");
		lblNewLabel.setBounds(137, 49, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PNR Details");
		lblNewLabel_1.setBounds(137, 112, 89, 14);
		getContentPane().add(lblNewLabel_1);
		
		 check = new JButton("Check");
		check.setBounds(113, 298, 89, 23);
		getContentPane().add(check);
		
		 back = new JButton("Back");
		back.setBounds(281, 298, 89, 23);
		getContentPane().add(back);
		
		pn = new JTextField();
		pn.setBounds(261, 46, 86, 20);
		getContentPane().add(pn);
		pn.setColumns(10);
		
		pd = new JEditorPane();
		pd.setBounds(221, 112, 171, 144);
		getContentPane().add(pd);
		check.addActionListener(this);
		back.addActionListener(this);
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
				String msg = pname + "\n" + seat + "\n" + waiting + "\n" + source + "\n" + destination + "\n" + date;
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
