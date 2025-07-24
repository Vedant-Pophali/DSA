package ArrayDSA;

public class CheckIf_ItsAStraightLine {

    // Helper method to check if 3 points are collinear using cross-product
    public boolean onLine(int[] p1, int[] p2, int[] p3) {
        int x = p1[0], y = p1[1];
        int x1 = p2[0], y1 = p2[1];
        int x2 = p3[0], y2 = p3[1];
        return ((y - y1) * (x2 - x1)) == ((y2 - y1) * (x - x1));
    }

    // Main logic: check if all points lie on the same line
    public boolean checkStraightLine(int[][] coordinates) {
        for (int i = 2; i < coordinates.length; i++) {
            if (!onLine(coordinates[i], coordinates[0], coordinates[1])) {
                return false;
            }
        }
        return true;
    }

    // Main method with test cases
    public static void main(String[] args) {
        CheckIf_ItsAStraightLine checker = new CheckIf_ItsAStraightLine();

        int[][] coords1 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        System.out.println("Test 1 (should be true): " + checker.checkStraightLine(coords1));

        int[][] coords2 = {{1, 1}, {2, 2}, {3, 4}};
        System.out.println("Test 2 (should be false): " + checker.checkStraightLine(coords2));

        int[][] coords3 = {{0, 0}, {0, 1}, {0, 2}};
        System.out.println("Test 3 (should be true): " + checker.checkStraightLine(coords3));

        int[][] coords4 = {{1, -1}, {2, -2}, {3, -3}};
        System.out.println("Test 4 (should be true): " + checker.checkStraightLine(coords4));

        int[][] coords5 = {{1, 1}, {1, 1}, {1, 1}};
        System.out.println("Test 5 (should be true): " + checker.checkStraightLine(coords5));
    }
}