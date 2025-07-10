package ArrayDSA;

public class SingleNumber { public static int singleNumber(int[] nums) {
    int result = 0;
    for (int num : nums) {
        result ^= num;  // XOR cancels out duplicates
    }
    return result;
}

    public static void main(String[] args) {
        // Test Case 1: Single odd occurrence
        System.out.println("Test 1: " + singleNumber(new int[]{2, 2, 1})); // 1

        // Test Case 2: Larger set
        System.out.println("Test 2: " + singleNumber(new int[]{4, 1, 2, 1, 2})); // 4

        // Test Case 3: Single element
        System.out.println("Test 3: " + singleNumber(new int[]{7})); // 7

        // Test Case 4: Negative numbers
        System.out.println("Test 4: " + singleNumber(new int[]{-1, -1, -5})); // -5

        // Test Case 5: Mix of positives and negatives
        System.out.println("Test 5: " + singleNumber(new int[]{10, -2, 10, -2, 3})); // 3
    }
}