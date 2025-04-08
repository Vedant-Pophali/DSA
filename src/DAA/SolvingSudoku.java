package DAA;

import java.util.*;

public class SolvingSudoku {
    public static boolean validSudoku(char[][] b) {
        Set<Object> s = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = b[i][j];
                if (c != '.') {
                    if (!s.add(c + " r " + i) || !s.add(c + " c " + j) || !s.add(c + " b " + i / 3 + j / 3))
                        return false;
                }
            }
        }
        return true;
    }

    public static boolean ok(char[][] b, int r, int c, int v) {
        for (int i = 0; i < 9; i++) if (b[i][c] == (char)(v + '0')) return false;
        for (int j = 0; j < 9; j++) if (b[r][j] == (char)(v + '0')) return false;
        int sr = (r / 3) * 3, sc = (c / 3) * 3;
        for (int i = sr; i < sr + 3; i++)
            for (int j = sc; j < sc + 3; j++)
                if (b[i][j] == (char)(v + '0')) return false;
        return true;
    }

    public static boolean fill(char[][] b, int r, int c) {
        if (r == 9) return true;
        int nr = c == 8 ? r + 1 : r;
        int nc = c == 8 ? 0 : c + 1;
        if (b[r][c] != '.') return fill(b, nr, nc);
        for (int i = 1; i <= 9; i++) {
            if (ok(b, r, c, i)) {
                b[r][c] = (char)(i + '0');
                if (fill(b, nr, nc)) return true;
                b[r][c] = '.';
            }
        }
        return false;
    }

    public static void solve(char[][] b) {
        fill(b, 0, 0);
    }

    public static void main(String[] args) {
        char[][] b = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println("Initial:");
        for (char[] r : b) System.out.println(Arrays.toString(r));

        if (validSudoku(b)) {
            System.out.println("\nValid");
            solve(b);
            System.out.println("\nSolved:");
            for (char[] r : b) System.out.println(Arrays.toString(r));
        } else {
            System.out.println("Not valid");
        }
    }
}