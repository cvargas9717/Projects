package connect4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import tictactoe.GUI_TicTacToe;

public class Connect4 extends JFrame implements ActionListener,Connect4Interface{

	private static final JButton EMPTY = null;
	private JPanel jpMain;
	private JPanel jpBoard;
	private JPanel jpIO;
	private JLabel displayOut;
	private JButton [][] board; // = new JButton [6][7];
	private String currPlayer = "Red";
	private JButton [][]buttons;
	private JLabel [][]arrows;
	
	
	public Connect4() {

		this.setTitle("Connect 4");
		
        jpMain = new JPanel();
		jpMain.setLayout(new BorderLayout());
	
		jpIO = new JPanel();
		displayOut = new JLabel();
		
		//method to update display...
		updateOut("Let's play ! \'"+currPlayer+"\' goes first");
		
		jpIO.add(displayOut);
		jpMain.add(jpIO,BorderLayout.NORTH ); //add the jpIO to the bottom of the main jpanel
	
		jpBoard = new JPanel();
		jpBoard.setLayout(new GridLayout(7,8));
		
		//method to make the buttons listen and add the board of buttons to the jpanel
		displayBoard();
		
		jpMain.add(jpBoard); //add the jpanel with the buttons to the main
		add(jpMain);//,BorderLayout.CENTER
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setVisible(true);
		
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args)  {
		
	javax.swing.SwingUtilities.invokeLater( new Runnable(){
			public void run() {
				Connect4 gui = new Connect4();
			}	
		});
	
	}
	
	public void updateOut(String msg){
		
			if (currPlayer=="Red"){
		    displayOut.setText("<HTML><H1 color=red>"+msg+"</H1></HTML>");
			}
			else if(currPlayer =="Yellow"){
				displayOut.setText("<HTML><H1 color=yellow>"+msg+"</H1></HTML>");
				
				}
			
		}

	
	
	public void playAnotherGame(){
		JOptionPane.showMessageDialog(null,currPlayer +" is the winner!");
		int yesNo = JOptionPane.showConfirmDialog(null, "Do you want to play another game?");
		if(yesNo == 0){
			clearBoard();
			updateOut(currPlayer+" goes first!");
		}
		else{
			updateOut("Thanks for playing");
			JOptionPane.showMessageDialog(null, "BYE");
			System.exit(EXIT_ON_CLOSE);
		}
		System.out.println(yesNo);
	}
	@Override
	public void actionPerformed(ActionEvent e){
		JButton btnClicked = (JButton)e.getSource();
		
		btnClicked.setText(currPlayer);
		btnClicked.setEnabled(false);//disable the clicking
		
		
		
		if(this.currPlayer =="Red"){
			ImageIcon img = new ImageIcon("C:/Users/Charlie/Desktop/CMP 327 Spring 2017/src/connect4/red.png");
			btnClicked.setIcon(img);
			btnClicked.setAlignmentX(CENTER_ALIGNMENT);
			btnClicked.setDisabledIcon(img);
			
				
			
			//btnClicked.setBackground(Color.RED);
		}
		else if(this.currPlayer =="Yellow"){
			ImageIcon img = new ImageIcon("C:/Users/Charlie/Desktop/CMP 327 Spring 2017/src/connect4/yellow.jpg");
			btnClicked.setIcon(img);
			btnClicked.setDisabledIcon(img);
			//btnClicked.setBackground(Color.YELLOW);
		}
		
		if(this.isWinner(currPlayer) || isFull()){
			displayWinner();//could use a counter ... at the top of class for winner only after 4
			playAnotherGame();//ask to play another game????
		}
					
		
		updateCurrPlayer();
		updateOut(this.currPlayer + " goes now");
		
		}
	
	
	
	
	
	
	public void displayBoard(){
		board = new JButton[6][7];
		arrows = new JLabel[1][7];
		for(int row=0;row<arrows.length;row++){
			for(int col=0;col<arrows[row].length;col++){
				
				arrows[row][col] = new JLabel(new ImageIcon("C:/Users/Charlie/Desktop/CMP 327 Spring 2017/src/connect4/down_arrow.gif"));
				//buttons[row][col]
				arrows[row][col].setFont(new Font(Font.SANS_SERIF,Font.BOLD,10));
				//buttons[row][col].set
				//buttons[row][col].setIcon("giphy.gif");
				//buttons[row][col].set
				//buttons[row][col].addActionListener(this); //make it trigger the actionPerformed
				arrows[row][col].setEnabled(true);//make it clickable
				
				jpBoard.add(arrows[row][col],BorderLayout.NORTH);
			}
		}
		for(int row=0;row<board.length;row++){
			for(int col=0;col<board[row].length;col++){
				
				board[row][col] = new JButton();
				board[row][col].setFont(new Font(Font.SANS_SERIF,Font.BOLD,1));
				board[row][col].addActionListener(this); //make it trigger the actionPerformed
				board[row][col].setEnabled(true);//make it clickable
				//board[row][col].setSize(50, 50);
				jpBoard.add(board[row][col]);
			}
		}
	}
	@Override
	public void clearBoard() {
		for(int row=0; row<board.length; row++){
			for(int col=0; col<board[row].length; col++){
				board[row][col].setText("");
				board[row][col].setIcon(null);
				board[row][col].setEnabled(true);
				board[row][col].setBackground(null);
			}
		}
		
	}
	@Override
	public void displayWinner() {
		if(this.isWinner("Red")){
			updateOut("Red is the winner");
			
		}
		else if(this.isWinner("Yellow")){
			updateOut("Yellow is the winner");
		}
		else{
			updateOut("DRAW!!!");
		}
		
	}
	
	@Override
	public void takeATurn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCurrPlayer() {
		if(currPlayer.equalsIgnoreCase("Red")){
			currPlayer = "Yellow";
		}
		else if(currPlayer.equalsIgnoreCase("Yellow")){
			currPlayer = "Red";
		}
	}
	
	
	public boolean isWinner(String player) {
		//check rows
				for(int row=0; row<board.length;row++){
					int rowCount=0;//row match counter, resets on next row
					for(int col=0; col<board[row].length; col++){
						if(board[row][col].getText().contains(player)){
							rowCount++;//increment counter
							if(rowCount == 4){
								return true;//found 4 in same row
							}
						
						}
					
					}
					
				}
				
				//check columns
				for(int col=0; col<7; col++){
					int colCount=0;
					for(int row=0; row<6; row++){
						if(board[row][col].getText().contains(player)){
							colCount++;
							if(colCount ==4){
								return true;//found 4 in same column
							}
						}
					}
				}
				
				/*//check main diagonal [0][0],[1][1],[2][2],[3][3],[4][4],[5][5]
				for(int i=0; i<board.length; i++){
					int diagCount=0;
					for(int j=0; j<board.length; j++){
					if(board[i][j].getText().contains(player)){
						diagCount++;
						if(diagCount==4){
							return true;//found 3 same across main diagonal
							}
						}	
					}
				}	
					*/
				//check main diagonal [0][0],[1][1],[2][2],[3][3],[4][4],[5][5]
				int diagCount=0;
				int row=0;
				int col = 0;
				while(row <=5 && col<=5){
					if(board[row][col].getText().contains(player)){
						diagCount++;
						if(diagCount ==4){
							return true;//found 3 same across secondary diagonal
						}
					}
					row++;
					col++;
				}
				
				
				
				
				
				
				
				//check secondary diagonal [5][0],[4][1],[3][2],[2][3],[1][4],[0][5]
				int diag2Count=0;
				int row1=5;
				int col1 = 0;
				while(row1 >=0 && col1<=5){
					if(board[row1][col1].getText().contains(player)){
						diag2Count++;
						if(diag2Count ==4){
							return true;//found 3 same across secondary diagonal
						}
					}
					row1--;
					col1++;
				}
				
				
			
				
				//new code for the bottom right diagonal [5][6],[4]5],[3][4],[2][3],[1][2],[0][1]
				int diag3count = 0;
				row1 = 0;
				col1 = 1;		
				while(row1 <= 5 && col1<=6){
					
					if(board[row1][col1].getText().contains(player)){
						
						diag3count++;
					if(diag3count ==4){
						return true;//found 3 same across secondary diagonal
						}
					}
					row1++;
					col1++;
				}
				
				 //[0][2],[1][3],[2][4],[3][5],[4][6]
				int diag4count = 0;
				row1 = 0;
				col1 = 2;		
				while(row1 <=5 && col1<=6){
					
					if(board[row1][col1].getText().contains(player)){
						
						diag4count++;
					if(diag4count ==4){
						return true;//found 3 same across secondary diagonal
						}
					}
					row1++;
					col1++;
				}
				
				//[3][6],[2][5],[1][4],[0][3]
				int diag5count = 0;
				row1 = 0;
				col1 = 3;		
				while(row1 <=3 && col1<=6){
					
					if(board[row1][col1].getText().contains(player)){
						
						diag5count++;
					if(diag5count ==4){
						return true;//found 3 same across secondary diagonal
						}
					}
					row1++;
					col1++;
				}
				
				//[5][2],[4][3],[3][4],[2][5],[1][6]
				int diag6count = 0;
				row1 = 5;
				col1 = 2;		
				while(row1 >=1 && col1<=6){
					
					if(board[row1][col1].getText().contains(player)){
						
						diag6count++;
					if(diag6count ==4){
						return true;//found 3 same across secondary diagonal
						}
					}
					row1--;
					col1++;
				}
				
				
				int diag7count = 0;
				row1 = 5;
				col1 = 3;		
				while(row1>=2 && col1<=6){
					
					if(board[row1][col1].getText().contains(player)){
						
						diag7count++;
					if(diag7count ==4){
						return true;//found 3 same across secondary diagonal
						}
					}
					row1--;
					col1++;
				}
				int diag8count = 0;
				row1 = board.length-3;
				col1 = 0;		
				while(row1 >=0 && col1<=3){
					
					if(board[row1][col1].getText().contains(player)){
						
						diag8count++;
					if(diag8count ==4){
						return true;//found 3 same across secondary diagonal
						}
					}
					row1--;
					col1++;
				}
				int diag9count = 0;
				row1 = board.length-2;
				col1 = 0;		
				while(row1 >=0 && col1<=4){
					
					if(board[row1][col1].getText().contains(player)){
						
						diag9count++;
					if(diag9count ==4){
						return true;//found 4 same across secondary diagonal
						}
					}
					row1--;
					col1++;
				}
				
				int diag10count = 0;
				row1 = board.length-1;
				col1 = 1;		
				while(row1 >=0 && col1<=6){
					
					if(board[row1][col1].getText().contains(player)){
						
						diag10count++;
					if(diag10count ==4){
						return true;//found 3 same across secondary diagonal
						}
					}
					row1--;
					col1++;
				}	
				int diag11count = 0;
				row1 = 1;
				col1 = 0;		
				while(row1 <=5 && col1<=4){
					
					if(board[row1][col1].getText().contains(player) ){
						
						diag11count++;
					if(diag11count ==4){
						return true;//found 3 same across secondary diagonal
						}
					}
					row1++;
					col1++;
					
					}
				/*int diag12count = 0;
				row = board.length-1;
				col = 4;		
				while(row >=1 && col<=0){
					
					if(board[row][col].getText().contains(currPlayer)){
						
						diag12count++;
					if(diag12count ==4){
						return true;//found 3 same across secondary diagonal
						}
					}
					row--;
					col--;
				}
				*/
				int diag13count = 0;
				row1 = board.length-4;
				col1 = 0;		
				while(row1 <=5 && col1<=3){
					
					if(board[row1][col1].getText().contains(currPlayer)){
						
						diag13count++;
					if(diag13count ==4){
						return true;//found 3 same across secondary diagonal
						}
					}
					row1++;
					col1++;
				}
				/*
				int Rows=5;
				 int col11=0;
				 while(Rows>=0 && col11<=6){
					 if((board[Rows][col11] != null)){
						 
						 board[Rows][col11+1].setEnabled(true);
						 	board[Rows-2][col11].setEnabled(false);
			                board[Rows-3][col11].setEnabled(false);
			                board[Rows-4][col11].setEnabled(false);
			                board[Rows-5][col11].setEnabled(false);
					 //return true;
					 }
				 
					 Rows--;
					 //col11++;
				 }
				*/
				
				
				
			 /*
				 int Rows=6;
				 int col11=0;
				for( int row11 = Rows -1; row11 >= 0; row11--){ 
		            for(col11 =0; col11<=6;col11++){
					if((board[row11][col11] != null) || board[row11][col11] == null){ 
		                board[row11-2][col11].setEnabled(false);
		                board[row11-3][col11].setEnabled(false);
		                board[row11-4][col11].setEnabled(false);
		                board[row11-5][col11].setEnabled(false);
		                //return true;        	
		            } 
		        }
		            return false;
				}
		    	*/

				return false;

		
	}
	/*@Override
	 public int availableRow(int col){  
	        for( int row = Rows -1; row >= 0; row--){ 
	            if(board[row][col] == EMPTY){ 
	                board[row][col].setEnabled(false);
	            	return row;          	
	            } 
	        }
	        return -1;	
	    }	
      */  
	
	
	
	@Override
	public boolean isFull(){
		for(int row=0; row<board.length; row++){
			for(int col=0; col<board[row].length; col++){
				String text = board[row][col].getText();
				if(!(text.contains("Red")) &&  !(text.contains("Yellow"))){
					return false;
				}
			}
		}
		return true;
	}









	@Override
	public int availableRow(int col) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/*public static boolean putDisk(JButton[][]board ,String b, int col) {
    	// If the first disk is there, the column is filled, returning false.
    	if (board[0][col] != " ")
        	return false;

    	// Check all elements in the column.
    	for (int row = 0; row < 7;row++) {
        	// If we found something, which means if the character is not
        	// zero character
        	if (board[row][col] != "") {
            	// Put the disk on top of the current one.
            	board[row-1][column] = color;
            	return true;
        	}
    	}
    	// If no other disks found, we place this diak at the bottom.
    	field[6][column] = color;
    	return true;
	
	}
*/
	
	
	     
	
}
	
