package railwayreservation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JPanel;

public class Loginform extends JDialog implements ActionListener{
	private JTextField u;
	JButton login,forgotpassword,signup,back;
	private JPasswordField P;
	static String user;
	Boolean val;
	public Loginform() {
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.BLACK);
		
		u = new JTextField();
		u.setBounds(292, 67, 86, 20);
		getContentPane().add(u);
		u.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setForeground(new Color(220, 220, 220));
		lblNewLabel.setBounds(96, 66, 127, 20);
		lblNewLabel.setFont(new Font("Sylfaen", Font.ROMAN_BASELINE, 20));
		
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(new Color(220, 220, 220));
		lblNewLabel_1.setBounds(96, 148, 110, 23);
		getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font ("Sylfaen",Font.ROMAN_BASELINE,20));
		
		 login = new JButton("Login");
		login.setMnemonic('l');
		login.setBounds(75, 229, 148, 23);
		getContentPane().add(login);
		
		 forgotpassword = new JButton("ForgotPassword");
		forgotpassword.setMnemonic('f');
		forgotpassword.setBounds(281, 229, 139, 23);
		getContentPane().add(forgotpassword);
		
		P = new JPasswordField();
		P.setBounds(292, 150, 86, 20);
		getContentPane().add(P);
		
		signup = new JButton("SignUp");
		signup.setMnemonic(KeyEvent.VK_S);
		signup.setBounds(281, 284, 135, 23);
		getContentPane().add(signup);
		
		 back = new JButton("Back to HomePage");
		 back.setMnemonic(KeyEvent.VK_B);
		back.setBounds(75, 284, 148, 23);
		getContentPane().add(back);
	signup.addActionListener(this);
	login.addActionListener(this);
	forgotpassword.addActionListener(this);
	back.addActionListener(this);
	setTitle("Login Form");
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
		
		if(ob==login){
			  val=validate(user);
		if(val){
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
		}}
		else if(ob==forgotpassword)
		{
			new Retreive1();
			dispose();
		}
		else if(ob==signup)
		{
			new SignUp();
			dispose();
		}
		else if(ob==back)
		{
			new HomePage1();
			dispose();
		}}
		// TODO Auto-generated method stub
		
	

	public Boolean validate(String user){
		 System.out.println("inside validate method");
			Boolean val=true;
			if(user.equalsIgnoreCase(null) || "".equalsIgnoreCase(user.trim())){
				val=false;
				JOptionPane.showMessageDialog(this, "ENTER VALID USERNAME");
			}
			return val;
}
}