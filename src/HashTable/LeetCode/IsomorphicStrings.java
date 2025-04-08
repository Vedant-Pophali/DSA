    package HashTable.LeetCode;

    import java.util.HashMap;
    import java.util.Map;

    public class IsomorphicStrings {
        public static boolean isIsomorphic(String s, String t) {
            if(s.length()!=t.length()) return false;
            Map<Character,Character> mapST = new HashMap<>();
            Map<Character,Character> mapTS = new HashMap<>();
            for(int i=0;i<s.length();i++){
                char sT = s.charAt(i);
                char tS = t.charAt(i);
                if((mapST.containsKey(sT) && mapST.get(sT) != tS) || (mapTS.containsKey(tS) && mapTS.get(tS) != sT))
                    return false;
                mapST.put(sT,tS);
                mapTS.put(tS,sT);
            }
            return true;
        }
        public static void main(String[] args) {
            // Test cases for static method
            System.out.println(isIsomorphic("egg", "add"));     // true
            System.out.println(isIsomorphic("foo", "bar"));     // false
            System.out.println(isIsomorphic("paper", "title")); // true
            System.out.println(isIsomorphic("ab", "aa"));       // false
            System.out.println(isIsomorphic("a", "a"));         // true
        }
    }