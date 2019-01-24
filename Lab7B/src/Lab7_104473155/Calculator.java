import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.EventObject;

public class Calculator extends JFrame implements ActionListener {

	JTextField digitDisplay;
	JButton[] digit;
	JButton add,sub,mul,div,c;
	public double total;
	public static double taker = 0;
	
	public Calculator() {
		super("A Calculator");
		setLayout(new FlowLayout());

		
		digitDisplay = new JTextField(10);
		digitDisplay.setEditable(false);
		add(digitDisplay);
		
		digit = new JButton[10];
		for (int i = 0; i<=9; i++) {
			digit[i] = new JButton(Integer.toString(i));
			if (i == 0) {
				digit[i].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						taker = taker*10+ 0;
						digitDisplay.setText(Double.toString(taker));					
					}
				});
			}
			else if (i == 1) {
				digit[i].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						taker = taker*10+ 1;
						digitDisplay.setText(Double.toString(taker));					
					}
				});
				
			}
			else if (i == 2) {
				digit[i].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						taker = taker*10+ 2;
						digitDisplay.setText(Double.toString(taker));					
					}
				});
				
			}
			else if (i == 3) {
				digit[i].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						taker = taker*10+ 3;
						digitDisplay.setText(Double.toString(taker));					
					}
				});
				
			}
			else if (i == 4) {
				digit[i].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						taker = taker*10+ 4;
						digitDisplay.setText(Double.toString(taker));					
					}
				});
				
			}
			else if (i == 5) {
				digit[i].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						taker = taker*10+ 5;
						digitDisplay.setText(Double.toString(taker));					
					}
				});
				
			}
			else if (i == 6) {
				digit[i].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						taker = taker*10+ 6;
						digitDisplay.setText(Double.toString(taker));					
					}
				});
				
			}
			else if (i == 7) {
				digit[i].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						taker = taker*10+ 7;
						digitDisplay.setText(Double.toString(taker));					
					}
				});
				
			}
			else if (i == 8) {
				digit[i].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						taker = taker*10+ 8;
						digitDisplay.setText(Double.toString(taker));					
					}
				});
				
			}
			else if (i == 9) {
				digit[i].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						taker = taker*10+ 9;
						digitDisplay.setText(Double.toString(taker));					
					}
				});
				
			}
	}
		
		for (int i = 1; i<=9; i++) {
			add(digit[i]);
		}
		add(digit[0]);
		
		
		setSize(160,260);
		setVisible(true);
		add = new JButton("+");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total +=taker;
				taker = 0;
				digitDisplay.setText(Double.toString(total));
			}
		});
		add(add);
		
		sub = new JButton("-");
		sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total -= taker;
				taker = 0;
				digitDisplay.setText(Double.toString(total));
			}
		});
		add(sub);
		
		mul = new JButton("*");
		mul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total *= taker;
				taker = 0;
				digitDisplay.setText(Double.toString(total));
			}
		});
		add(mul);
		
		div = new JButton("/");
		div.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total /= taker;
				taker = 0;
				digitDisplay.setText(Double.toString(total));
			}
		});
		add(div);
		
		c = new JButton("c");
		c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total = 0;
				taker = 0;
				digitDisplay.setText(Double.toString(total));
			}
		});
		add(c);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		Calculator a = new Calculator();
		
	}

}
