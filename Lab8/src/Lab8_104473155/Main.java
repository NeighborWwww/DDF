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
		
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				rectangle.processMouseReleased(e);
				repaint();
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				rectangle.processMousePressed(e);
				repaint();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				rectangle.processMouseReleased(e);
				repaint();
			}
			
		});
		
		
		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				rectangle.processMouseDragged(e);
				repaint();
				
				
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
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