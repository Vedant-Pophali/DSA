package String;

public class MinimumRemoveToMakeValidParentheses {
    public static String minRemoveToMakeValid(String s) {
    StringBuilder ans = new StringBuilder();
    int open = 0;
    for (char ch : s.toCharArray()) {
        if (ch == '(') {
            open++;
        } else if (ch == ')') {
            if (open == 0)
                continue;
            open--;
        }
        ans.append(ch);
    }
    StringBuilder ansFinal = new StringBuilder();
    for (int i = ans.length()-1; i >= 0; i--) {
        if (ans.charAt(i) == '(' && open-- > 0)
            continue;
        ansFinal.append(ans.charAt(i));
    }
    return
            ansFinal.reverse().toString();
}

    public static void main(String[] args) {
        
        // Test case 1: Balanced parentheses with extra characters
        String test1 = "lee(t(c)o)de)";
        System.out.println( minRemoveToMakeValid(test1)); // Expected output: "lee(t(c)o)de"

        // Test case 2: Unmatched closing parenthesis
        String test2 = "a)b(c)d";
        System.out.println( minRemoveToMakeValid(test2)); // Expected output: "ab(c)d"

        // Test case 3: Multiple unmatched parentheses
        String test3 = "))((";
        System.out.println( minRemoveToMakeValid(test3)); // Expected output: ""

        // Test case 4: Nested parentheses with extra characters
        String test4 = "(a(b(c)d)";
        System.out.println( minRemoveToMakeValid(test4)); // Expected output: "a(b(c)d)"

        // Test case 5: String without any parentheses
        String test5 = "abcde";
        System.out.println( minRemoveToMakeValid(test5)); // Expected output: "abcde"

        // Test case 6: String with only opening parentheses
        String test6 = "((((";
        System.out.println( minRemoveToMakeValid(test6)); // Expected output: ""

        // Test case 7: String with only closing parentheses
        String test7 = "))))";
        System.out.println( minRemoveToMakeValid(test7)); // Expected output: ""

        // Test case 8: Empty string
        String test8 = "";
        System.out.println( minRemoveToMakeValid(test8)); // Expected output: ""

    }
}