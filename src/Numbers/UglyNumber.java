package Numbers;

public class UglyNumber {
    public boolean isUgly(int num) {
        if (num <= 0) return false;  // Ugly numbers are positive.
        if (num == 1) return true;   // 1 is considered an ugly number.

        while (num % 2 == 0) num /= 2;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;

        return num == 1;
    }

    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        System.out.println(uglyNumber.isUgly(50));
        System.out.println(uglyNumber.isUgly(17));

    }
}
