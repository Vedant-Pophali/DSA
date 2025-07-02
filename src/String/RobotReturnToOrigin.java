package String;

public class RobotReturnToOrigin {public static boolean judgeCircle(String moves) {
    int[] check = new int[128];
    for (char c : moves.toCharArray()) {
        check[c]++;
    }
    return check['L'] == check['R'] && check['U'] == check['D'];
}    public static void main(String[] args) {
        // Test case 1: Equal L and R, U and D
        System.out.println("Test 1: " + judgeCircle("UD")); // true

        // Test case 2: More L than R
        System.out.println("Test 2: " + judgeCircle("LL")); // false

        // Test case 3: Back to origin
        System.out.println("Test 3: " + judgeCircle("UDLR")); // true

        // Test case 4: Unbalanced moves
        System.out.println("Test 4: " + judgeCircle("UUDDLLRR")); // true

        // Test case 5: One extra U
        System.out.println("Test 5: " + judgeCircle("UUDDLR")); // false
    }
}