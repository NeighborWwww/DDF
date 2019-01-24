import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {

	private int rectangleWidth;
	private int rectangleHeight;

	MyRectangle rectangle = new MyRectangle(50, 50, 100, 100);

	public Main() {
		super("Resizable rectangle");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Add listeners here
			//mouse dragged, mouse released, etc.
			//you should be calling some methods in the rectangle object from here
				//see the "process" calls in rectangle
		
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		//this makes the rectangle draw itself... see the MyRectangle class for this method
		rectangle.draw(g);
	}
}