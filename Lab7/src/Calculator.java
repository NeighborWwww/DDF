import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener{
	private double Res;
	private static double take;
	
	JTextArea Display;
	JButton [] Btm;
	
	
	public Calculator (){
		super ("calculator");
		this.setBounds(0, 0, 160, 260);
		Display = new JTextArea(150,20);
		add(Display);
		Btm = new JButton [10];
		for (int i=0; i<9;i++){
			Btm [i] = new JButton(Integer.toString(i));
			Btm [i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					take = Double.parseDouble(((JButton)e.getSource()).getName());
				}
				
			});
			
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
