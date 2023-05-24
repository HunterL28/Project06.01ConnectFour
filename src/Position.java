/**
 * Creating a position object that holds the x and y coordinates of a position on the board
 * borrowed from 24scurria because of a missed class
 * @author 24levinson
 * @version 5/25/2023
 */
public class Position {
    private int col;
    private int row;

    /**
     * Constructor for a position object
     * @param row the row of the position
     * @param col the column of the position
     */
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * @return the column of the position
     */
    public int getCol() {
        return col;
    }
    /**
     * @return the row of the position
     */
    public int getRow() {
        return row;
    }
    /**
     * set the column in Position to the one that was passed in as a parameter
     */
    public void setCol(int col) {
        this.col = col;
    }
    /**
     * set the row in Position to the one that was passed in as a parameter
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Equals method tests if two positions are equal by comparing their rows and columns
     * @param other Position being compared to
     * @return true if the rows and columns are the same, false otherwise
     */
    public boolean equals(Object other) {
        if(other instanceof Position) {
            Position temp = (Position)other;
            return this.row == temp.row && this.col == temp.col;
        }
        return false;
    }
}
