package project1GUI;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ProjectJPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel qdisplay; // JLabel for displaying the program questions
	private JLabel lblOut; //JLabel for displaying all the (longestWords) he/she used in this session
	private JTextField input;//JTextField for the user's response to be typed
	private JButton submitButton; //JButton to allow the user to submit the answer
	private JButton logrequest; //JButton for the user to request all (longestWords) used in this session 
	private JTextArea jt;
	private JLabel a;
	private JButton read;
	
	
	public ProjectJPanel(){
		
		qdisplay = new JLabel("Tell me what is on your mind today in 1 one sentence:");
		lblOut = new JLabel();
		input = new JTextField(10);
		submitButton = new JButton("Submit");
		logrequest = new JButton("Request Log");
		jt = new JTextArea(10,40);
		a = new JLabel();
		read = new JButton("Read Text File");
	
		add(qdisplay);
		add(input);
		add(lblOut);
		add(submitButton);
		add(logrequest);
		add(jt);
		add(read);
		add(a);
		
		//input.addActionListener(this);
		submitButton.addActionListener(this);
		logrequest.addActionListener(this);
		read.addActionListener(this);
	}
	
	
	
		@Override
		public void actionPerformed(ActionEvent e){
		String actCmd = e.getActionCommand();
		
		switch(actCmd){
			case "Submit":
				
				String str = input.getText();
				String[]words = str.split(" ");
				String shortest = words[0];
				String longest = "";
			
				
				for(String words1 : words){
					if(words1.length() < shortest.length()){
						shortest = words1;
					}
					else if(words1.length() > longest.length()){
						longest = words1;
						}
				
				}
				
				if(longest.length() < 3){
					lblOut.setText("Is there anything else you would like to discuss?");
				}
				else if(longest.length() == 3){
					lblOut.setText("Why do you feel "+"'"+longest +"'"+ " is important?");
				}
				else if(longest.length() == 4){
					lblOut.setText("OK tell me more about "+"'" +longest+"'");
				}
				else if(longest.length() == 5){
					lblOut.setText("How does "+"'"+longest+"'"+" affect you?");

				}
				else if(longest.length() > 5){
					lblOut.setText("We seem to be making great progress with: "+"'"+longest+"'");

				}
				//System.out.println("Shortest words is: "+shortest+"\nLongest words is "+longest);
				break;
				
			case "Request Log":
				 String fileName = "RequestedLog.txt"; //The name could be read from keyboard
				   PrintWriter outputStream = null;        
				   try{
					   outputStream = new PrintWriter(fileName);
					   outputStream.println(qdisplay.getText());
					   outputStream.println(input.getText());
					   outputStream.println(lblOut.getText());
					   outputStream.close();
					   a.setText("The name of your file is: "+fileName);
				   }catch(FileNotFoundException exc){
						   System.out.println("Error opening the file" + fileName);
						   System.exit(0);        
						  } 
				break;
			case "Read Text File":
				
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				String filename = f.getAbsolutePath();
			
			try{
				FileReader reader = new FileReader(filename);
				BufferedReader br = new BufferedReader(reader); 
				jt.read(br,null);
				br.close();
				jt.requestFocus();
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null,ex);
			}
				
				break;
			default:
				lblOut.setText("What the hell happened?");
				break;
		
		
			}
		
		}

		
	}
		
		
		
		
		
	


