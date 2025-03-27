package Sets_HashMaps;

import java.util.HashMap;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency of characters in magazine
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Check if ransomNote can be formed
        for (char c : ransomNote.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;  // Not enough characters
            }
            map.put(c, map.get(c) - 1);  // Use one character
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));       // false
        System.out.println(canConstruct("aa", "ab"));     // false
        System.out.println(canConstruct("aa", "aab"));    // true
    }
}
