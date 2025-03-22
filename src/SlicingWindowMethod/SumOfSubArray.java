package SlicingWindowMethod;

public class SumOfSubArray {
    public static void main(String[] args) {
        int arr[] = {10, 2, 7, 8, 11, 13};
        int sum = 0, k = 4, size = arr.length;

        // Calculating the sum of the first 'k' elements
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        System.out.println("Initial Sum of first " + k + " elements: " + sum);

        // Sliding window to calculate the sum of the remaining subarrays of size 'k'
        for (int i = 1; i < size - k + 1; i++) {
            sum = sum - arr[i - 1] + arr[i + k - 1];
            System.out.println("Sum of subarray starting at index " + i + ": " + sum);
        }
    }
}
