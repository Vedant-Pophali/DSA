package DynamicProgramming;
import java.util.*;

class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // empty string is breakable

        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= Math.max(0, i - maxLen); j--) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();

        List<String> dict1 = Arrays.asList("leet", "code");
        List<String> dict2 = Arrays.asList("apple", "pen");
        List<String> dict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        List<String> dict4 = Arrays.asList("a", "abc", "b", "cd");
        List<String> dict5 = Arrays.asList("aaaa", "aaa");

        String[] testStrings = {
                "leetcode",
                "applepenapple",
                "catsandog",
                "abcd",
                "aaaaaaa"
        };

        List<List<String>> dicts = Arrays.asList(dict1, dict2, dict3, dict4, dict5);

        for (int i = 0; i < testStrings.length; i++) {
            String input = testStrings[i];
            List<String> dict = dicts.get(i);
            boolean result = wb.wordBreak(input, dict);
            System.out.println("Test Case " + (i + 1) + ":");
            System.out.println("Input: \"" + input + "\"");
            System.out.println("Dictionary: " + dict);
            System.out.println("Can be segmented: " + result);
            System.out.println("--------------------------------------");
        }
    }
}