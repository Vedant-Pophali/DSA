package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Implementation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " integers:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the number to search: ");
        int k = sc.nextInt();

        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));

        int start = 0, end = arr.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(arr[mid] > k) {
                end = mid - 1;
            }
            else if(arr[mid] < k) {
                start = mid + 1;
            }
            else {
                System.out.println("Found at index " + mid);
                sc.close();
                return;
            }
        }

        System.out.println("Unable to find " + k);
        sc.close();
    }
}