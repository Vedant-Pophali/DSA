package DynamicProgramming;
public class LongestPalinSubstring {
    public String longestPalindrome(String s) {
        if (s.length() <= 1)
            return s;

        String LPS = "";
        for (int i = 1; i < s.length(); i++) {
            // Odd length palindrome
            int low = i, high = i;
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
            }
            String palin = s.substring(low + 1, high);
            if (palin.length() > LPS.length()) {
                LPS = palin;
            }

            // Even length palindrome
            low = i - 1;
            high = i;
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
            }
            palin = s.substring(low + 1, high);
            if (palin.length() > LPS.length()) {
                LPS = palin;
            }
        }

        return LPS;
    }

    public static void main(String[] args) {
        LongestPalinSubstring lps = new LongestPalinSubstring();

        String[] testStrings = {
                "babad",      // Expected: "bab" or "aba"
                "cbbd",       // Expected: "bb"
                "a",          // Expected: "a"
                "ac",         // Expected: "a" or "c"
                "forgeeksskeegfor"  // Expected: "geeksskeeg"
        };

        for (int i = 0; i < testStrings.length; i++) {
            String input = testStrings[i];
            String result = lps.longestPalindrome(input);
            System.out.println("Test Case " + (i + 1) + ":");
            System.out.println("Input: \"" + input + "\"");
            System.out.println("Longest Palindromic Substring: \"" + result + "\"");
            System.out.println("--------------------------------------");
        }
    }
}