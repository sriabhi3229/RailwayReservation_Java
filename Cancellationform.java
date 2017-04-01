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

public class Cancellationform extends JDialog implements ActionListener {
	private JTextField pno;
	private JTextField pi;
	JButton can,bthp;

	public Cancellationform() {
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.pink);
		
		JLabel lblNewLabel = new JLabel("PNR No.");
		lblNewLabel.setBounds(58, 70, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PId");
		lblNewLabel_1.setBounds(58, 140, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		pno = new JTextField();
		pno.setBounds(151, 67, 86, 20);
		getContentPane().add(pno);
		pno.setColumns(10);
		
		pi = new JTextField();
		pi.setBounds(151, 137, 86, 20);
		getContentPane().add(pi);
		pi.setColumns(10);
		
		 can = new JButton("Cancel");
		can.setBounds(72, 204, 89, 23);
		getContentPane().add(can);
		
		bthp = new JButton("Back to HomePage");
		bthp.setBounds(227, 204, 121, 23);
		getContentPane().add(bthp);
		can.addActionListener(this);
		bthp.addActionListener(this);
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
			
			int m=Integer.parseInt(pi.getText());
			new Deleteid1(m);
			
			int m1=Integer.parseInt(pno.getText());
			new Deletepnr(m1);
			
		JOptionPane.showMessageDialog(null, "Cancel");
		
		dispose();
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
