package Numbers;

public class Palindrome {
    public boolean isPalindrome(int x) {
        String initial = x+"";
        String reversed = new StringBuilder(initial).reverse().toString();
        if (initial.equals(reversed)) {
            return true;
        } else
            return false;
    }
    public static void main(String[] args) {
        Palindrome obj = new Palindrome();
        int num = 121;
        boolean result = obj.isPalindrome(num);
        System.out.println("Is palindrome: " + result);
    }
}