package ArrayDSA;

import java.util.Arrays;

class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int i = 0;
        for (int j = 0; j < len; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        RemoveElement sol = new RemoveElement();

        int[][] testArrays = {
                {3, 2, 2, 3},
                {0, 1, 2, 2, 3, 0, 4, 2},
                {1, 1, 1, 1},
                {4, 5, 6},
                {}
        };

        int[] testVals = {
                3, 2, 1, 4, 0
        };

        for (int t = 0; t < testArrays.length; t++) {
            int[] arr = testArrays[t];
            int val = testVals[t];
            int[] inputCopy = Arrays.copyOf(arr, arr.length); // Preserve original for display

            System.out.println("Test Case " + (t + 1) + ":");
            System.out.println("Original Array: " + Arrays.toString(inputCopy));
            System.out.println("Value to remove: " + val);

            int newLength = sol.removeElement(arr, val);
            System.out.print("Modified Array: [");
            for (int i = 0; i < newLength; i++) {
                System.out.print(arr[i]);
                if (i < newLength - 1) System.out.print(", ");
            }
            System.out.println("]");
            System.out.println("New Length: " + newLength);
            System.out.println("--------------------------------------");
        }
    }
}