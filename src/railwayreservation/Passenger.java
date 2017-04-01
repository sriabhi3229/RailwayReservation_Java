package railwayreservation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
import java.awt.Font;

public class Passenger extends JDialog implements ActionListener {
	private JTextField ag;
	private JTextField np;
	private JTextField pi;
	ButtonGroup  bg,bi;
	JRadioButton gf,gm;
	JButton more,save,back;
	JTextPane ad;
	int id;
	JRadioButton gen,exs,sc;
	
	public Passenger() {
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.BLACK);
		JLabel lblNewLabel = new JLabel("PId");
		lblNewLabel.setFont(new Font("Eras Demi ITC", Font.PLAIN, 16));
		lblNewLabel.setForeground(new Color(220, 220, 220));
		lblNewLabel.setBounds(55, 37, 60, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name Of Passenger");
		lblNewLabel_1.setFont(new Font("Eras Demi ITC", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(new Color(220, 220, 220));
		lblNewLabel_1.setBounds(55, 102, 154, 31);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Age");
		lblNewLabel_2.setFont(new Font("Eras Demi ITC", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(new Color(220, 220, 220));
		lblNewLabel_2.setBounds(55, 181, 60, 19);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setFont(new Font("Eras Demi ITC", Font.PLAIN, 16));
		lblNewLabel_3.setForeground(new Color(220, 220, 220));
		lblNewLabel_3.setBounds(416, 181, 75, 19);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setFont(new Font("Eras Demi ITC", Font.PLAIN, 16));
		lblNewLabel_4.setForeground(new Color(220, 220, 220));
		lblNewLabel_4.setBounds(55, 271, 86, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Category");
		lblNewLabel_5.setFont(new Font("Eras Demi ITC", Font.PLAIN, 16));
		lblNewLabel_5.setForeground(new Color(220, 220, 220));
		lblNewLabel_5.setBounds(55, 462, 86, 31);
		getContentPane().add(lblNewLabel_5);
		
		more = new JButton("More");
		more.setMnemonic(KeyEvent.VK_M);
		more.setBounds(111, 610, 89, 23);
		getContentPane().add(more);
		
		 save = new JButton("Save");
		 save.setMnemonic(KeyEvent.VK_S);
		save.setBounds(299, 610, 89, 23);
		getContentPane().add(save);
		
		 back = new JButton("Back");
		 back.setMnemonic(KeyEvent.VK_B);
		back.setBounds(463, 610, 89, 23);
		getContentPane().add(back);
		
		 ad = new JTextPane();
		ad.setBounds(299, 271, 208, 125);
		getContentPane().add(ad);
		
		ag = new JTextField();
		ag.setBounds(297, 182, 86, 20);
		getContentPane().add(ag);
		ag.setColumns(10);
		
		 gm = new JRadioButton("Male");
		 gm.setMnemonic(KeyEvent.VK_M);
		gm.setBounds(510, 181, 109, 23);
		getContentPane().add(gm);
		
		 gf = new JRadioButton("Female");
		 gf.setMnemonic(KeyEvent.VK_F);
		gf.setBounds(510, 231, 109, 23);
		getContentPane().add(gf);
		
		np = new JTextField();
		np.setBounds(297, 109, 86, 20);
		getContentPane().add(np);
		np.setColumns(10);
		
		pi = new JTextField();
		pi.setForeground(new Color(255, 0, 0));
		pi.setEditable(false);
		pi.setBounds(297, 36, 86, 20);
		getContentPane().add(pi);
		pi.setColumns(10);
		
		 gen = new JRadioButton("General");
		 gen.setMnemonic(KeyEvent.VK_G);
		gen.setBounds(300, 462, 109, 23);
		getContentPane().add(gen);
		
		 sc = new JRadioButton("Senior Citizen");
		 sc.setMnemonic(KeyEvent.VK_S);
		sc.setBounds(300, 506, 109, 23);
		getContentPane().add(sc);
		
		 exs = new JRadioButton("Ex-Serviceman");
		 exs.setMnemonic(KeyEvent.VK_E);
		exs.setBounds(300, 548, 109, 23);
		getContentPane().add(exs);
		setModal(true);
		bg=new ButtonGroup();
		bg.add(gm);
		bg.add(gf);
		bi=new ButtonGroup();
		bi.add(gen);
		bi.add(exs);
		bi.add(sc);
	more.addActionListener(this);
		save.addActionListener(this);
		back.addActionListener(this);
	getid();
	setTitle("Passenger Information Form");
		setSize(700,720);
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
		{dispose();
			new ReservationForm();
		
		}
		else if(ob==back)
		{dispose();
			new HomePage1();
			
		}
		else if(ob==save)
		{
			String name=np.getText();
			String age=ag.getText();
		System.out.print(age);
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
			Boolean val= validate(name,age,gender,address,Category);
			System.out.print(val);
			if(val){
			String s="insert into passenger(pid,pname,page,pgender,paddress,pcategory)values(?,?,?,?,?,?)";
			Connection con=MyConnection.connect();
			try
			{
				PreparedStatement ps=con.prepareStatement(s);
				ps.setInt(1,id);
				ps.setString(2, name);
				if(age.equals("")){
					
					ps.setInt(3, 0);
				}else{
				ps.setInt(3, Integer.parseInt(age));}
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
				bi.clearSelection();
				
		
				
				}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}}
	}
		// TODO Auto-generated method stub
		
		public Boolean validate(String name,String age,String gender,String address,String Category )
		{
			System.out.println("inside validate method");
			Boolean val=true;
			System.out.println(name);
			if(name.equalsIgnoreCase(null) || "".equalsIgnoreCase(name.trim())){
				val=false;
				JOptionPane.showMessageDialog(this, "ENTER NAME");
			}
			if(age.equalsIgnoreCase(null) || "".equalsIgnoreCase(age.trim()) ){
				val=false;
				JOptionPane.showMessageDialog(this, "ENTER AGE");
			}
			if(gender.equalsIgnoreCase(null) || "".equalsIgnoreCase(gender.trim())){
				val=false;
				JOptionPane.showMessageDialog(this, "ENTER GENDER");
			}
			if(address.equalsIgnoreCase(null) || "".equalsIgnoreCase(address.trim())){
				val=false;
				JOptionPane.showMessageDialog(this, "ENTER ADDRESS");
			}
			if(Category.equalsIgnoreCase(null) || "".equalsIgnoreCase(Category.trim())){
				val=false;
				JOptionPane.showMessageDialog(this, "ENTER CATEGORY");
			}
			return val;
	
}
}