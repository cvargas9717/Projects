package paint_project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class Drawings extends JPanel implements MouseListener, MouseMotionListener{

	protected int lastX;
	protected int lastY;
	public boolean mouseIsPressed;
	public boolean mouseIsDragged;
	public Color lineColor;
	public Color circleColor;
	protected String shapeType;
	static boolean circleOn;
	static boolean squareOn;
	static boolean arcOn;
	static boolean EDSquareOn;
	protected static boolean dragOn;
	protected static boolean pencilOn;
	//static for now.. but remember that shares the variable among all instances
	//make sure to change the shapeOn to non-static... also think about
	//how you will access and change the values of these variables from your controls
	protected int diameter;
	
	public Drawings(){
		lastX = 0;
		lastY = 0;
		diameter = 30;
		//shapeOn = false;
		//squareOn = false;
		dragOn = false;
		pencilOn = false;
		addMouseListener(this);
		addMouseMotionListener(this);
		//setSize(500, 500);
		//setBackground(Color.YELLOW);
		mouseIsPressed =false;
		mouseIsDragged = false;
		//lineColor = Color.black;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
			
		if(circleOn == true){//use the variable to determine if we'll draw a shape
			
			Graphics g =  getGraphics();
			g.setColor(circleColor);
			drawCircle(g);
			
			

		}		
			
		if(squareOn == true){//use the variable to determine if we'll draw a shape
			
			Graphics g = getGraphics();
			g.setColor(circleColor);
			drawSquare(g);
			
			}
		
		if(arcOn == true){
			Graphics g = getGraphics();
			g.setColor(circleColor);
			drawArc(g);
		}
		
		if(EDSquareOn == true){
			Graphics g = getGraphics();
			g.setColor(circleColor);
			draw3DSquare(g);
		}
	
	}
	

	private void drawCircle(Graphics g){
		g.fillOval(lastX - diameter/2, lastY- diameter/2, diameter, diameter);
	}
	
	
	private void drawSquare(Graphics g){
		g.fillRect(lastX - diameter/2, lastY- diameter/2, diameter, diameter);
	}
	
	private void drawArc(Graphics g){
		g.fillArc(lastX-diameter/2, lastY- diameter/2, diameter, diameter,180, 180);
	}
	private void draw3DSquare(Graphics g){
		g.fill3DRect(lastX-diameter/2, lastY- diameter/2, diameter, diameter, true); 
	}
	
	
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		
		
		
		
		mouseIsPressed = true;
		record(e.getX(), e.getY());
		//Graphics g = getGraphics();
		//g.drawOval(lastX - 10, lastY - 10, 20, 20);
		System.out.println("In PRESSED AT: "+lastX+","+lastY);
		
		//g.dispose();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		if(dragOn){
		mouseIsPressed = false;
		int x = e.getX();
		int y = e.getY();
		Graphics g = getGraphics();
		g.drawLine(lastX, lastY, x, y);
		record(x, y);
		g.dispose();

		System.out.println("Released AT: "+x+","+y);
		}	
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		requestFocus();//request the focus on the jpanel when the mouse enters
		record(e.getX(), e.getY());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
	protected void record(int x, int y){
		lastX = x;
		lastY = y;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		
		if(circleOn == true){
			Graphics g = getGraphics();
			g.setColor(Color.WHITE);
			g.fillOval(lastX - diameter/2, lastY- diameter/2, diameter, diameter);
			
		}
		
		
		
		
		
		
		
		
		if(pencilOn){
			
			mouseIsPressed = true;
			int x = e.getX();
			int y = e.getY();
			Graphics g = getGraphics();
			Graphics2D g2d = (Graphics2D)g;
			g2d.setColor(lineColor);
			g2d.drawLine(lastX, lastY, x, y);
		//	g.drawLine(10, 10, 100, 100);
			//g2d.setStroke();new basicStroke(size)
			record(x, y);
			g.dispose();
			System.out.println("Dragged AT: "+x+","+y);
		}
			
		
		
		
		if(dragOn){
		
		mouseIsPressed = true;
		int x = e.getX();
		int y = e.getY();
		Graphics g = getGraphics();
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(lineColor);
		g2d.drawLine(lastX, lastY, x, y);
		//g.drawLine(10, 10, 100, 100);
		record(x, y);
		g.dispose();
		System.out.println("Dragged AT: "+x+","+y);
			
		
		}
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
