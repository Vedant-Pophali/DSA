package BackTracking;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        Set<Object> set = new HashSet<>();
        for(int i=0;i<9;i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if(num!='.'){
                    if(!set.add(num+" in row "+i) ||
                       !set.add(num+" in column "+j) ||
                       !set.add(num+" in block "+i/3+" "+j/3)){
                        return false;
                    }
                }
            }
        }
        return true;
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
        System.out.println(isValidSudoku(board)?"Sudoku is valid":"Sudoku is not invalid");
    }
}
