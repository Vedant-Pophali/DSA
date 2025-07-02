package String;

public class AddStrings {
    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int digit1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        // Test Case 1: Normal case
        System.out.println("Test 1: " + addStrings("123", "456")); // 579

        // Test Case 2: With carryover
        System.out.println("Test 2: " + addStrings("99", "1")); // 100

        // Test Case 3: Unequal lengths
        System.out.println("Test 3: " + addStrings("1", "999")); // 1000

        // Test Case 4: Both zeros
        System.out.println("Test 4: " + addStrings("0", "0")); // 0

        // Test Case 5: Large numbers
        System.out.println("Test 5: " + addStrings("987654321987654321", "123456789123456789")); // 1111111111111111110
    }
}