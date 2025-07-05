package ArrayDSA;

import java.util.HashMap;

public class LuckyInteger {
    public static int findLucky(int[] arr) {
        HashMap<Integer, Integer> hashMapping = new HashMap<>();

        // Count frequency of each number
        for (int num : arr) {
            hashMapping.put(num, hashMapping.getOrDefault(num, 0) + 1);
        }

        int maxLucky = -1;

        for (int key : hashMapping.keySet()) {
            if (key == hashMapping.get(key)) {
                maxLucky = Math.max(maxLucky, key);
            }
        }
        return maxLucky;
    }

    public static void main(String[] args) {
        // Test Case 1: One lucky integer
        int[] arr1 = {2, 2, 3, 4};
        System.out.println("Test 1: " + findLucky(arr1)); // Output: 2

        // Test Case 2: No lucky integers
        int[] arr2 = {1, 2, 2, 3, 3, 3};
        System.out.println("Test 2: " + findLucky(arr2)); // Output: -1

        // Test Case 3: Multiple lucky integers
        int[] arr3 = {2, 2, 3, 3, 3};
        System.out.println("Test 3: " + findLucky(arr3)); // Output: 3

        // Test Case 4: All elements are the same and lucky
        int[] arr4 = {4, 4, 4, 4};
        System.out.println("Test 4: " + findLucky(arr4)); // Output: 4

        // Test Case 5: Edge case with no lucky numbers
        int[] arr5 = {5, 5, 5, 5, 5};
        System.out.println("Test 5: " + findLucky(arr5)); // Output: -1
    }
}
