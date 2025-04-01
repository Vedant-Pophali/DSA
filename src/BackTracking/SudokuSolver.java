package BackTracking;

import java.util.Arrays;

public class SudokuSolver {
    public static boolean valid(char[][] board,int row,int col,int num){
        //checks in rows and columns
        for(int i=0;i<board.length;i++){
            if(board[i][col]==(char)(num+'0')){
                return false;
            }
        }
        for(int j=0;j<board.length;j++)
            if(board[row][j]==(char)(num+'0')){
                return false;
            }
        //grid
        int startRow=(row/3) * 3;
        int startCol=(col/3) * 3;

        for(int i=startRow;i<startRow+3;i++){
            for(int j=startCol;j<startCol+3;j++){
                if(board[i][j]==(char)(num+'0'))
                    return false;
            }
        }
        return true;
    }

    public static boolean check(char[][] board,int row,int col){
        if(row==board.length)
            return true;

        int nrow=0;
        int ncol=0;
        if(col==board.length-1){
            nrow=row+1;
            ncol=0;
        }
        else{
            nrow=row;
            ncol=col+1;
        }

        if(board[row][col]!='.'){
            if((check(board,nrow,ncol)))return true;
        }
        else{
            for(int i=1;i<10;i++){
                if(valid(board,row,col,i)){
                    board[row][col]=(char)(i+'0');
                    if(check(board,nrow,ncol))
                        return true;
                    else
                        board[row][col]='.';
                }
            }
        }
        return false;
    }

    public static void solveSudoku(char[][] board) {
        check(board,0,0);
    }
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println("Initial Question: ");
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
        solveSudoku(board);

        // Print the solved Sudoku board
        System.out.println("Question Solved: ");
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
