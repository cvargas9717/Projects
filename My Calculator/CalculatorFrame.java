package GUI;

import javax.swing.JFrame;

public class CalculatorFrame extends JFrame {
	
	public CalculatorFrame(){
		
		CalculatorPanel panel = new CalculatorPanel();
		add(panel);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,300);
		setTitle("Charlie's Calculator");
		setVisible(true);
		
	}


}
