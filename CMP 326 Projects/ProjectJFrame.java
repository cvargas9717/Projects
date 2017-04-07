package project1GUI;

import javax.swing.JFrame;
//import javax.swing.JPanel;

public class ProjectJFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	public ProjectJFrame(){
		ProjectJPanel jp = new ProjectJPanel();
		add(jp);
		
		
		setTitle("CMP 326 Project #1");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,400);
		setVisible(true);
		
		
		
		
	}



}
