package String;
public class MaximumRepeatingSubstring {
    public static int maxRepeatingSubstring(String seq, String word) {
        int count = 0;
        StringBuilder repeatedWord = new StringBuilder(word);
        while (seq.contains(repeatedWord.toString())) {
            count++;
            repeatedWord.append(word);
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(maxRepeatingSubstring("ababc", "ab")); // Output: 2
        System.out.println(maxRepeatingSubstring("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba")); // Output: 3
        System.out.println(maxRepeatingSubstring("ababab", "aba")); // Output: 1
        System.out.println(maxRepeatingSubstring("abc", "d")); // Output: 0
        System.out.println(maxRepeatingSubstring("aaaaa", "a")); // Output: 5
    }
}