package connect4;

public interface Connect4Interface {
	public void displayBoard();	
	public void clearBoard();
	public void displayWinner();
	public void takeATurn();
	public void updateCurrPlayer();
	public boolean isFull();
	public int availableRow(int col);
}
