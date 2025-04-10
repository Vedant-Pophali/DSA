package DAA;
import java.util.ArrayList;
import java.util.List;
public class NQueens {
    List<List<String>> solutions;
    public List<List<String>> solveNQueens(int n) {
        solutions = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(board, 0);
        return solutions;
    }
    private void backtrack(char[][] board, int row) {
        if (row == board.length) {
            solutions.add(convertToSolution(board));
        } else {
            for (int i = 0; i < board[0].length; i++) {
                if (isSafe(board, row, i)) {
                    board[row][i] = 'Q';
                    backtrack(board, row + 1);
                    board[row][i] = '.';
                }
            }
        }
    }
    private boolean isSafe(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
    private List<String> convertToSolution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }
    public static void main(String[] args) {
        NQueens nq = new NQueens();
        int n = 4; // You can change this to test other sizes
        List<List<String>> results = nq.solveNQueens(n);
        System.out.println("Total solutions for " + n + "-Queens: " + results.size());
        int count = 1;
        for (List<String> solution : results) {
            System.out.println("Solution " + count++ + ":");
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}