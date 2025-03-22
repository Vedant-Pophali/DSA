package String;

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        String ans = s.strip();
        int last=ans.lastIndexOf(' ');
        return ans.length()-last-1;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World")); // Output: 5
        System.out.println(lengthOfLastWord("   fly me   to   the moon  ")); // Output: 4
        System.out.println(lengthOfLastWord("luffy is still joyboy")); // Output: 6
        System.out.println(lengthOfLastWord("word")); // Output: 4
        System.out.println(lengthOfLastWord("   ")); // Output: 0
    }
}
