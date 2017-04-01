package railwayreservation;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

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
		getContentPane().setBackground(Color.pink);
		
		JLabel lblNewLabel = new JLabel("Passenger Name");
		lblNewLabel.setBounds(111, 24, 114, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date Of Birth");
		lblNewLabel_1.setBounds(111, 89, 78, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gender");
		lblNewLabel_2.setBounds(111, 149, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("UserId");
		lblNewLabel_3.setBounds(111, 220, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setBounds(111, 291, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Confirm Password");
		lblNewLabel_5.setBounds(111, 366, 95, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Question");
		lblNewLabel_6.setBounds(111, 437, 46, 14);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Answer");
		lblNewLabel_7.setBounds(111, 511, 46, 14);
		getContentPane().add(lblNewLabel_7);
		
		 create = new JButton("Create Account");
		create.setBounds(159, 585, 120, 23);
		getContentPane().add(create);
		
		 cancel = new JButton("Cancel");
		cancel.setBounds(362, 585, 89, 23);
		getContentPane().add(cancel);
		
		passengern = new JTextField();
		passengern.setBounds(235, 21, 86, 20);
		getContentPane().add(passengern);
		passengern.setColumns(10);
		
		dob = new JTextField();
		dob.setBounds(235, 86, 86, 20);
		getContentPane().add(dob);
		dob.setColumns(10);
		
		ui = new JTextField();
		ui.setBounds(235, 220, 86, 20);
		getContentPane().add(ui);
		ui.setColumns(10);
		
		p = new JPasswordField();
		p.setBounds(235, 288, 143, 20);
		getContentPane().add(p);
		
		cp = new JPasswordField();
		cp.setBounds(235, 366, 143, 17);
		getContentPane().add(cp);
		
		qu = new JTextField();
		qu.setBounds(235, 437, 143, 20);
		getContentPane().add(qu);
		qu.setColumns(10);
		
		an = new JTextField();
		an.setBounds(235, 508, 143, 20);
		getContentPane().add(an);
		an.setColumns(10);
		
		 m = new JRadioButton("Male");
		m.setBounds(235, 145, 109, 23);
		getContentPane().add(m);
		
		 f = new JRadioButton("Female");
		f.setBounds(406, 145, 109, 23);
		getContentPane().add(f);
		ButtonGroup bg=new ButtonGroup();
		bg.add(m);
		bg.add(f);
		create.addActionListener(this);
		cancel.addActionListener(this);
	
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
				
		}
		// TODO Auto-generated method stub
		
	}
}
