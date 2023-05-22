public class ConnectFour implements BoardGame{
    private int[][] board;
    private int currentPlayer;
    private Position[] winningPosition;

    private int winner;

    @Override
    public void newGame() {
        board = new int[6][7];
        currentPlayer = 1 + (int)(Math.random()*2);
        winningPosition = new Position[4];
    }

    @Override
    public boolean gameOver() {
        for(int r = board.length-1; r >= 0; r--)   {
            for(int c = 0; c < board[r].length; c++)    {
                int win = 0;
                int x  = board[r][c];
                if(x == 1 || x == 2)    {
                    if(row(x, win, c, r) || column(x, win, c, r) || diagonal(x, win, c, r)) {
                        winner = x;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean row(int x, int win, int c, int r)   {
        for(int col = c; col < board[r].length; col++) {
                if (board[r][col] == x) {
                    win++;
                    //System.out.println(win);
                }
                else
                    win = 0;
                if(win == 4) {
                    for(int i = 3; i >= 0; i--) {
                        winningPosition[i] = new Position(r, col);
                        col--;
                    }
                    return true;
                }
            }
        return false;
    }
    private boolean column(int x, int win, int c, int r)   {
        for(int row = r; row >= 0; row--) {
            if (board[row][c] == x)
                win++;
            else
                win = 0;
            if(win == 4) {
                for(int i = 0; i <= 3; i++) {
                    winningPosition[i] = new Position(row, c);
                    row++;
                }
                return true;
            }
        }
        return false;
    }
    private boolean diagonal(int x, int win, int c, int r)   {
        int col = c;
        int row = r;
        while(col < board[r].length && row >= 0) {
            if (board[row][col] == x)
                win++;
            else
                win = 0;
                if(win == 4) {
                    for(int i = 3; i >= 0; i--) {
                        winningPosition[i] = new Position(row, col);
                        col--;
                        row++;
                    }
                    return true;
                }
            col++;
            row--;
        }
        col = c;
        row = r;
        win = 0;
        while(col < board[r].length && row < board.length) {
            if (board[row][col] == x)
                win++;
            else
                win = 0;
            if(win == 4) {
                for(int i = 3; i >= 0; i--) {
                    winningPosition[i] = new Position(row, col);
                    col--;
                    row--;
                }
                return true;
            }
            col++;
            row++;
        }
        return false;
    }

    @Override
    public int getWinner() {
        return winner;
    }

    @Override
    public Position[] getWinningPositions() {
        return winningPosition;
    }

    @Override
    public boolean columnFull(int column) {
        return board[0][column] != 0;
    }

    @Override
    public void play(int column) {
        if(!columnFull(column)) {
            // go to bottom row, work up to find open spot
            for(int r = 5; r >= 0; r--) {
                if(board[r][column]==0) {
                    board[r][column] = currentPlayer; // place a piece
                    currentPlayer = (currentPlayer == 1) ? 2 : 1;
                    return;
                }
            }
        }
    }

    @Override
    public int[][] getBoard() {
        return board;
    }

    public int getCurrentPlayer(){
    return currentPlayer;
    }
}
