package Numbers;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber{
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = sumOfSquares(n);
        }
        return n == 1;
    }
    public int sumOfSquares(int num) {
        int sum = 0;
        while (num != 0) {
            int rem = num % 10;
            sum += (int) Math.pow(rem, 2);
            num /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        HappyNumber obj = new HappyNumber();
        int num = 19;
        boolean result = obj.isHappy(num);
        System.out.println("Is happy number: " + result);
    }
}