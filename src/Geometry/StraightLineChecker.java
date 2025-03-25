package Geometry;

class StraightLineChecker {
    public boolean onLine(int[] p1, int[] p2, int[] p3) {
        int x = p1[0];
        int y = p1[1];
        int x1 = p2[0];
        int y1 = p2[1];
        int x2 = p3[0];
        int y2 = p3[1];
        return ((y - y1) * (x2 - x1)) == ((y2 - y1) * (x - x1));
    }

    public boolean checkStraightLine(int[][] coordinates) {
        for (int i = 2; i < coordinates.length; i++) {
            if (!onLine(coordinates[i], coordinates[0], coordinates[1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        StraightLineChecker checker = new StraightLineChecker();

        // Test Case 1: Points forming a straight line
        int[][] coordinates1 = { {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6} };
        System.out.println(checker.checkStraightLine(coordinates1)); // Expected: true

        // Test Case 2: Points NOT forming a straight line
        int[][] coordinates2 = { {1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6} };
        System.out.println(checker.checkStraightLine(coordinates2)); // Expected: false

        // Test Case 3: Vertical line (same x-coordinates)
        int[][] coordinates3 = { {2, 3}, {2, 5}, {2, 8}, {2, 10} };
        System.out.println(checker.checkStraightLine(coordinates3)); // Expected: true

        // Test Case 4: Horizontal line (same y-coordinates)
        int[][] coordinates4 = { {1, 5}, {3, 5}, {5, 5}, {7, 5} };
        System.out.println(checker.checkStraightLine(coordinates4)); // Expected: true

        // Test Case 5: Only two points (always forms a straight line)
        int[][] coordinates5 = { {0, 0}, {4, 4} };
        System.out.println(checker.checkStraightLine(coordinates5)); // Expected: true
    }
}