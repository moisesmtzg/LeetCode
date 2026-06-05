package letcode2026;

import java.util.Arrays;

public class TicTacToe {
    int[][] board;
    int n;
    public TicTacToe(int n){
        this.board = new int[n][n];
        this.n = n;
    }

    public int move (int col, int row, int player){
        board[col][row] = player;
        System.out.println(Arrays.deepToString(board));
        return 0;
    }

    public static void main (String[] args){
        TicTacToe t = new TicTacToe(3);
        t.move(0,0,1);
        t.move(0,1,1);
        t.move(0,2,2);

    }
}
