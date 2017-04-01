package railwayreservation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Passenger extends JDialog implements ActionListener {
	private JTextField ag;
	private JTextField np;
	private JTextField pi;
	ButtonGroup  bg;
	JRadioButton gf,gm;
	JButton more,save,back;
	JTextPane ad;
	int id;
	JRadioButton gen,exs,sc;
	
	public Passenger() {
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.pink);
		JLabel lblNewLabel = new JLabel("PId");
		lblNewLabel.setBounds(155, 58, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name Of Passenger");
		lblNewLabel_1.setBounds(155, 131, 97, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Age");
		lblNewLabel_2.setBounds(155, 199, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setBounds(454, 199, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setBounds(155, 287, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Category");
		lblNewLabel_5.setBounds(155, 466, 46, 14);
		getContentPane().add(lblNewLabel_5);
		
		more = new JButton("More");
		more.setMnemonic('m');
		more.setBounds(155, 649, 89, 23);
		getContentPane().add(more);
		
		 save = new JButton("Save");
		 save.setMnemonic('s');
		save.setBounds(309, 649, 89, 23);
		getContentPane().add(save);
		
		 back = new JButton("Back");
		 back.setMnemonic('b');
		back.setBounds(464, 649, 89, 23);
		getContentPane().add(back);
		
		 ad = new JTextPane();
		ad.setBounds(297, 287, 208, 125);
		getContentPane().add(ad);
		
		ag = new JTextField();
		ag.setBounds(297, 196, 86, 20);
		getContentPane().add(ag);
		ag.setColumns(10);
		
		 gm = new JRadioButton("Male");
		gm.setBounds(546, 195, 109, 23);
		getContentPane().add(gm);
		
		 gf = new JRadioButton("Female");
		gf.setBounds(546, 244, 109, 23);
		getContentPane().add(gf);
		
		np = new JTextField();
		np.setBounds(300, 128, 86, 20);
		getContentPane().add(np);
		np.setColumns(10);
		
		pi = new JTextField();
		pi.setEditable(false);
		pi.setBounds(297, 55, 86, 20);
		getContentPane().add(pi);
		pi.setColumns(10);
		
		 gen = new JRadioButton("General");
		gen.setBounds(300, 462, 109, 23);
		getContentPane().add(gen);
		
		 sc = new JRadioButton("Senior Citizen");
		sc.setBounds(300, 506, 109, 23);
		getContentPane().add(sc);
		
		 exs = new JRadioButton("Ex-Serviceman");
		exs.setBounds(300, 554, 109, 23);
		getContentPane().add(exs);
		setModal(true);
		bg=new ButtonGroup();
		bg.add(gm);
		bg.add(gf);
		ButtonGroup bi=new ButtonGroup();
		bi.add(gen);
		bi.add(exs);
		bi.add(sc);
	more.addActionListener(this);
		save.addActionListener(this);
		back.addActionListener(this);
	getid();
		setSize(800,900);
		setVisible(true);
	}
void getid()
{
	String s="select max(pid) from passenger";
	
Connection con=MyConnection.connect();

try
{
PreparedStatement ps=con.prepareStatement(s);
ResultSet rs=ps.executeQuery();
while(rs.next())
{
id=rs.getInt(1);
 }
}
catch(SQLException se)
{
		se.printStackTrace();
}
++id;
pi.setText(String.valueOf(id));
}

	public static void main(String[] args) {
		new Passenger();
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob==more)
		{
			new ReservationForm();
			dispose();
		}
		else if(ob==back)
		{
			new HomePage1();
			dispose();
		}
		else if(ob==save)
		{
			String name=np.getText();
			int age=Integer.parseInt(ag.getText());
			String gender="";
			if(gm.isSelected())
			{
				gender="Male";
			}
			else 
			{
				gender="Female";
			}
			String address=ad.getText();
		String Category="";
			if(gen.isSelected())
			{
				Category="General";
			}else if(sc.isSelected())
			{
				Category="Senior Citizen";
			}else if(exs.isSelected())
			{
				Category="Ex-Serviceman";
			}
			String s="insert into passenger(pid,pname,page,pgender,paddress,pcategory)values(?,?,?,?,?,?)";
			Connection con=MyConnection.connect();
			try
			{
				PreparedStatement ps=con.prepareStatement(s);
				ps.setInt(1,id);
				ps.setString(2, name);
				ps.setInt(3, age);
				ps.setString(4,gender);
				ps.setString(5, address);
				ps.setString(6, Category);
				ps.executeUpdate();
				JOptionPane.showConfirmDialog(null,"what to add new passenger", "Details saved", JOptionPane.YES_NO_OPTION);
				getid();
				np.setText("");
				ag.setText("");
				
				ad.setText("");
				bg.clearSelection();
				JComboBox y = new JComboBox();
				y.addItem("sjhfd");
				y.setSelectedItem("sdj");
		
				
				
				
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
		
		// TODO Auto-generated method stub
		
	}
}
