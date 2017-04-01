package railwayreservation;

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

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Payment extends JDialog implements ActionListener {
	JButton cancel,proceed,getval,get;
	JRadioButton nb,cd;
	private JTextField amount;
	private JLabel lblNewLabel_2;
	private JTextField num;
	private JTextField id;
	String piid;
	private JTextField name;
	public Payment() {
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.BLACK);
		
		JLabel lblNewLabel = new JLabel("Payment type");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(230, 230, 250));
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 22));
		lblNewLabel.setBounds(148, 0, 185, 50);
		getContentPane().add(lblNewLabel);
		
		 proceed = new JButton("Proceed");
		 proceed.setMnemonic(KeyEvent.VK_P);
		proceed.setBounds(125, 488, 89, 23);
		getContentPane().add(proceed);
		
		 cancel = new JButton("Cancel");
		 cancel.setMnemonic(KeyEvent.VK_C);
		cancel.setBounds(385, 488, 89, 23);
		getContentPane().add(cancel);
		
		 cd = new JRadioButton("Credit Card");
		 cd.setMnemonic(KeyEvent.VK_C);
		cd.setBounds(253, 377, 109, 23);
		getContentPane().add(cd);
		
		nb = new JRadioButton("Net Banking");
		nb.setMnemonic(KeyEvent.VK_N);;
		nb.setBounds(253, 428, 109, 23);
		getContentPane().add(nb);
		ButtonGroup bg=new ButtonGroup();
		bg.add(nb);
		bg.add(cd);
		
		JLabel lblNewLabel_1 = new JLabel("Total Amount");
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 19));
		lblNewLabel_1.setForeground(new Color(220, 220, 220));
		lblNewLabel_1.setBounds(109, 295, 132, 34);
		getContentPane().add(lblNewLabel_1);
		
		amount = new JTextField();
		amount.setEditable(false);
		amount.setBounds(276, 306, 86, 20);
		getContentPane().add(amount);
		amount.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Total Seats");
		lblNewLabel_2.setFont(new Font("Serif", Font.BOLD, 19));
		lblNewLabel_2.setForeground(new Color(220, 220, 220));
		lblNewLabel_2.setBounds(109, 233, 132, 20);
		getContentPane().add(lblNewLabel_2);
		
		num = new JTextField();
		num.setEditable(false);
		num.setBounds(276, 237, 86, 20);
		getContentPane().add(num);
		num.setColumns(10);
		
		id = new JTextField();
		id.setEditable(false);
		id.setFont(new Font("Tahoma", Font.BOLD, 13));
		id.setForeground(Color.BLACK);
		id.setBounds(276, 138, 86, 20);
		getContentPane().add(id);
		id.setColumns(10);
		
		 getval = new JButton("INFO");
		getval.setBounds(197, 169, 89, 23);
		getContentPane().add(getval);
		
		JLabel lblPid = new JLabel("PID");
		lblPid.setFont(new Font("Serif", Font.BOLD, 19));
		lblPid.setForeground(new Color(220, 220, 220));
		lblPid.setBounds(109, 130, 46, 28);
		getContentPane().add(lblPid);
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(109, 64, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		name = new JTextField();
		name.setBounds(276, 61, 86, 20);
		getContentPane().add(name);
		name.setColumns(10);
		
		 get = new JButton("Get Id");
		get.setBounds(197, 104, 89, 23);
		getContentPane().add(get);
		proceed.addActionListener(this);
		cancel.addActionListener(this);
		getval.addActionListener(this);
		get.addActionListener(this);
	setTitle("Payment");
		setSize(600,600);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		new Payment();
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob==get){
			String nopp=name.getText();
			 System.out.println(nopp);
	
				String s="select pid from passenger where pname=?";
				Connection con=MyConnection.connect();
				try
				{
			PreparedStatement ps=con.prepareStatement(s);
			ps.setString(1,nopp);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				id.setText(rs.getString("pid"));
			}}
				catch(SQLException se)
				{
					se.printStackTrace();
				}
				
				System.out.println("id is set");
		}
		
		if(ob==getval){
		piid=id.getText();
		String s="Select seats,total_cost from reservation where pid=?";
		Connection con=MyConnection.connect();
		try
		{
			PreparedStatement ps=con.prepareStatement(s);
	ps.setString(1, piid);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			num.setText(rs.getString("seats"));
			amount.setText(rs.getString("total_cost"));
		}}
		catch(SQLException se)
	{
		se.printStackTrace();
	}}
	String number=num.getText();
	System.out.println(number);
	System.out.println(amount);
		
		if(ob==proceed)
		{
			if(cd.isSelected())
			{
				dispose();
				new CreditC();		
			}
			else
				if(nb.isSelected()){
					dispose();
					new NetBanking();
				}
		} else if(ob==cancel)
		{
			new HomePage1();
			dispose();
		}
		// TODO Auto-generated method stub
		
	}
}
