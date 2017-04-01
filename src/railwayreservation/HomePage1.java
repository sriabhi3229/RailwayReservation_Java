package railwayreservation;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.SwingConstants;






/**
 * @author Arpita
 *
 */
/**
 * @author Arpita
 *
 */
/**
 * @author Arpita
 *
 */
public class HomePage1 extends JDialog implements ActionListener{
	JButton login,exit,passenger,reservation,cancellation,pnrenq;
	private JPanel panel_1;
	private JPanel panel,panel_3;
	private JPanel panel_2;
	private JLabel lblNewLabel_1,lable,lable1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	public HomePage1() {
		getContentPane().setLayout(null);
		
		getContentPane().setBackground(Color.black);

		
		
		
		 login = new JButton("Login Page");
		 login.setMnemonic(KeyEvent.VK_L);
		login.setBounds(240, 296, 133, 23);
		getContentPane().add(login);
		
		 passenger = new JButton(" Passenger info Form");
		 passenger.setMnemonic('p');
		passenger.setBounds(240, 357, 133, 23);
		getContentPane().add(passenger);
		
		 reservation = new JButton("Reservation form");
		 reservation.setMnemonic('r');
		reservation.setBounds(240, 422, 133, 23);
		getContentPane().add(reservation);
		
		 cancellation = new JButton("Cancellation form");
		 cancellation.setMnemonic('c');
		cancellation.setBounds(239, 551, 133, 23);
		getContentPane().add(cancellation);
		
		 pnrenq = new JButton("PNR Enquiry");
		 pnrenq.setMnemonic(KeyEvent.VK_P);
		pnrenq.setBounds(240, 485, 133, 23);
		getContentPane().add(pnrenq);
		
		exit = new JButton("Exit");
		exit.setMnemonic('e');
		exit.setBounds(240, 614, 133, 23);
		getContentPane().add(exit);
		
		panel = new JPanel();
		panel.setBounds(0, 161, 230, 500);
		panel.setBackground(UIManager.getColor("CheckBox.background"));
		ImageIcon icon=new ImageIcon(getClass().getResource("image/BRTLD.jpg"));
		
		
		
		
		lable=new JLabel();
		lable.setBackground(UIManager.getColor("TextPane.disabledBackground"));
		lable.setIcon(icon);
		panel.add(lable);
		this.getContentPane().add(panel);
		
		lblNewLabel_6 = new JLabel("@Railway");
		panel.add(lblNewLabel_6);
		panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 895, 160);
		getContentPane().add(panel_2).setBackground(Color.GRAY);
		
		
		lblNewLabel_1 = new JLabel("Railway Reservation");
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Jokerman", Font.PLAIN, 89));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBackground(Color.BLUE);
		
		lblNewLabel = new JLabel("Welcome to Railways..");
		lblNewLabel.setFont(new Font("Goudy Stout", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(239, 173, 408, 14);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("Have a smooth working with all the ");
		lblNewLabel_2.setFont(new Font("Goudy Stout", Font.PLAIN, 14));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(240, 198, 655, 14);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Necessary Links...");
		lblNewLabel_3.setFont(new Font("Goudy Stout", Font.PLAIN, 14));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(240, 223, 327, 14);
		getContentPane().add(lblNewLabel_3);
		
		 panel_3 = new JPanel();
		panel_3.setBounds(383, 300, 501, 361);
		panel_3.setBackground(Color.BLACK);

		ImageIcon icon1=new ImageIcon(getClass().getResource("image/hqdefault.jpg"));
	
 lable1 = new JLabel();
 lable1.setVerticalAlignment(SwingConstants.BOTTOM);
 lable1.setHorizontalAlignment(SwingConstants.CENTER);
 lable1.setForeground(Color.BLACK);
 lable1.setBackground(Color.WHITE);
		lable1.setIcon(icon1);
	panel_3.add(lable1);
		this.getContentPane().add(panel_3);
		

		

		login.addActionListener(this);
		passenger.addActionListener(this);
		cancellation.addActionListener(this);
		reservation.addActionListener(this);
		pnrenq.addActionListener(this);
		exit.addActionListener(this);
		setTitle("Railway reservation");
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
