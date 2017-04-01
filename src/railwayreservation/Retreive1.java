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
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Retreive1 extends JDialog implements ActionListener{
	private JTextField ps;
	private JTextField an;
	private JTextField qe;
	private JTextField us;
	JButton btl,gp;
	String uans,pass,tans;
	public Retreive1() {
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.BLACK);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(220, 220, 220));
		lblNewLabel.setBounds(76, 51, 127, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Question");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("MV Boli", Font.BOLD, 16));
		lblNewLabel_1.setForeground(new Color(220, 220, 220));
		lblNewLabel_1.setBounds(76, 106, 110, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Answer");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("MV Boli", Font.BOLD, 16));
		lblNewLabel_2.setForeground(new Color(220, 220, 220));
		lblNewLabel_2.setBounds(76, 169, 110, 14);
		getContentPane().add(lblNewLabel_2);
		
		 gp = new JButton("Get Password");
		 gp.setMnemonic(KeyEvent.VK_G);
		gp.setBounds(174, 235, 127, 23);
		getContentPane().add(gp);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("MV Boli", Font.BOLD, 16));
		lblNewLabel_3.setForeground(new Color(220, 220, 220));
		lblNewLabel_3.setBounds(76, 311, 110, 14);
		getContentPane().add(lblNewLabel_3);
		
		 btl = new JButton("Back to Login");
		 btl.setMnemonic(KeyEvent.VK_B);
		btl.setBounds(174, 376, 127, 23);
		getContentPane().add(btl);
		
		ps = new JTextField();
		ps.setEditable(false);
		ps.setBounds(300, 310, 86, 20);
		getContentPane().add(ps);
		ps.setColumns(10);
		
		an = new JTextField();
		an.setBounds(300, 168, 86, 20);
		getContentPane().add(an);
		an.setColumns(10);
		
		qe = new JTextField();
		qe.setEditable(false);
		qe.setBounds(300, 105, 86, 20);
		getContentPane().add(qe);
		qe.setColumns(10);
		
		us = new JTextField(Loginform.user);
		us.setEditable(false);
		us.setBounds(300, 50, 86, 20);
		getContentPane().add(us);
		us.setColumns(10);
		btl.addActionListener(this);
		gp.addActionListener(this);
		fillinfo();
		setTitle("Password Retrival");
		setSize(500,500);
		setVisible(true);
	}
void fillinfo()
{
	String s="Select * from signup where userid=?";
	Connection con=MyConnection.connect();
	try
	{
		PreparedStatement ps=con.prepareStatement(s);
		ps.setString(1, Loginform.user);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			pass=rs.getString("password");
			tans=rs.getString("answer");
			qe.setText(rs.getString("quest"));
		}
	}
	catch(SQLException se)
	{
		se.printStackTrace();
	}
}
	public static void main(String[] args) {
		new Retreive1();
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob==btl)
		{
			new Loginform();
			dispose();
		}else if(ob==gp)
		{
			uans=new String(an.getText());
			if(tans.equals(uans))
			{
				ps.setText(pass);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "wrong answer");
				an.getText();
				an.requestFocusInWindow();
				
			}
		}
		// TODO Auto-generated method stub
		
	}
}
