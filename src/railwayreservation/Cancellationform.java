package railwayreservation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



import javax.swing.JButton;
import java.awt.Font;

public class Cancellationform extends JDialog implements ActionListener {
	private JTextField pno;
	private JTextField pi;
	JButton can,bthp;
	int m,m1;

	public Cancellationform() {
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.BLACK);
		
		JLabel lblNewLabel = new JLabel("PNR No.");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(220, 220, 220));
		lblNewLabel.setBounds(78, 70, 86, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PId");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(220, 220, 220));
		lblNewLabel_1.setBounds(78, 140, 60, 14);
		getContentPane().add(lblNewLabel_1);
		
		pno = new JTextField();
		pno.setBounds(210, 67, 86, 20);
		getContentPane().add(pno);
		pno.setColumns(10);
		
		pi = new JTextField();
		pi.setBounds(210, 137, 86, 20);
		getContentPane().add(pi);
		pi.setColumns(10);
		
		 can = new JButton("Cancel");
		can.setBounds(58, 204, 121, 23);
		getContentPane().add(can);
		
		bthp = new JButton("Back to HomePage");
		bthp.setBounds(210, 204, 129, 23);
		getContentPane().add(bthp);
		can.addActionListener(this);
		bthp.addActionListener(this);
		setTitle("Cancellation Form");
		setSize(400,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Cancellationform();
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob==can)
		{
			
			 m=Integer.parseInt(pi.getText());
			if(m==0){
				JOptionPane.showMessageDialog(this, "INVALID ID");
			}else{
			new Deleteid1(m);
			}
			 m1=Integer.parseInt(pno.getText());
			if(m1==0){
				JOptionPane.showMessageDialog(this, "INVALID PNR NO.");
			}
			else{
			new Deletepnr(m1,m);}
		JOptionPane.showMessageDialog(null, "Cancel");
		pi.setText(" ");
		pno.setText(" ");
		}
		else
			if(ob==bthp)
			{ 
				new HomePage1();
				dispose();
			}
		// TODO Auto-generated method stub
		
	}

}
