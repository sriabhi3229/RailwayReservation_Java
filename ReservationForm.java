package railwayreservation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

public class ReservationForm extends JDialog implements ActionListener {
	private JTextField pn;
	private JTextField tno;
	private JTextField tna;
	private JTextField doj;
	private JTextField bd;
	JButton insert,next,main,train;
	JComboBox classname,up,low,mid;
	private JTextField nos;
	private JComboBox fr1;
	private JComboBox fr2;
	public ReservationForm() {
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.pink);
		
		JLabel lblNewLabel = new JLabel("PNR No.");
		lblNewLabel.setBounds(121, 47, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Train No.");
		lblNewLabel_1.setBounds(121, 103, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Train Name");
		lblNewLabel_2.setBounds(121, 153, 68, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Class");
		lblNewLabel_3.setBounds(121, 505, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Date of Journey");
		lblNewLabel_4.setBounds(121, 557, 79, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("From");
		lblNewLabel_5.setBounds(121, 601, 46, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Boarding at");
		lblNewLabel_6.setBounds(121, 642, 79, 14);
		getContentPane().add(lblNewLabel_6);
		
		pn = new JTextField();
		pn.setBounds(274, 44, 86, 20);
		getContentPane().add(pn);
		pn.setColumns(10);
		
		tno = new JTextField();
		tno.setBounds(274, 100, 86, 20);
		getContentPane().add(tno);
		tno.setColumns(10);
		
		tna = new JTextField();
		tna.setBounds(274, 150, 86, 20);
		getContentPane().add(tna);
		tna.setColumns(10);
		
		 classname = new JComboBox();
		 classname.setModel(new DefaultComboBoxModel(new String[] {"sleeper", "genral", "AC"}));
		classname.setBounds(274, 502, 86, 20);
		getContentPane().add(classname);
		
		doj = new JTextField();
		doj.setBounds(274, 554, 86, 20);
		getContentPane().add(doj);
		doj.setColumns(10);
		
		bd = new JTextField();
		bd.setBounds(274, 639, 86, 20);
		getContentPane().add(bd);
		bd.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("To");
		lblNewLabel_7.setBounds(397, 601, 46, 14);
		getContentPane().add(lblNewLabel_7);
		
		  insert = new JButton("Insert");
		  insert.setMnemonic('i');
		insert.setBounds(111, 696, 89, 23);
		getContentPane().add(insert);
		
		  next = new JButton("Next");
		  next.setMnemonic('n');
		next.setBounds(271, 696, 89, 23);
		getContentPane().add(next);
		
		  main = new JButton("Main");
		  main.setMnemonic('m');
		main.setBounds(431, 696, 89, 23);
		getContentPane().add(main);
		
		JLabel lblNewLabel_8 = new JLabel("Number of Seats");
		lblNewLabel_8.setBounds(115, 212, 95, 14);
		getContentPane().add(lblNewLabel_8);
		
		nos = new JTextField();
		nos.setBounds(274, 209, 86, 20);
		getContentPane().add(nos);
		nos.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("birth");
		lblNewLabel_9.setBounds(121, 284, 46, 14);
		getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Upper");
		lblNewLabel_10.setBounds(230, 284, 46, 14);
		getContentPane().add(lblNewLabel_10);
		
		 up = new JComboBox();
		 up.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		up.setBounds(282, 281, 78, 20);
		getContentPane().add(up);
		
		JLabel lblNewLabel_11 = new JLabel("Lower");
		lblNewLabel_11.setBounds(230, 358, 46, 14);
		getContentPane().add(lblNewLabel_11);
		
		 low = new JComboBox();
		 low.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		low.setBounds(282, 355, 78, 20);
		getContentPane().add(low);
		
		JLabel lblNewLabel_12 = new JLabel("Middle");
		lblNewLabel_12.setBounds(230, 428, 46, 14);
		getContentPane().add(lblNewLabel_12);
		
		mid = new JComboBox();
		mid.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		mid.setBounds(282, 425, 77, 20);
		getContentPane().add(mid);
		
		fr1 = new JComboBox();
		fr1.setModel(new DefaultComboBoxModel(new String[] {"lucknow", "kanpur", "delhi", "mumbai", "gaziabad"}));
		fr1.setBounds(274, 598, 86, 20);
		getContentPane().add(fr1);
		
		fr2 = new JComboBox();
		fr2.setModel(new DefaultComboBoxModel(new String[] {"lucknow", "kanpur", "delhi", "mumbai", "gaziabad"}));
		fr2.setBounds(431, 598, 89, 20);
		getContentPane().add(fr2);
		
		 train = new JButton("Train List");
		train.setBounds(542, 280, 89, 23);
		getContentPane().add(train);
		setModal(true);
		insert.addActionListener(this);
		next.addActionListener(this);
		main.addActionListener(this);
		train.addActionListener(this);
		setSize(900,1000);
		setModal(true);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ReservationForm();
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob==next)
		{
			new Payment();
			dispose();
		}else if(ob==main)
		{
			new HomePage1();
			dispose();
			}else if(ob==train)
			{
				dispose();
			}
		else if(ob==insert)
		{
			int pnrno=Integer.parseInt(pn.getText());
			int trainno=Integer.parseInt(tno.getText());
			String tname=tna.getText();
			String tclass=classname.getSelectedItem().toString();
			String date=String.valueOf(doj.getText());
			String source1=fr1.getSelectedItem().toString();
			String desti=fr2.getSelectedItem().toString();
			String bord=bd.getText();
			int number=Integer.parseInt(nos.getText());

			String upp=up.getSelectedItem().toString();
			int upp1=Integer.parseInt(upp);
			String loww=low.getSelectedItem().toString();
			int loww1=Integer.parseInt(loww);
			String midd=mid.getSelectedItem().toString();
			int midd1=Integer.parseInt(midd);
			
			String s="insert into reservation(epnr,etrainno,etrainname,eclass,esource,edestination,eboarding,edate,seats,upper,lower,middle)values(?,?,?,?,?,?,?,?,?,?,?,?)";
			Connection con=MyConnection.connect();
			try
			{
				PreparedStatement ps=con.prepareStatement(s);
				ps.setInt(1, pnrno);
				ps.setInt(2, trainno);
				ps.setString(3,tname);
				ps.setString(4, tclass);
				ps.setString(5,source1);
				ps.setString(6, desti);
				ps.setString(7, bord);
				ps.setString(8, date);
				ps.setInt(9, number);
				ps.setInt(10, upp1);
				ps.setInt(11, loww1);
				ps.setInt(12, midd1);
				ps.executeUpdate();
				JOptionPane.showConfirmDialog(null,"new resrvation","reservation successfull",JOptionPane.YES_NO_OPTION);
				pn.setText("");
				tno.setText("");
				tna.setText("");
				doj.setText("");
				
				bd.setText("");
				
				nos.setText("");
				pn.requestFocusInWindow();
				tno.requestFocusInWindow();
				tna.requestFocusInWindow();
				doj.requestFocusInWindow();
				fr1.requestFocusInWindow();
				bd.requestFocusInWindow();
				fr2.requestFocusInWindow();
				nos.requestFocusInWindow();
				
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			
			
		}
	
		
		// TODO Auto-generated method stub
		
	}
}
