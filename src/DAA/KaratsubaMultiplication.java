package DAA;

public class KaratsubaMultiplication {

    public static String multiply(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();

        if (lenA == 0 || lenB == 0) return "0";

        if (lenA == 1 && lenB == 1)
            return Integer.toString((a.charAt(0) - '0') * (b.charAt(0) - '0'));

        int maxLen = Math.max(lenA, lenB);
        int half = maxLen / 2;

        a = padZeros(a, maxLen - lenA);
        b = padZeros(b, maxLen - lenB);

        String aHigh = a.substring(0, maxLen - half);
        String aLow = a.substring(maxLen - half);
        String bHigh = b.substring(0, maxLen - half);
        String bLow = b.substring(maxLen - half);

        String z0 = multiply(aLow, bLow);
        String z1 = multiply(add(aLow, aHigh), add(bLow, bHigh));
        String z2 = multiply(aHigh, bHigh);

        String part1 = addZeros(z2, 2 * half);
        String part2 = addZeros(subtract(subtract(z1, z2), z0), half);

        return add(add(part1, part2), z0);
    }

    private static String padZeros(String s, int n) {
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) sb.append("0");
        return sb.append(s).toString();
    }

    private static String addZeros(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        while (n-- > 0) sb.append("0");
        return sb.toString();
    }

    private static String add(String x, String y) {
        StringBuilder res = new StringBuilder();
        int carry = 0, i = x.length() - 1, j = y.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) sum += x.charAt(i--) - '0';
            if (j >= 0) sum += y.charAt(j--) - '0';
            res.append(sum % 10);
            carry = sum / 10;
        }
        return res.reverse().toString();
    }

    private static String subtract(String x, String y) {
        StringBuilder res = new StringBuilder();
        int borrow = 0, i = x.length() - 1, j = y.length() - 1;

        while (i >= 0) {
            int a = x.charAt(i--) - '0';
            int b = j >= 0 ? y.charAt(j--) - '0' : 0;
            int diff = a - b - borrow;
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else borrow = 0;
            res.append(diff);
        }

        return res.reverse().toString().replaceFirst("^0+(?!$)", "");
    }

    public static void main(String[] args) {
        String a = "123456789123456789123456789123456789";
        String b = "987654321987654321987654321987654321";
        String result = multiply(a, b);
        System.out.println("Result of Karatsuba Multiplication:\n" + result);
    }
}
