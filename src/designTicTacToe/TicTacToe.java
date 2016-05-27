package designTicTacToe;

public class TicTacToe {
    private int n;
    private char[][] grid;
    private boolean[][] checkX;
    private boolean[][] checkY;
    private int[] countRow;
    private int[] countCol;
    private int[] countDiagonal;
    
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
    	this.n = n;
        this.grid = new char[n][n];
        this.checkX = new boolean[3][n];
        this.checkY = new boolean[3][n];
        this.countRow = new int[n];
        this.countCol = new int[n];
        this.countDiagonal = new int[2];
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < n; j++){
            	if(i == 2 && j > 1) break;
                checkX[i][j] = true;
                checkY[i][j] = true;
            }
        }
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        char c = player == 1 ? 'X' : 'Y';
        this.grid[row][col] = c;
        countRow[row]++;
        countCol[col]++;
        if(player == 1){
            checkY[0][row] = false;
            checkY[1][col] = false;
            if(countRow[row] == n && checkX[0][row]) return player;
            if(countCol[col] == n && checkX[1][col]) return player;
            if(row == col){
                checkY[2][0] = false;
                countDiagonal[0]++;
                if(countDiagonal[0] == n && checkX[2][0]) return player;
            }
            if(row+col == n-1){
                checkY[2][1] = false;
                countDiagonal[1]++;
                if(countDiagonal[1] == n && checkX[2][1]) return player;
            }
        }else{
            checkX[0][row] = false;
            checkX[1][col] = false;
            if(countRow[row] == n && checkY[0][row]) return player;
            if(countCol[col] == n && checkY[1][col]) return player;
            if(row == col){
                checkX[2][0] = false;
                countDiagonal[0]++;
                if(countDiagonal[0] == n && checkY[2][0]) return player;
            }
            if(row+col == n-1){
                checkX[2][1] = false;
                countDiagonal[1]++;
                if(countDiagonal[1] == n && checkY[2][1]) return player;
            }
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */