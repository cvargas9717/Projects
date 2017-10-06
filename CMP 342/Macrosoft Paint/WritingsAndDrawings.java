package paint_project;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WritingsAndDrawings extends Drawings implements KeyListener{

	private Font font;
	private FontMetrics fm;
	protected static boolean typeOn;
	
	public WritingsAndDrawings(){
		super();//call parent constructor
		setBackground(Color.WHITE);
		font = new Font("Serif", Font.ITALIC, 50);//default size;
		fm = getFontMetrics(font);//want to be able to measure my String to draw
		addKeyListener(this);
		typeOn = false;
	}

	
	@Override
	public void keyTyped(KeyEvent e) {
		if(typeOn){
		String a = String.valueOf(e.getKeyChar());
		if(mouseIsPressed){
			Graphics g = getGraphics();
			g.setColor(lineColor);
			lastX += fm.stringWidth(a); //increase x by width to move next char over
			g.drawString(a, lastX, lastY);
			
			//going to write all the chars we type on top of each other
			g.dispose();
		}
		System.out.println("In key typed "+ a);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}