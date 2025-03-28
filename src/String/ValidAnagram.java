package String;

import java.util.Arrays;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr, tArr);
    }
        public static void main(String[] args) {
            String[][] testCases = {
                    {"listen", "silent"}, {"triangle", "integral"}, {"apple", "papel"},
                    {"rat", "car"}, {"night", "thing"}, {"evil", "vile"},
                    {"dusty", "study"}, {"save", "vase"}, {"angel", "glean"},
                    {"state", "taste"}, {"stressed", "desserts"}, {"fluster", "restful"},
                    {"enlist", "listen"}, {"brag", "grab"}, {"schoolmaster", "theclassroom"},
                    {"conversation", "voicesranton"}, {"debitcard", "badcredit"},
                    {"astronomer", "moonstarer"}, {"dormitory", "dirtyroom"},
                    {"funeral", "realfun"}, {"adultery", "trueLady"}, {"elvis", "lives"},
                    {"punishments", "nineThumps"}, {"cinema", "iceman"}, {"iceman", "cinema"},
                    {"motherinlaw", "womanhitler"}, {"roastbeef", "eatforbs"},
                    {"slotmachines", "cashlostinme"}, {"aabb", "abab"}, {"abc", "def"},
                    {"xyz", "yxz"}, {"hello", "world"}, {"test", "tset"}, {"abcd", "dcba"}
            };

            for (String[] testCase : testCases) {
                System.out.println(testCase[0] + " & " + testCase[1] + " -> " + isAnagram(testCase[0], testCase[1]));
            }
        }
}