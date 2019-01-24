

import java.awt.*;
import java.awt.event.*;

public class MyRectangle {
	
	//You need some kind of tolerance, in pixels
		//...a +/- of the mouse position to determine if it's close enough to a given edge of the rectangle
	
	// Rectangle properties
	private int x;			//the x for position
	private int y;			//the y for position
	private int width;		//the rectangle width
	private int height;		//the rectangle height 
	private Color color = Color.RED;

	// Previous coordinates, dimensions, and mouse positions
	//You will need to store the previous X and Y positions of the rectangle, as well as the height and width
	//You will also need the previous mouse position
	//This way, you can compute changes in these values and apply the necessary changes to the rectangle

	private boolean resizing = false;
	private boolean action = false;
	private int tor = 5;
	

	public MyRectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}

	public void processMousePressed(MouseEvent e) {
		if ((x-tor<=e.getX()&&e.getX()<=x+tor)||(y-tor<=e.getY()&&e.getY()<=y+tor)){
			resizing = false;
			action = true;
		}
		if ((x+width-tor<=e.getX()&&e.getX()<=x+width+tor)||(y+height-tor<=e.getY()&&e.getY()<=y+height+tor)){
			resizing = true;
			action = true;
		}
		//fill this in... what shall we do when the mouse is initially pressed down?
		//you will also need to add this method call to your handler for mouse down events
	}

	public void processMouseReleased(MouseEvent e) {
		action = false;
		//fill this in as well... what shall we do  when the mouse is released?
		//you will also need to add this method call to your handler for mouse released events
	}

	public void processMouseDragged(MouseEvent e) {
		if (!resizing && action){
			x=x+e.getX();
			y=y+e.getY();
		}
		
		if (resizing && action){
			width = width + e.getX();
			height = height + e.getY();
		}
		//fill this in too... what shall we do as the mouse is being dragged around?
		//you will also need to add this method call to your handler for mouse dragged events
	}

	public void draw(Graphics g) {
		//this method receives the Graphics object of the JFrame and draws on it
		//this method simply draws the rectangle by setting its color and calling drawRect
		if (!resizing){
			g.setColor(color.blue);
		}
		else if(resizing){
			g.setColor(color.green);
		}
		else if(!action){
			g.setColor(color.red);
		}
		
		g.drawRect(x, y, width, height);
		
		//you should NOT need to add anything here...
		//in your "process" calls above, you will be modifying color, x, y, width, and height depending on the mouse position
		//in your handlers, you will be calling Main's repaint and the above "process" calls
		
	}
	
	//you may need other methods to handle stuff
}