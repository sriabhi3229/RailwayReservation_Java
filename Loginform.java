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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Loginform extends JDialog implements ActionListener{
	private JTextField u;
	JButton login,forgotpassword,signup,back;
	private JPasswordField P;
	static String user;
	public Loginform() {
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.pink);
		
		u = new JTextField();
		u.setBounds(227, 63, 86, 20);
		getContentPane().add(u);
		u.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setBounds(97, 69, 89, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(97, 134, 72, 14);
		getContentPane().add(lblNewLabel_1);
		
		 login = new JButton("Login");
		login.setMnemonic('l');
		login.setBounds(97, 201, 89, 23);
		getContentPane().add(login);
		
		 forgotpassword = new JButton("ForgotPassword");
		forgotpassword.setMnemonic('f');
		forgotpassword.setBounds(224, 201, 139, 23);
		getContentPane().add(forgotpassword);
		
		P = new JPasswordField();
		P.setBounds(227, 137, 86, 20);
		getContentPane().add(P);
		
		signup = new JButton("SignUp");
		signup.setBounds(274, 260, 89, 23);
		getContentPane().add(signup);
		
		 back = new JButton("Back to HomePage");
		back.setBounds(97, 260, 139, 23);
		getContentPane().add(back);
	signup.addActionListener(this);
	login.addActionListener(this);
	forgotpassword.addActionListener(this);
	back.addActionListener(this);
		setSize(500,400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Loginform();
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		 user=u.getText();
		if(ob==login)
		{
			String pass=new String(P.getPassword());
			String s="select * from signup where userid=? and password=?";
			Connection con=MyConnection.connect();
			try
			{
		PreparedStatement ps=con.prepareStatement(s);
		ps.setString(1,user);
		ps.setString(2,pass);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			new Passenger();
			dispose();
		}else
		{
			JOptionPane.showMessageDialog(null, "invalid");
			P.setText("");
			u.setText("");
			u.requestFocusInWindow();
			
		}
			
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
	}
		else if(ob==forgotpassword)
		{
			new Retreive1();
			dispose();
		}
		else if(ob==signup)
		{
			new SignUp();
		}
		else if(ob==back)
		{
			new HomePage1();
		}
		// TODO Auto-generated method stub
		
	}
}
