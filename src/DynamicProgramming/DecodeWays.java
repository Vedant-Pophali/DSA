package DynamicProgramming;

public class DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));

            if (oneDigit >= 1)
                dp[i] += dp[i - 1];

            if (twoDigit > 9 && twoDigit < 27)
                dp[i] += dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        DecodeWays decoder = new DecodeWays();

        // Test Cases
        String[] testInputs = {
                "12",      // 2: "AB", "L"
                "226",     // 3: "BZ", "VF", "BBF"
                "0",       // 0: Invalid
                "06",      // 0: Starts with 0
                "10",      // 1: "J"
                "2101",    // 1: "U A"
                "11106",   // 2: "AAJF", "KJF"
                "111111",  // 13: many combinations
                "27",      // 1: only "BG" (since 27 is not a valid letter)
                "10011"    // 0: "10" is valid, but "011" breaks it
        };

        for (String input : testInputs) {
            int result = decoder.numDecodings(input);
            System.out.println("Input: \"" + input + "\" => Number of decodings: " + result);
        }
    }
}
