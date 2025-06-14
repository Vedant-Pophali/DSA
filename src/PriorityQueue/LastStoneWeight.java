package PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            pq.add(stone);
        }
        while (pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();
            if (x != y) {
                pq.add(y - x);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }

    public static void main(String[] args) {
        LastStoneWeight solver = new LastStoneWeight();

        int[][] testCases = {
                {2, 7, 4, 1, 8, 1},   // Expected: 1
                {10, 4, 2, 10},       // Expected: 2
                {1, 1},               // Expected: 0
                {9, 3, 2, 10},        // Expected: 0
                {7, 6, 7, 6, 9}       // Expected: 3
        };

        for (int i = 0; i < testCases.length; i++) {
            int result = solver.lastStoneWeight(testCases[i]);
            System.out.println("Test Case " + (i + 1) + ": Result = " + result);
        }
    }
}