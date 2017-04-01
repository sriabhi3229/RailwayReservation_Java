package railwayreservation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CreditC extends JDialog implements ActionListener {
	private JTextField crdno;
	private JTextField exd;
	private JTextField civ;
	private JTextField n;
	JButton cancel,payment;
	public CreditC() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Card No.");
		lblNewLabel.setBounds(94, 59, 58, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Expiry Date");
		lblNewLabel_1.setBounds(94, 122, 84, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CIV No.");
		lblNewLabel_2.setBounds(94, 183, 58, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Name On The Card");
		lblNewLabel_3.setBounds(94, 250, 112, 14);
		getContentPane().add(lblNewLabel_3);
		
		crdno = new JTextField();
		crdno.setBounds(208, 56, 86, 20);
		getContentPane().add(crdno);
		crdno.setColumns(10);
		
		exd = new JTextField();
		exd.setBounds(208, 119, 86, 20);
		getContentPane().add(exd);
		exd.setColumns(10);
		
		civ = new JTextField();
		civ.setBounds(208, 180, 86, 20);
		getContentPane().add(civ);
		civ.setColumns(10);
		
		n = new JTextField();
		n.setBounds(208, 247, 86, 20);
		getContentPane().add(n);
		n.setColumns(10);
		
		 payment = new JButton("Make Payment");
		payment.setBounds(73, 306, 133, 23);
		getContentPane().add(payment);
		
		 cancel = new JButton("Go Back");
		cancel.setBounds(266, 306, 125, 23);
		getContentPane().add(cancel);
		cancel.addActionListener(this);
		payment.addActionListener(this);
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
		{
			new Payment();
			dispose();
		} else if(ob==payment)
		{
			JOptionPane.showMessageDialog(null, "payment successfull");
			crdno.setText("");
			exd.setText("");
			civ.setText("");
			n.setText("");
			
			
			
		}
		// TODO Auto-generated method stub
		
	}
}
