package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorPanel extends JPanel implements ActionListener{
	
	private static JButton add;
	private static JButton sub;
	private static JButton div;
	private static JButton mult;
	private static JTextField num1;
	private static JTextField num2;
	private static JLabel output; 
	
	public CalculatorPanel(){
		
		
		add = new JButton("+"); 
		sub = new JButton("-");
		div = new JButton("/");
		mult = new JButton("*");
		
		num1 = new JTextField("num1",10);
		num2 = new JTextField("num2",10);
		output = new JLabel();
		
		add(num1);
		add(num2);
		add(output);
		add(add);
		add(sub);
		add(div);
		add(mult);
		
		add.addActionListener(this);
		sub.addActionListener(this);
		div.addActionListener(this);
		mult.addActionListener(this);
		
		
	
	}
	
	public int getIntFromTextField(JTextField num1,JTextField num2) throws Exception{
		
	try{
		int a = Integer.parseInt(num1.getText());
		int b = Integer.parseInt(num2.getText());
	}
		catch(Exception e){
			throw new Exception("Wrong inputs"+e.getMessage());
		}
	return 0;
	
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		String actCmd = e.getActionCommand();
		
		int solution = -99999999;
		int a = Integer.parseInt(num1.getText());
		int b = Integer.parseInt(num2.getText());
		
		
		switch(actCmd){
			case "+":
				solution = a + b;
		
			break;
			case "-":
					 solution = a - b;
				break;
				
			case "/":
					solution = a / b;
				break;
			case "*":
					solution = a * b;
				break;
		
		
		}	
		output.setText(a + actCmd + b +" = "+ solution);
	
	
	
	
	}
	
	
	
	
	
	
}
