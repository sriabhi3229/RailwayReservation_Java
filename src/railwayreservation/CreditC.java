package railwayreservation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class CreditC extends JDialog implements ActionListener {
	private JTextField crdno;
	private JTextField exd;
	private JTextField civ;
	private JTextField n;
	JButton cancel,payment;
	public CreditC() {
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.BLACK);
		
		JLabel lblNewLabel = new JLabel("Card No.");
		lblNewLabel.setFont(new Font("Segoe Script", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(220, 220, 220));
		lblNewLabel.setBounds(117, 56, 89, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Expiry Date");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe Script", Font.BOLD, 18));
		lblNewLabel_1.setForeground(new Color(220, 220, 220));
		lblNewLabel_1.setBounds(106, 117, 133, 23);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CIV No.");
		lblNewLabel_2.setFont(new Font("Segoe Script", Font.BOLD, 18));
		lblNewLabel_2.setForeground(new Color(220, 220, 220));
		lblNewLabel_2.setBounds(115, 181, 112, 17);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Name On The Card");
		lblNewLabel_3.setFont(new Font("Segoe Script", Font.BOLD, 18));
		lblNewLabel_3.setForeground(new Color(220, 220, 220));
		lblNewLabel_3.setBounds(60, 248, 217, 16);
		getContentPane().add(lblNewLabel_3);
		
		crdno = new JTextField();
		crdno.setBounds(287, 56, 86, 20);
		getContentPane().add(crdno);
		crdno.setColumns(10);
		
		exd = new JTextField();
		exd.setBounds(287, 119, 86, 20);
		getContentPane().add(exd);
		exd.setColumns(10);
		
		civ = new JTextField();
		civ.setBounds(287, 180, 86, 20);
		getContentPane().add(civ);
		civ.setColumns(10);
		
		n = new JTextField();
		n.setBounds(287, 247, 86, 20);
		getContentPane().add(n);
		n.setColumns(10);
		
		 payment = new JButton("Make Payment");
		payment.setBounds(73, 306, 133, 23);
		getContentPane().add(payment);
		
		 cancel = new JButton("Go Back");
		cancel.setBounds(292, 306, 125, 23);
		getContentPane().add(cancel);
		cancel.addActionListener(this);
		payment.addActionListener(this);
		setTitle("Credit Card Payment");
		setSize(500,400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new CreditC();
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob==cancel)
		{dispose();
			new HomePage1();
			
		} else if(ob==payment)
		{
			String number=crdno.getText();
			String expiry=exd.getText();
			String civnum=civ.getText();
			String name=n.getText();
			Boolean val=validate(number,expiry,civnum,name);
			if(val){
			JOptionPane.showMessageDialog(null, "payment successfull");
			crdno.setText("");
			exd.setText("");
			civ.setText("");
			n.setText("");
			
			
			
		}}
		// TODO Auto-generated method stub
		
	}
	public Boolean validate(String number,String expiry,String civnum,String name){
		Boolean val=true;
		System.out.print(number);
		if(number.equalsIgnoreCase(null) || "".equalsIgnoreCase(number.trim())){
			val=false;
			JOptionPane.showMessageDialog(this, "ENTER CARD NUMBER");
		}
		if(expiry.equalsIgnoreCase(null) || "".equalsIgnoreCase(expiry.trim())){
			val=false;
			JOptionPane.showMessageDialog(this, "ENTER EXPIRY DATE");
		}
		if(civnum.equalsIgnoreCase(null) || "".equalsIgnoreCase(civnum.trim())){
			val=false;
			JOptionPane.showMessageDialog(this, "ENTER CIV NUMBER");
		}
		if(name.equalsIgnoreCase(null) || "".equalsIgnoreCase(name.trim())){
			val=false;
			JOptionPane.showMessageDialog(this, "ENTER NAME");
		}
		return val;
	}
}
