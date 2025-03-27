package Sets_HashMaps;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i))
                return true;
            set.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4, 5})); // Output: false
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4, 1})); // Output: true
        System.out.println(containsDuplicate(new int[]{10, 20, 30, 40, 50, 10})); // Output: true
        System.out.println(containsDuplicate(new int[]{7, 8, 9, 10, 11})); // Output: false
        System.out.println(containsDuplicate(new int[]{5, 5, 5, 5, 5})); // Output: true
    }
}
