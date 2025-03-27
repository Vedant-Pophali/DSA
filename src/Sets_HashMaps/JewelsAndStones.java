package Sets_HashMaps;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public static int numJewelsInStones(String jewels, String stones) {
        Set<Character> st = new HashSet<>();
        int count = 0;
        for (int i = 0; i < jewels.length(); i++) {
            char ch = jewels.charAt(i);
            st.add(ch);
        }
        for (int i = 0; i < stones.length(); i++) {
            char ch = stones.charAt(i);
            if (st.contains(ch)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(numJewelsInStones("aA", "aAAbbbb")); // Output: 3
        System.out.println( numJewelsInStones("z", "ZZ")); // Output: 0
        System.out.println(numJewelsInStones("abc", "aabbcc")); // Output: 6
        System.out.println( numJewelsInStones("x", "xxxXx")); // Output: 4
        System.out.println(numJewelsInStones("mno", "mnopqrstuvwxyz")); // Output: 3
    }
}
