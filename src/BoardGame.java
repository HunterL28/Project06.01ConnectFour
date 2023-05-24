
/**
 * BoardGame describes the behaviors of a 2-person game played
 *   on a rectangular grid.
 * @author 24levinson
 * @version 5/25/2023
 */
public interface BoardGame { 
    /**
     * Prepares the board for a new game.
     */
    public void newGame();  
    
    /**
     * Is the game over?
     * @return true if the game is over, false otherwise
     */
    public boolean gameOver(); 
    
    /**
     * Who is the winner?
     * @return 0 if there is no winner, 1 if the first player is a winner, 2 if the second player is a winner.
     */
    public int getWinner(); 
    
    /**
     * Where are the tokens that determine who the winner is?
     * @return the locations of the pieces that determine the game winner.
     */
    public Position[] getWinningPositions();
    
    /**
     * Does the column have room for an additional move?
     * @param column the column number
     * @return false if there is room for another move in the column, true if not.
     */
    public boolean columnFull(int column);  
    
    /**
     * Change the game to reflect the current player placing a piece in the column.
     * @param column the column number
     */
    public void play(int column);  
    
    /**
     * What is the current board configuration?
     * @return for each cell on the board grid: 
     *   0 if it is not filled, 
	 *   1 if it is filled by the first player's piece, 
	 *   2 if it is filled by the second player's piece.
     */
    public int[][] getBoard();  
}
