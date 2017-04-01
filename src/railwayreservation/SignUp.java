package railwayreservation;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.Font;

public class SignUp extends JDialog implements ActionListener {
	private JTextField passengern;
	private JTextField dob;
	private JTextField ui;
	private JPasswordField p;
	private JPasswordField cp;
	private JTextField qu;
	private JTextField an;
	JRadioButton m,f;
	JButton create,cancel;
	public SignUp() {
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.BLACK);
		
		JLabel lblNewLabel = new JLabel("Passenger Name");
		lblNewLabel.setFont(new Font("Forte", Font.PLAIN, 14));
		lblNewLabel.setForeground(new Color(220, 220, 220));
		lblNewLabel.setBounds(170, 24, 125, 23);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date Of Birth");
		lblNewLabel_1.setForeground(new Color(220, 220, 220));
		lblNewLabel_1.setFont(new Font("Forte", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(170, 89, 108, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gender");
		lblNewLabel_2.setFont(new Font("Forte", Font.PLAIN, 14));
		lblNewLabel_2.setForeground(new Color(220, 220, 220));
		lblNewLabel_2.setBounds(170, 148, 76, 20);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("UserId");
		lblNewLabel_3.setFont(new Font("Forte", Font.PLAIN, 14));
		lblNewLabel_3.setForeground(new Color(220, 220, 220));
		lblNewLabel_3.setBounds(170, 211, 61, 18);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setFont(new Font("Forte", Font.PLAIN, 14));
		lblNewLabel_4.setForeground(new Color(220, 220, 220));
		lblNewLabel_4.setBounds(170, 277, 76, 23);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Confirm Password");
		lblNewLabel_5.setFont(new Font("Forte", Font.PLAIN, 14));
		lblNewLabel_5.setForeground(new Color(255, 0, 0));
		lblNewLabel_5.setBounds(170, 349, 125, 17);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Question");
		lblNewLabel_6.setFont(new Font("Forte", Font.PLAIN, 14));
		lblNewLabel_6.setForeground(new Color(220, 220, 220));
		lblNewLabel_6.setBounds(170, 424, 76, 20);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Answer");
		lblNewLabel_7.setFont(new Font("Forte", Font.PLAIN, 14));
		lblNewLabel_7.setForeground(new Color(220, 220, 220));
		lblNewLabel_7.setBounds(170, 505, 76, 20);
		getContentPane().add(lblNewLabel_7);
		
		 create = new JButton("Create Account");
		 create.setMnemonic(KeyEvent.VK_C);
		create.setBounds(207, 636, 136, 23);
		getContentPane().add(create);
		
		 cancel = new JButton("Cancel");
		 cancel.setMnemonic(KeyEvent.VK_C);
		cancel.setBounds(423, 636, 136, 23);
		getContentPane().add(cancel);
		
		passengern = new JTextField();
		passengern.setBounds(405, 26, 86, 20);
		getContentPane().add(passengern);
		passengern.setColumns(10);
		
		dob = new JTextField();
		dob.setBounds(405, 87, 86, 20);
		getContentPane().add(dob);
		dob.setColumns(10);
		
		ui = new JTextField();
		ui.setBounds(405, 211, 86, 20);
		getContentPane().add(ui);
		ui.setColumns(10);
		
		p = new JPasswordField();
		p.setBounds(405, 279, 143, 20);
		getContentPane().add(p);
		
		cp = new JPasswordField();
		cp.setBounds(405, 347, 143, 23);
		getContentPane().add(cp);
		
		qu = new JTextField();
		qu.setBounds(405, 425, 143, 21);
		getContentPane().add(qu);
		qu.setColumns(10);
		
		an = new JTextField();
		an.setBounds(405, 505, 143, 23);
		getContentPane().add(an);
		an.setColumns(10);
		
		 m = new JRadioButton("Male");
		 m.setMnemonic(KeyEvent.VK_M);
		m.setBounds(405, 148, 86, 23);
		getContentPane().add(m);
		
		 f = new JRadioButton("Female");
		 f.setMnemonic(KeyEvent.VK_F);
		f.setBounds(537, 148, 89, 23);
		getContentPane().add(f);
		ButtonGroup bg=new ButtonGroup();
		bg.add(m);
		bg.add(f);
		create.addActionListener(this);
		cancel.addActionListener(this);
	setTitle("SignUp Form");
		setSize(800,900);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		new SignUp();
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob==cancel)
		{
			new Loginform();
			dispose();
			
		}
		else if(ob==create)
		{
			String name=passengern.getText();
			String dateob=String.valueOf(dob.getText());
			String gender="";
			if(m.isSelected())
			{
				gender="Male";
			}
			else
			{
				gender="Female";
			}
				String userid=ui.getText();
				String password=new String(p.getPassword());
				String question=qu.getText();
				String answer=an.getText();
				Boolean val = Validate(name,dateob,gender,userid,password,question,answer);
				System.out.println("validation" + val);
				if(val)
				{
				String s="insert into signup(name,dateofbirth,gender,userid,password,quest,answer)values(?,?,?,?,?,?,?)";
				Connection con=MyConnection.connect();
				try
				{
					PreparedStatement ps=con.prepareStatement(s);
					ps.setString(1, name);
					ps.setString(2,dateob);
					ps.setString(3,gender);
					ps.setString(4,userid);
					ps.setString(5, password);
					ps.setString(6, question);
					ps.setString(7, answer);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"account created");
					dispose();
				}
				catch(SQLException se)
				{
					se.printStackTrace();
				}
				new Loginform();
				dispose();
				}	
		}
		// TODO Auto-generated method stub
		
	}
	
	
	public Boolean Validate(String name, String dateob,String gender, String userid,String password,String question,String answer)
	{
		System.out.println("inside validate method");
		Boolean val=true;
		System.out.println(name);
		if(name.equalsIgnoreCase(null) ||  "".equalsIgnoreCase(name.trim()) )
		{
			val=false;
			JOptionPane.showMessageDialog(this, "ENTER NAME");
			
		}
		if(dateob.equals(null) || "".equalsIgnoreCase(dateob.trim()))
		{
			val=false;
			JOptionPane.showMessageDialog(this, "ENTER DOB");

		}
		if(gender.equals(null) ||  "".equalsIgnoreCase(gender.trim()))
		{
			val=false;
			JOptionPane.showMessageDialog(this, "ENTER GENDER");
		}
		if(userid.equals(null) ||  "".equalsIgnoreCase(userid.trim()))
		{
			val=false;
			JOptionPane.showMessageDialog(this, "ENTER USERID");
		}
		if(password.equals(null) ||  "".equalsIgnoreCase(password.trim()))
		{
			val=false;
			JOptionPane.showMessageDialog(this, "ENTER PASSWORD");
		}
		if(question.equals(null) ||  "".equalsIgnoreCase(question.trim()))
		{
			val=false;
			JOptionPane.showMessageDialog(this, "ENTER QUESTION");
		}
		if(answer.equals(null) ||  "".equalsIgnoreCase(answer.trim()))
		{
			val=false;
			JOptionPane.showMessageDialog(this, "ENTER ANSWER");
		}
		return val;
	}
	
}
