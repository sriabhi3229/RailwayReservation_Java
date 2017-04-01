package railwayreservation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;






public class HomePage1 extends JDialog implements ActionListener{
	JButton login,exit,passenger,reservation,cancellation,pnrenq;
	public HomePage1() {
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.pink);
		JLabel lblNewLabel = new JLabel("RAILWAY RESERVATION");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(208, 119, 450, 86);
		getContentPane().add(lblNewLabel);
		
		 login = new JButton("Login Page");
		 login.setMnemonic('l');
		login.setBounds(208, 296, 115, 23);
		getContentPane().add(login);
		
		 passenger = new JButton(" Passenger info Form");
		 passenger.setMnemonic('p');
		passenger.setBounds(493, 296, 133, 23);
		getContentPane().add(passenger);
		
		 reservation = new JButton("Reservation form");
		 reservation.setMnemonic('r');
		reservation.setBounds(153, 437, 115, 23);
		getContentPane().add(reservation);
		
		 cancellation = new JButton("Cancellation form");
		 cancellation.setMnemonic('c');
		cancellation.setBounds(582, 437, 133, 23);
		getContentPane().add(cancellation);
		
		 pnrenq = new JButton("PNR Enquiry");
		 pnrenq.setMnemonic('z');
		pnrenq.setBounds(377, 437, 107, 23);
		getContentPane().add(pnrenq);
		
		exit = new JButton("Exit");
		exit.setMnemonic('e');
		exit.setBounds(381, 574, 103, 23);
		getContentPane().add(exit);
		login.addActionListener(this);
		passenger.addActionListener(this);
		cancellation.addActionListener(this);
		reservation.addActionListener(this);
		pnrenq.addActionListener(this);
		exit.addActionListener(this);
		setSize(900,700);
		setVisible(true);
	}
	
	

	public static void main(String[] args) {
		new HomePage1();
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob==login)
		{
			new Loginform();
			dispose();
		}
		else if(ob==passenger)
		{
			new Passenger();
			dispose();
		}
		else if(ob==reservation)
		{
			new ReservationForm();
			dispose();
		}
		else
			if(ob==pnrenq)
			{
				new PNREnquiry();
				dispose();
			}
			else if(ob==cancellation)
			{
				new Cancellationform();
				dispose();
			}else if(ob==exit)
			{
				int yn=JOptionPane.showConfirmDialog(null,"sure to Exit","Swings",JOptionPane.YES_NO_OPTION);
				if(yn==0)
				{
					System.exit(0);
				}
			}
		// TODO Auto-generated method stub
		
	}

}
