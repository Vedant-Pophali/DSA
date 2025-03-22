package String;
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs){
     for(int i=0;i<strs.length; i++){
         int current=0;
         if(new StringBuilder((strs[i])).charAt(current)==new StringBuilder(strs[i+i]).charAt(current+1)){}
     }
     return "";
    }

    public static void main(String[] args) {
        // Test cases from LeetCode
        String[] test1 = {"flower", "flow", "flight"};
        System.out.println("Test 1: " + longestCommonPrefix(test1)); // Output: "fl"

        String[] test2 = {"dog", "racecar", "car"};
        System.out.println("Test 2: " +  longestCommonPrefix(test2)); // Output: ""

        String[] test3 = {"interspecies", "interstellar", "interstate"};
        System.out.println("Test 3: " +  longestCommonPrefix(test3)); // Output: "inter"

        String[] test4 = {"apple", "ape", "april"};
        System.out.println("Test 4: " +  longestCommonPrefix(test4)); // Output: "ap"
    }
}