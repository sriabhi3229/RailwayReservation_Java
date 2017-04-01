package railwayreservation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ReservationForm extends JDialog implements ActionListener {
	private JTextField tno;
	private JTextField tna;
	private JTextField doj;
	private JTextField bd;
	JButton insert,next,main,train, name,enter;
	JComboBox classname,up,low,mid,source,destination;
	private JTextField nos;
int cost,number,number1,upp1,loww1,midd1,number3;
int totalc;
double trainno,pnr,pnrno;
private JTextField id;
private JLabel lblNewLabel_13;
private JTextField pn;
private JTextField n1;
private JTextField n2;
private JTextField n3;
private JTextField n4;
private JTextField n5;
private JTextField nop;
String idd,tname,tclass1,source1,desti,bord,piid,date;
private JButton get;

	public ReservationForm() {
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.BLACK);
		
		JLabel lblNewLabel_1 = new JLabel("Train No.");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setForeground(new Color(220, 220, 220));
		lblNewLabel_1.setBounds(178, 111, 107, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Train Name");
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setForeground(new Color(220, 220, 220));
		lblNewLabel_2.setBounds(178, 160, 128, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Class");
		lblNewLabel_3.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_3.setForeground(new Color(220, 220, 220));
		lblNewLabel_3.setBounds(178, 420, 70, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Date of Journey");
		lblNewLabel_4.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_4.setForeground(new Color(220, 220, 220));
		lblNewLabel_4.setBounds(178, 474, 147, 20);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("From");
		lblNewLabel_5.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_5.setForeground(new Color(220, 220, 220));
		lblNewLabel_5.setBounds(178, 529, 85, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Boarding at");
		lblNewLabel_6.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_6.setForeground(new Color(220, 220, 220));
		lblNewLabel_6.setBounds(178, 584, 118, 19);
		getContentPane().add(lblNewLabel_6);
		
		tno = new JTextField();
		tno.setBounds(460, 110, 86, 20);
		getContentPane().add(tno);
		tno.setColumns(10);
		
		tna = new JTextField();
		tna.setBounds(460, 159, 86, 20);
		getContentPane().add(tna);
		tna.setColumns(10);
		
		 classname = new JComboBox();
		 classname.setModel(new DefaultComboBoxModel(new String[] {"Select ","Sleeper", "General", "AC"}));
		classname.setBounds(460, 419, 86, 20);
		getContentPane().add(classname);
		
		doj = new JTextField();
		doj.setBounds(460, 476, 86, 20);
		getContentPane().add(doj);
		doj.setColumns(10);
		
		bd = new JTextField();
		bd.setBounds(460, 583, 86, 20);
		getContentPane().add(bd);
		bd.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("To");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_7.setForeground(new Color(220, 220, 220));
		lblNewLabel_7.setBounds(480, 529, 54, 14);
		getContentPane().add(lblNewLabel_7);
		
		  insert = new JButton("Insert");
		  insert.setMnemonic('i');
		insert.setBounds(178, 631, 89, 23);
		getContentPane().add(insert);
		
		  next = new JButton("Next");
		  next.setMnemonic('n');
		next.setBounds(344, 631, 89, 23);
		getContentPane().add(next);
		
		  main = new JButton("Main");
		  main.setMnemonic('m');
		main.setBounds(512, 631, 89, 23);
		getContentPane().add(main);
		
		JLabel lblNewLabel_8 = new JLabel("Number of Seats");
		lblNewLabel_8.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_8.setForeground(new Color(220, 220, 220));
		lblNewLabel_8.setBounds(178, 207, 147, 17);
		getContentPane().add(lblNewLabel_8);
		
		nos = new JTextField();
		nos.setBounds(460, 207, 86, 20);
		getContentPane().add(nos);
		nos.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Bearth");
		lblNewLabel_9.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_9.setForeground(new Color(220, 220, 220));
		lblNewLabel_9.setBounds(178, 261, 85, 14);
		getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Upper");
		lblNewLabel_10.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_10.setForeground(new Color(220, 220, 220));
		lblNewLabel_10.setBounds(326, 260, 70, 17);
		getContentPane().add(lblNewLabel_10);
		
		 up = new JComboBox();
		 up.setModel(new DefaultComboBoxModel(new String[] {"0","1", "2", "3", "4", "5", "6"}));
		 up.setSelectedIndex(0);
		up.setBounds(460, 260, 78, 20);
		getContentPane().add(up);
		
		JLabel lblNewLabel_11 = new JLabel("Lower");
		lblNewLabel_11.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_11.setForeground(new Color(220, 220, 220));
		lblNewLabel_11.setBounds(326, 314, 70, 17);
		getContentPane().add(lblNewLabel_11);
		
		 low = new JComboBox();
		 low.setModel(new DefaultComboBoxModel(new String[] {"0","1", "2", "3", "4", "5", "6"}));
		low.setBounds(460, 314, 78, 20);
		getContentPane().add(low);
		
		JLabel lblNewLabel_12 = new JLabel("Middle");
		lblNewLabel_12.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_12.setForeground(new Color(220, 220, 220));
		lblNewLabel_12.setBounds(326, 363, 70, 17);
		getContentPane().add(lblNewLabel_12);
		
		mid = new JComboBox();
		mid.setModel(new DefaultComboBoxModel(new String[] {"0","1", "2", "3", "4", "5", "6"}));
		mid.setBounds(460, 363, 77, 20);
		getContentPane().add(mid);
		
		 train = new JButton("Train List");
		 train.setMnemonic(KeyEvent.VK_T);
		train.setBounds(457, 13, 89, 23);
		getContentPane().add(train);
		
		 source = new JComboBox();
		source.setModel(new DefaultComboBoxModel(new String[] {"Select","lucknow", "kanpur", "allahabad"}));
		source.setBounds(388, 528, 82, 20);
		getContentPane().add(source);
		
	destination = new JComboBox();
		destination.setModel(new DefaultComboBoxModel(new String[] {"Select","lucknow", "kanpur", "allahabad"}));
		destination.setBounds(549, 528, 79, 20);
		getContentPane().add(destination);
		
		JLabel lblNewLabel = new JLabel("List of Trains");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setForeground(new Color(220, 220, 220));
		lblNewLabel.setBounds(178, 15, 147, 20);
		getContentPane().add(lblNewLabel);
		
		nop = new JTextField();
		nop.setBounds(682, 14, 86, 20);
		getContentPane().add(nop);
		nop.setColumns(10);
		
		id= new JTextField();
		id.setFont(new Font("Tahoma", Font.BOLD, 13));
		id.setForeground(Color.BLACK);
		
		id.setEditable(false);
		id.setBounds(460, 64, 86, 20);
		getContentPane().add(id);
		id.setColumns(10);
		
		lblNewLabel_13 = new JLabel("PId");
		lblNewLabel_13.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_13.setForeground(new Color(220, 220, 220));
		lblNewLabel_13.setBounds(178, 65, 46, 14);
		getContentPane().add(lblNewLabel_13);
		
		pn = new JTextField();
		pn.setEditable(false);
		pn.setBounds(42, 38, 86, 20);
		getContentPane().add(pn);
		pn.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Pnr No.");
		lblNewLabel_14.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_14.setForeground(new Color(220, 220, 220));
		lblNewLabel_14.setBounds(42, 15, 74, 14);
		getContentPane().add(lblNewLabel_14);
		
		 name = new JButton("specify");
		name.setBounds(577, 206, 70, 23);
		getContentPane().add(name);
		
		n1 = new JTextField();
		n1.setEnabled(false);
		n1.setBounds(738, 159, 86, 20);
		getContentPane().add(n1);
		n1.setColumns(10);
		
		n2 = new JTextField();
		n2.setEnabled(false);
		n2.setBounds(738, 207, 86, 20);
		getContentPane().add(n2);
		n2.setColumns(10);
		
		n3 = new JTextField();
		n3.setEnabled(false);
		n3.setBounds(738, 260, 86, 20);
		getContentPane().add(n3);
		n3.setColumns(10);
		
		n4 = new JTextField();
		n4.setEnabled(false);
		n4.setBounds(738, 314, 86, 20);
		getContentPane().add(n4);
		n4.setColumns(10);
		
		n5 = new JTextField();
		n5.setEnabled(false);
		n5.setBounds(738, 363, 86, 20);
		getContentPane().add(n5);
		n5.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("Name1");
		lblNewLabel_15.setForeground(Color.WHITE);
		lblNewLabel_15.setBounds(682, 162, 46, 14);
		getContentPane().add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Name2");
		lblNewLabel_16.setForeground(Color.WHITE);
		lblNewLabel_16.setBounds(682, 210, 46, 14);
		getContentPane().add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Name3");
		lblNewLabel_17.setForeground(Color.WHITE);
		lblNewLabel_17.setBounds(682, 263, 46, 14);
		getContentPane().add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("Name4");
		lblNewLabel_18.setForeground(Color.WHITE);
		lblNewLabel_18.setBounds(682, 317, 46, 14);
		getContentPane().add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Name5");
		lblNewLabel_19.setForeground(Color.WHITE);
		lblNewLabel_19.setBounds(682, 369, 46, 14);
		getContentPane().add(lblNewLabel_19);
		
		 enter = new JButton("Enter Names");
		enter.setBounds(699, 418, 100, 23);
		getContentPane().add(enter);
		
		JLabel lblNewLabel_20 = new JLabel("Name of passenger");
		lblNewLabel_20.setForeground(Color.WHITE);
		lblNewLabel_20.setBounds(577, 17, 93, 14);
		getContentPane().add(lblNewLabel_20);
		
		get = new JButton("id");
		get.setBounds(778, 13, 46, 23);
		getContentPane().add(get);
		
		
		setModal(true);
		
		get.addActionListener(this);
		name.addActionListener(this);
		insert.addActionListener(this);
		next.addActionListener(this);
		main.addActionListener(this);
		train.addActionListener(this);
		enter.addActionListener(this);
	setTitle("Reservation Form");
	getpnr();
		setSize(850,720);
		setModal(true);
		setVisible(true);
	}
	void getpnr()
	{
		String s="select max(epnr) from reservation";
		
	Connection con=MyConnection.connect();

	try
	{
	PreparedStatement ps=con.prepareStatement(s);
	ResultSet rs1=ps.executeQuery();
	while(rs1.next())
	{
	pnr=rs1.getDouble(1);
	 }
	}
	catch(SQLException se)
	{
			se.printStackTrace();
	}
	++pnr;
	System.out.println(pnr);
pn.setText(String.valueOf(pnr));
	
	}

	public static void main(String[] args) {
		new ReservationForm();
		// TODO Auto-generated method stub

	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object ob=e.getSource();
		
		
		if(ob==get)
		{
			 String nopp=nop.getText();
			 System.out.println(nopp);
	
				String s="select pid from passenger where pname=?";
				Connection con=MyConnection.connect();
				try
				{
			PreparedStatement ps=con.prepareStatement(s);
			ps.setString(1,nopp);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				id.setText(rs.getString("pid"));
			}}
				catch(SQLException se)
				{
					se.printStackTrace();
				}
				
				System.out.println("id is set");
		}
		if(ob==name){
			
			String pd=id.getText();
			int pdd=Integer.parseInt(pd);
			if((nos.getText()).equals(null)){
				 number3=0;
			}else{
			 number3=Integer.parseInt(nos.getText());
			}
			
			System.out.println("names generated");
			int no=number3;
			switch (no){
			case 2:
				n1.setEnabled(true);
				break;
			case 3:
				n1.setEnabled(true);
				n2.setEnabled(true);
				break;
			case 4:
				n1.setEnabled(true);
				n2.setEnabled(true);
				n3.setEnabled(true);
				break;
			case 5:
				n1.setEnabled(true);
				n2.setEnabled(true);
				n3.setEnabled(true);
				n4.setEnabled(true);
				break;
			case 6:
				n1.setEnabled(true);
				n2.setEnabled(true);
				n3.setEnabled(true);
				n4.setEnabled(true);
				n5.setEnabled(true);
				break;
			}}
		if(ob==enter){
			String pd=id.getText();
			int pdd=Integer.parseInt(pd);
			if((nos.getText()).equals(null)){
				 number3=0;
			}else{
			 number3=Integer.parseInt(nos.getText());
			}
			String name1=n1.getText();
			String name2=n2.getText();
			String name3=n3.getText();
			String name4=n4.getText();
			String name5=n5.getText();
			String s2="insert into namelist(pid,noseats,n1,n2,n3,n4,n5)values(?,?,?,?,?,?,?)";
			Connection con2=MyConnection.connect();
			try
			{
				PreparedStatement ps2=con2.prepareStatement(s2);
				ps2.setInt(1, pdd);
				ps2.setInt(2, number3);
				ps2.setString(3, name1);
				ps2.setString(4, name2);
				ps2.setString(5, name3);
				ps2.setString(6, name4);
				ps2.setString(7, name5);
				ps2.executeUpdate();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			

			System.out.println("names successfully entered");
		}
		

		if(ob==next)
		{dispose();
		
			new Payment();
	
		}else if(ob==main)
		{
			dispose();
			
			new HomePage1();
			
			}else if(ob==train)
			{
				new TrainChart();
			}
		else if(ob==insert)
		{
			if((tno.getText()).equals(null)){
				trainno=0;
			}else{
			 trainno=Double.parseDouble((tno.getText()));
			}
			String tname=tna.getText();
			String tclass1=classname.getSelectedItem().toString();
			String date=String.valueOf(doj.getText());
			String source1=source.getSelectedItem().toString();
			String desti=destination.getSelectedItem().toString();
			String bord=bd.getText();
			String piid=id.getText();
			System.out.println(piid);
			

			if((nos.getText()).equals(null)){
				 number1=0;
			}else{
			 number1=Integer.parseInt(nos.getText());
			}
			String upp=up.getSelectedItem().toString();
			upp1=Integer.parseInt(upp);
			String loww=low.getSelectedItem().toString();
			 loww1=Integer.parseInt(loww);
			String midd=mid.getSelectedItem().toString();
			 midd1=Integer.parseInt(midd);
		
			String s3="select * from class_cost where class_name=?";
			Connection con3=MyConnection.connect();
			try
			{
				PreparedStatement ps3=con3.prepareStatement(s3);
		ps3.setString(1,tclass1);
			ResultSet rs3=ps3.executeQuery();
			System.out.println(tclass1);
			while(rs3.next())
			{
				cost=rs3.getInt("cost");
				 totalc=(cost*number1);
			}}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			System.out.println(totalc);


			Boolean val=validate(trainno,tname,tclass1,date,source1,desti,bord,piid,number1);
			if(val){
			String s="insert into reservation(etrainno,etrainname,eclass,esource,edestination,eboarding,edate,seats,upper,lower,middle,total_cost,pid,epnr)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			Connection con1=MyConnection.connect();
			try
			{
				PreparedStatement ps1=con1.prepareStatement(s);
				
				ps1.setDouble(1, trainno);
				ps1.setString(2,tname);
				ps1.setString(3, tclass1);
				ps1.setString(4,source1);
				ps1.setString(5, desti);
				ps1.setString(6, bord);
				ps1.setString(7, date);
				ps1.setInt(8, number1);
				ps1.setInt(9, upp1);
				ps1.setInt(10, loww1);
				ps1.setInt(11, midd1);
				ps1.setInt(12, totalc);
				ps1.setString(13, piid);
				
				
				ps1.setDouble(14, pnr );
				ps1.executeUpdate();
				
				JOptionPane.showConfirmDialog(null,"new resrvation","reservation successfull",JOptionPane.YES_NO_OPTION);
				n1.setText(" ");
				n2.setText(" ");
				n3.setText(" ");
				n4.setText(" ");
				n5.setText(" ");
				nop.setText("");
id.setText("");
				tno.setText("");
				tna.setText("");
				doj.setText("");
				
				bd.setText("");
				
				nos.setText("");
				up.setSelectedItem("0");
				low.setSelectedItem("0");
				mid.setSelectedItem("0");
				classname.setSelectedItem("Select ");
				tno.requestFocusInWindow();
				tna.requestFocusInWindow();
				doj.requestFocusInWindow();
				source.setSelectedItem("Select ");
				bd.requestFocusInWindow();
				destination.setSelectedItem("Select ");
				nos.requestFocusInWindow();
				
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			
			
		}}
	
		
		// TODO Auto-generated method stub
		
	}
	 
	public Boolean validate(double trainno, String tname, String tclass1,String date,String source1,String desti,String bord,String piid,int number1){
		 System.out.println("inside validate method");
			Boolean val=true;
			System.out.println(trainno);
			System.out.println(tname);
			if(trainno==0){
				val=false;
				JOptionPane.showMessageDialog(this, "ENTER VALID TRAIN NO.");
			}
			if(tname.equalsIgnoreCase(null) || "".equalsIgnoreCase(tname.trim())){
				val=false;
				JOptionPane.showMessageDialog(this, "ENTER TRAIN NAME");
			}
			if(date.equalsIgnoreCase(null) || "".equalsIgnoreCase(date.trim())){
				val=false;
				JOptionPane.showMessageDialog(this, "ENTER DATE");
			}
			if(source1.equalsIgnoreCase(null) || "".equalsIgnoreCase(source1.trim())){
				val=false;
				JOptionPane.showMessageDialog(this, "ENTER SOURCE");
			}
			if(desti.equalsIgnoreCase(null) || "".equalsIgnoreCase(desti.trim())){
				val=false;
				JOptionPane.showMessageDialog(this, "ENTER DESTINATION");
			}
			if(bord.equalsIgnoreCase(null) || "".equalsIgnoreCase(bord.trim())){
				val=false;
				JOptionPane.showMessageDialog(this, "ENTER BOARDING PLACE");
			}
			if(number1==0){
				val=false;
				JOptionPane.showMessageDialog(this, "ENTER NUMBER OF SEATS REQUIRED");
			}
			if(piid.equalsIgnoreCase(null) || "".equalsIgnoreCase(piid.trim())){
				val=false;
				JOptionPane.showMessageDialog(this, "ENTER ID");
			}
			int total=upp1+midd1+loww1;
			if(total!=number1){
				JOptionPane.showConfirmDialog(this, "Invalid Seats");
			}
		 
		return val;
	}
}

