package paint_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

import day5.Drawing;



public class RunGUI extends JFrame implements ActionListener,MouseListener{
	
	
	
	static final int FPS_MIN = 0;
	static final int FPS_INIT = 15;
	static final int FPS_MAX = 30;
	 
	//private  jpWriteAndDraw ;
	Drawings draw;
	//Circle random;
	//Square rect;
	WritingsAndDrawings jpWriteAndDraw;
	JPanel mainContent;
	JMenuBar menuBar;
	JMenu tools;
	JMenu shapes;
	JButton pallete;
	JButton kb;
	JButton about;
	JButton eraser;
	JButton save;
	JButton eraser2;
	JButton reset;
	JSlider thickness;
	
	public RunGUI() {
		addMouseListener(this);
		
		thickness = new JSlider(JSlider.HORIZONTAL,FPS_MIN,FPS_MAX,FPS_INIT);
		
		draw = new Drawings();
		
		jpWriteAndDraw = new WritingsAndDrawings();
		
		//random = new Circle();
		//rect = new Square();
		
		mainContent = new JPanel(new BorderLayout());
		//mainContent.setLayout(new BorderLayout());
		//JPanel westPanel = new JPanel( new GridLayout(2,1));
		//westPanel.setLayout(new GridLayout(2,1));
		
		menuBar = new JMenuBar();
		
		tools = new JMenu("Tools");
		//tools.setMnemonic(KeyEvent.VK_A);
		//tools.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
		
		shapes = new JMenu("Shapes");
		//tools.setMnemonic(KeyEvent.VK_A);
		//tools.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
		
		pallete = new JButton("Colors");
		
		kb = new JButton("Type");
		
		eraser = new JButton("Erase");
		
		eraser2 = new JButton("Eraser");
		
		save = new JButton("Save");
		
		reset = new JButton("Reset");
		
		about = new JButton("About");
		
		
		//JMenuItem menuItem = new JMenuItem(new ImageIcon("images/middle.gif"));
		//menuItem.setMnemonic(KeyEvent.VK_D);
		
		
		//tools
		JRadioButton pencil = new JRadioButton("Pencil");
		JRadioButton pencilDrag = new JRadioButton("Pencil Drag");
		JRadioButton  brush = new JRadioButton("Paint Brush");
		JRadioButton  Scissor= new JRadioButton("Cut");
		
		ButtonGroup ToolGroup = new ButtonGroup();
		ToolGroup.add(pencilDrag);
		ToolGroup.add(pencil);
		ToolGroup.add(brush);
		ToolGroup.add(Scissor);
		
		
		//Shapes
		JRadioButton circle = new JRadioButton("Circle");
		JRadioButton square = new JRadioButton("Square");
		JRadioButton  arc = new JRadioButton("Arc");
		JRadioButton  EDSquare = new JRadioButton("3D Square");
		
		ButtonGroup ShapeGroup = new ButtonGroup();
		ShapeGroup.add(circle);
		ShapeGroup.add(square);
		ShapeGroup.add(arc);
		ShapeGroup.add(EDSquare);
		
		
		
		
		
		//JRadioButton listeners-TOOLS
		pencil.addActionListener(this);
		pencilDrag.addActionListener(this);
		
		//JRadioButton listeners-SHAPES
		circle.addActionListener(this);
		square.addActionListener(this);
		arc.addActionListener(this);
		EDSquare.addActionListener(this);
		//circle.setMnemonic(KeyEvent.VK_C);<------
	    //circle.setActionCommand("Circle");<------
		//circle.setMnemonic(KeyEvent.VK_B);
	    //circle.setActionCommand("Circle");
	    
		
		add(menuBar,BorderLayout.NORTH);
		add(mainContent);
		
		menuBar.add(tools);
		tools.add(pencil);
		tools.add(pencilDrag);
		tools.add(brush);
		tools.add(Scissor);
		
		
		menuBar.add(shapes);
		shapes.add(circle);
		shapes.add(square);
		shapes.add(arc);
		shapes.add(EDSquare);
		
		
		menuBar.add(pallete);
		pallete.addActionListener(this);
		
		menuBar.add(kb);
		kb.addActionListener(this);
		
		menuBar.add(eraser);
		eraser.addActionListener(this);
		
		menuBar.add(eraser2);
		eraser2.addActionListener(this);
		
		menuBar.add(save);
		save.addActionListener(this);
		
		menuBar.add(reset);
		reset.addActionListener(this);
		
		menuBar.add(about);
		about.addActionListener(this);
		
		//slider
		menuBar.add(thickness);
		//thickness.addChangeListener(this);
		
		thickness.setMajorTickSpacing(10);
		thickness.setMinorTickSpacing(1);
		thickness.setPaintTicks(true);
		thickness.setPaintLabels(true);
		
		//mainContent.add(westPanel);
		
		mainContent.add(jpWriteAndDraw,BorderLayout.CENTER);
		//mainContent.add(random,BorderLayout.CENTER);
		//mainContent.add(draw,BorderLayout.CENTER);
		//westPanel.add(thickness);
		
		
		
		
		setVisible(true);
		setTitle("Macrosoft Paint");
		setSize(700,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	public void clear(JPanel mainContent){
		mainContent.setBackground(null);
		mainContent.setBackground(Color.WHITE);
	}
	
	public void stateChanged(ChangeEvent e) {
	    JSlider source = (JSlider)e.getSource();
	
	    if(source.getValueIsAdjusting()){
	    Font font = new Font("Serif", Font.ITALIC, 30);
	    //lineColor.setFont(font);
	    }
	   }
	
	
	
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
		
			
			
			
			switch(s){
			
			case "Pencil":
				Drawings.circleOn = false;
				Drawings.dragOn = false;
				Drawings.pencilOn = true;
				Drawings.squareOn = false;
				Drawings.arcOn = false;
				WritingsAndDrawings.typeOn= false;
				Drawings.EDSquareOn = false;
					
				break;
					
			case "Pencil Drag":
				Drawings.circleOn = false;
				Drawings.dragOn = true; //<-----------------
				Drawings.pencilOn = false;
				Drawings.squareOn = false;
				Drawings.arcOn = false;
				WritingsAndDrawings.typeOn= false;
				Drawings.EDSquareOn = false;
				
				break;
					
					
					
					
			case "Circle":	
				
				
				Drawings.circleOn = true;// Circle Activated
				Drawings.squareOn = false;
				Drawings.dragOn = false;
				Drawings.pencilOn = false;
				Drawings.arcOn = false;
				WritingsAndDrawings.typeOn= false;// Keys deactivated
				Drawings.EDSquareOn = false;
				
				break;
				
			case "Square":	
				
				
				Drawings.squareOn = true;//Square Activated
				Drawings.circleOn = false;
				Drawings.dragOn = false;
				Drawings.pencilOn = false;
				Drawings.arcOn = false;
				WritingsAndDrawings.typeOn= false;// Keys deactivated	
				Drawings.EDSquareOn = false;
				
				break;
				
			case "Arc":
				Drawings.arcOn = true;//Arc Activated
				Drawings.squareOn = false;
				Drawings.circleOn = false;
				Drawings.pencilOn = false;// Keys deactivated
				Drawings.dragOn = false;
				WritingsAndDrawings.typeOn= false;
				Drawings.EDSquareOn = false;
				
				break;
			
			case "3D Square":
				Drawings.EDSquareOn = true;
				Drawings.arcOn = false;
				Drawings.squareOn = false;
				Drawings.circleOn = false;
				Drawings.pencilOn = false;// Keys deactivated
				Drawings.dragOn = false;
				WritingsAndDrawings.typeOn= false;
				
				
				break;
				
			case "Eraser":
				Drawings.circleOn = true; 
				Drawings.pencilOn = false;// Keys deactivated
				Drawings.dragOn = true;
				Drawings.EDSquareOn = false;
				Drawings.arcOn = false;
				Drawings.squareOn = false;
				WritingsAndDrawings.typeOn= false;
				
				
				System.out.println("DJSD");
				break;
				
				
			case "Erase":
					
				int yesNo = JOptionPane.showConfirmDialog(null,"Are you sure you want to clear your board?");
					
				if(yesNo == 0){ //yes = 0, no = 1
					clear(mainContent);
					
					System.out.println("Hello man");
				}
				else{
					System.out.println("Chicken");
				}
					break;
				
				case "Type":
					Drawings.circleOn = false;
					Drawings.dragOn = false;
					Drawings.squareOn = false;
					Drawings.pencilOn = false;
					Drawings.arcOn = false;
					WritingsAndDrawings.typeOn = true;// Keys Activated
					
					break;
				
				
			
				case "Colors":
				
					Color bgColor = JColorChooser.showDialog(this, "pick a color", Color.BLUE);
					jpWriteAndDraw.lineColor = bgColor;//set the line color
					jpWriteAndDraw.circleColor = bgColor;
					//jpWriteAndDraw.set bgColor;
					
				break;
				
				case "Save":
					 //public void captureComponent(JPanel mainContent) {
					    Rectangle rect = mainContent.getBounds();

					    
					    try {
					        String format = "png";
					        String fileName = mainContent.getName() + "." + format;
					        BufferedImage captureImage =
						 				                new BufferedImage(rect.width, rect.height,
					                                    BufferedImage.TYPE_INT_ARGB);
					        mainContent.paint(captureImage.getGraphics());
					       
					        
					        ImageIO.write(captureImage, format, new File(fileName));
					 
					        System.out.printf("The screenshot of %s was saved!", mainContent.getName());
					    } catch (IOException ex) {
					        System.err.println(ex);
					    }
					//}		
					
					break;
				
					
				case "Reset":
					Drawings.circleOn = false;
					Drawings.dragOn = false;
					Drawings.squareOn = false;
					Drawings.pencilOn = false;
					Drawings.arcOn = false;
					WritingsAndDrawings.typeOn = false;
					
					
					break;
					
			
				case "About":
					JOptionPane.showMessageDialog(null,"My own version of Microsoft paint, titled " 
							+"Macrosoft Paint©."
							+" Developed for my Internet Programming class Fall 2017");
							
			}
			
			
	}
		
	
	public static void main(String[] args) {
		System.out.println("Will create the gui now");
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				
				RunGUI gui = new RunGUI();
				
			}
		});

		System.out.println("Done with the gui now");
	}

@Override
public void mouseClicked(MouseEvent e) {
	
}



@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}



@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}



@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}



@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}





}
