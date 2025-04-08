package DAA;

public class SimplexMethod {
    private static double[][] a;
    private static int m, n;
    private static int[] bv;

    public static void init(double[][] inp, int vars, int cons) {
        n = vars;
        m = cons;
        a = new double[m + 1][n + m + 1];
        for (int i = 0; i < m; i++) {
            System.arraycopy(inp[i], 0, a[i], 0, n + m + 1);
        }
        System.arraycopy(inp[m], 0, a[m], 0, n + m + 1);
        bv = new int[m];
        for (int i = 0; i < m; i++) {
            bv[i] = n + i;
        }
    }

    private static void run() {
        while (true) {
            int pc = inVar();
            if (pc == -1) break;
            int pr = outVar(pc);
            if (pr == -1) {
                System.out.println("Unbounded");
                return;
            }
            pivot(pr, pc);
            bv[pr] = pc;
        }
        show();
    }

    private static int inVar() {
        int pc = -1;
        double min = 0;
        for (int j = 0; j < n + m; j++) {
            if (a[m][j] < min) {
                min = a[m][j];
                pc = j;
            }
        }
        return pc;
    }

    private static int outVar(int pc) {
        int pr = -1;
        double min = Double.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            if (a[i][pc] > 0) {
                double r = a[i][n + m] / a[i][pc];
                if (r < min) {
                    min = r;
                    pr = i;
                }
            }
        }
        return pr;
    }

    private static void pivot(int pr, int pc) {
        double pe = a[pr][pc];
        for (int j = 0; j <= n + m; j++) {
            a[pr][j] /= pe;
        }
        for (int i = 0; i <= m; i++) {
            if (i != pr) {
                double f = a[i][pc];
                for (int j = 0; j <= n + m; j++) {
                    a[i][j] -= f * a[pr][j];
                }
            }
        }
    }

    private static void show() {
        System.out.println("Final Table:");
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n + m; j++) {
                System.out.printf("%8.2f ", a[i][j]);
            }
            System.out.println();
        }
        System.out.println("Z = " + a[m][n + m]);
        for (int i = 0; i < m; i++) {
            if (bv[i] < n) {
                System.out.println("x" + (bv[i] + 1) + " = " + a[i][n + m]);
            }
        }
    }

    public static void main(String[] args) {
        int vars = 2;
        int cons = 2;
        double[][] inp = {
                {1, 2, 1, 0, 200},
                {2, 3, 0, 1, 300},
                {-3, -5, 0, 0, 0}
        };
        init(inp, vars, cons);
        run();
    }
}