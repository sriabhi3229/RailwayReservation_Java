package railwayreservation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class Payment extends JDialog implements ActionListener {
	JButton cancel,proceed;
	JRadioButton nb,cd;
	public Payment() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Payment type");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(81, 41, 185, 28);
		getContentPane().add(lblNewLabel);
		
		 proceed = new JButton("Proceed");
		proceed.setBounds(33, 204, 89, 23);
		getContentPane().add(proceed);
		
		 cancel = new JButton("Cancel");
		cancel.setBounds(164, 204, 89, 23);
		getContentPane().add(cancel);
		
		 cd = new JRadioButton("Credit Card");
		cd.setBounds(77, 103, 109, 23);
		getContentPane().add(cd);
		
		nb = new JRadioButton("Net Banking");
		nb.setBounds(77, 152, 109, 23);
		getContentPane().add(nb);
		ButtonGroup bg=new ButtonGroup();
		bg.add(nb);
		bg.add(cd);
		proceed.addActionListener(this);
		cancel.addActionListener(this);
		setSize(300,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Payment();
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob==proceed)
		{
			if(cd.isSelected())
			{
				new CreditC();
				dispose();
			}
		} else if(ob==cancel)
		{
			new ReservationForm();
			dispose();
		}
		// TODO Auto-generated method stub
		
	}
}
