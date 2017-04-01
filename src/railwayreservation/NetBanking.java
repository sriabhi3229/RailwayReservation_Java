package railwayreservation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class NetBanking extends JDialog implements ActionListener {
	private JTextField accno;
	private JTextField cid;
	private JTextField am;
	private JTextField m;
	private JPasswordField p;
	JButton pay,cancel,home;

	public NetBanking() {
	
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.BLACK);
		
		JLabel lblNewLabel = new JLabel("Account no.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(220, 220, 220));
		lblNewLabel.setBounds(84, 42, 139, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(new Color(220, 220, 220));
		lblNewLabel_1.setBounds(102, 108, 121, 20);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Customer Id");
		lblNewLabel_2.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 18));
		lblNewLabel_2.setForeground(new Color(220, 220, 220));
		lblNewLabel_2.setBounds(102, 178, 121, 20);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ammount");
		lblNewLabel_3.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 18));
		lblNewLabel_3.setForeground(new Color(220, 220, 220));
		lblNewLabel_3.setBounds(102, 244, 105, 17);
		getContentPane().add(lblNewLabel_3);
		
		accno = new JTextField();
		accno.setBounds(303, 39, 86, 20);
		getContentPane().add(accno);
		accno.setColumns(10);
		
		cid = new JTextField();
		cid.setBounds(303, 178, 86, 20);
		getContentPane().add(cid);
		cid.setColumns(10);
		
		am = new JTextField();
		am.setBounds(319, 242, 86, 20);
		getContentPane().add(am);
		am.setColumns(10);
		
		m = new JTextField();
		m.setFont(new Font("Tahoma", Font.BOLD, 11));
		m.setText("Rs");
		m.setEditable(false);
		m.setBounds(303, 242, 28, 20);
		getContentPane().add(m);
		m.setColumns(10);
		
		p = new JPasswordField();
		p.setBounds(303, 108, 86, 20);
		getContentPane().add(p);
		
	 pay = new JButton("Payment");
	 pay.setMnemonic(KeyEvent.VK_P);
		pay.setBounds(57, 308, 89, 23);
		getContentPane().add(pay);
		
		 cancel = new JButton("Go Back");
		 cancel.setMnemonic(KeyEvent.VK_G);
		cancel.setBounds(205, 308, 89, 23);
		getContentPane().add(cancel);
		
		 home = new JButton("Home");
		 home.setMnemonic(KeyEvent.VK_H);
		home.setBounds(343, 308, 89, 23);
		getContentPane().add(home);
		pay.addActionListener(this);
		cancel.addActionListener(this);
		home.addActionListener(this);
setTitle("Net Banking");
		setSize(500,400);
		setVisible(true);
	}

	public static void main(String[] args) {
		

new NetBanking();

		
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob==cancel)
		{dispose();
			new HomePage1();
			
		}
		else if(ob==pay)
		{
			String account=accno.getText();
			String customer=cid.getText();
			String amount=am.getText();
			String password=p.getText();
			Boolean val=validate(account,customer,amount,password);
			if(val){
			JOptionPane.showMessageDialog(null,"Payment successfull");
			accno.setText("");
			cid.setText("");
			am.setText("");
			p.setText("");
		}}
		else if(ob==home)
		{
			new HomePage1();
		}
		// TODO Auto-generated method stub
		
	}
	public Boolean validate(String account,String customer,String amount,String password){
		Boolean val=true;
		System.out.println(account);
		if(account.equalsIgnoreCase(null) || "".equalsIgnoreCase(account.trim())){
			val=false;
			JOptionPane.showMessageDialog(this, "ENTER ACCOUNT NO.");
		}
		if(customer.equalsIgnoreCase(null) || "".equalsIgnoreCase(customer.trim())){
			val=false;
			JOptionPane.showMessageDialog(this, "ENTER CUSTOMER ID.");
		}
		if(amount.equalsIgnoreCase(null) || "".equalsIgnoreCase(amount.trim())){
			val=false;
			JOptionPane.showMessageDialog(this, "ENTER AMOUNT");
		}
		if(password.equalsIgnoreCase(null) || "".equalsIgnoreCase(password.trim())){
			val=false;
			JOptionPane.showMessageDialog(this, "ENTER VALID PASSWORD");
		}
		return val;
	}
}
