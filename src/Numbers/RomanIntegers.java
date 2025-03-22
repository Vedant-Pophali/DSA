package Numbers;
public class RomanIntegers {
    public int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int currentVal = getValue(s.charAt(i));
            if (i + 1 < s.length() && currentVal < getValue(s.charAt(i + 1))) {
                sum -= currentVal;
            } else {
                sum += currentVal;
            }
        }
        return sum;
    }
    private static int getValue(char c) {
            switch (c) {
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return 10;
                case 'L':
                    return 50;
                case 'C':
                    return 100;
                case 'D':
                    return 500;
                case 'M':
                    return 1000;
                default:
                    return 0;
            }
    }
    public static void main(String[] args) {
        RomanIntegers obj = new RomanIntegers();
        String roman = "MCMXCIV";
        int result = obj.romanToInt(roman);
        System.out.println("Integer value of Roman numeral: " + result);
    }

}
