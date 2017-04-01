package railwayreservation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JList;

public class TrainChart extends JDialog implements ActionListener {
	private JTable table;
	int e=10;
	public TrainChart() {
		getContentPane().setLayout(null);
		
		table = new JTable();
		  
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table.setBounds(36, 63, 620, 453);
	table.addRowSelectionInterval(0, 70);
		getContentPane().add(table);
		setSize(700,600);
		setModal(true);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TrainChart();
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
