import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Ref;
import java.util.EventObject;
public class FinalUserFrame extends JFrame implements ActionListener {
	
	public FinalUserFrame(University a) {
		
		super("Input Frame");
		setLayout(new FlowLayout());
		
		University univ = a;
		JLabel enterLabel;
		JTextField countryInputField;
		final JTextArea outputField = new JTextArea(15,50);
		JButton showStudent, Des, iDes;
		
		enterLabel = new JLabel("Enter name of Country");

		
		countryInputField = new JTextField(20);
		countryInputField.setEditable(true);
		countryInputField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputField.setText("Number of student from "+e.getActionCommand()+" is "+ univ.numberOfStudents(e.getActionCommand()));
			}			
		});
		
		showStudent = new JButton("Show Student");
		showStudent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				outputField.setText(univ.toString());				
			}			
		});
		iDes = new JButton("Sorted List (ascending) of Students");
		iDes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				OutputFrame a = new OutputFrame(univ,false);
				a.setVisible(true);
			}
			
		});
		Des = new JButton("Sorted List (descending) of Students");
		Des.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				OutputFrame b = new OutputFrame(univ,true);
				b.setVisible(true);
			}
			
		});
		
		
		add (enterLabel);
		add (countryInputField);		
		add (outputField);
		add (showStudent);
		add (Des);
		add (iDes);
		
	
		setSize(700,400);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
	}


}
