import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Ref;
import java.util.EventObject;
public class OutputFrame extends JFrame implements ActionListener {
	
	public OutputFrame (University a,boolean dec) {
		
		super("OutputFrame");
		setLayout(new FlowLayout());
		University univ = a;
		JLabel lb;
		final JTextArea ta = new JTextArea(15,50);
		JButton bt;
		
		if(dec) {
			lb = new JLabel("Sorted List (descending) of Students");
			univ.sortStudents(true);
			ta.setText(univ.toString());
		}
		else {
			lb = new JLabel("Sorted List (ascending) of Students");
			univ.sortStudents(false);
			ta.setText(univ.toString());
		}
		
		bt = new JButton("close");
		bt.addActionListener(this);
		
		
		add(lb);
		add(ta);
		add(bt);
		setSize(700,400);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		dispose();		
	}


}
