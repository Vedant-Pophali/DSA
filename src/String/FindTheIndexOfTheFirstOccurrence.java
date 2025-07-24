package String;

public class FindTheIndexOfTheFirstOccurrence {

    // Function to find the index of the first occurrence
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    // Main method with test cases
    public static void main(String[] args) {
        FindTheIndexOfTheFirstOccurrence finder = new FindTheIndexOfTheFirstOccurrence();

        // Test case 1
        String haystack1 = "hello";
        String needle1 = "ll";
        System.out.println("Test 1 (Expected 2): " + finder.strStr(haystack1, needle1));

        // Test case 2
        String haystack2 = "aaaaa";
        String needle2 = "bba";
        System.out.println("Test 2 (Expected -1): " + finder.strStr(haystack2, needle2));

        // Test case 3
        String haystack3 = "leetcode";
        String needle3 = "leeto";
        System.out.println("Test 3 (Expected -1): " + finder.strStr(haystack3, needle3));

        // Test case 4
        String haystack4 = "mississippi";
        String needle4 = "issip";
        System.out.println("Test 4 (Expected 4): " + finder.strStr(haystack4, needle4));

        // Test case 5
        String haystack5 = "abc";
        String needle5 = "";
        System.out.println("Test 5 (Expected 0): " + finder.strStr(haystack5, needle5)); // by definition
    }
}
