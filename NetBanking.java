package railwayreservation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class NetBanking extends JDialog implements ActionListener {
	private JTextField accno;
	private JTextField cid;
	private JTextField am;
	private JTextField m;
	private JPasswordField p;
	JButton pay,cancel,home;
	public NetBanking() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account no.");
		lblNewLabel.setBounds(120, 85, 94, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(120, 131, 72, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Customer Id");
		lblNewLabel_2.setBounds(120, 181, 94, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ammount");
		lblNewLabel_3.setBounds(122, 235, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		accno = new JTextField();
		accno.setBounds(242, 82, 86, 20);
		getContentPane().add(accno);
		accno.setColumns(10);
		
		cid = new JTextField();
		cid.setBounds(242, 178, 86, 20);
		getContentPane().add(cid);
		cid.setColumns(10);
		
		am = new JTextField();
		am.setBounds(242, 232, 86, 20);
		getContentPane().add(am);
		am.setColumns(10);
		
		m = new JTextField();
		m.setText("Rs");
		m.setEditable(false);
		m.setBounds(221, 232, 20, 20);
		getContentPane().add(m);
		m.setColumns(10);
		
		p = new JPasswordField();
		p.setBounds(242, 128, 86, 20);
		getContentPane().add(p);
		
	 pay = new JButton("Payment");
		pay.setBounds(102, 308, 89, 23);
		getContentPane().add(pay);
		
		 cancel = new JButton("Go Back");
		cancel.setBounds(239, 308, 89, 23);
		getContentPane().add(cancel);
		
		 home = new JButton("Home");
		home.setBounds(365, 308, 89, 23);
		getContentPane().add(home);
		pay.addActionListener(this);
		cancel.addActionListener(this);
		home.addActionListener(this);
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
		{
			new Payment();
			
		}
		else if(ob==pay)
		{
			JOptionPane.showMessageDialog(null,"Payment successfull");
			accno.setText("");
			cid.setText("");
			am.setText("");
			p.setText("");
		}
		else if(ob==home)
		{
			new HomePage1();
		}
		// TODO Auto-generated method stub
		
	}
}
