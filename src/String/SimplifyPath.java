package String;

import java.util.Deque;
import java.util.LinkedList;

public class SimplifyPath {public static String simplifyPath(String path) {
    Deque<String> stack = new LinkedList<>();
    String[] parts = path.split("/");

    for (String part : parts) {
        if (part.equals("") || part.equals(".")) {
            continue;
        } else if (part.equals("..")) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        } else {
            stack.push(part);
        }
    }

    StringBuilder result = new StringBuilder();
    for (String dir : stack) {
        result.insert(0, "/" + dir);
    }

    return result.length() == 0 ? "/" : result.toString();
}

    public static void main(String[] args) {
        // Test Case 1: Normal path
        System.out.println("Test 1: " + simplifyPath("/home/")); // /home

        // Test Case 2: Path with ".."
        System.out.println("Test 2: " + simplifyPath("/home//foo/../bar")); // /home/bar

        // Test Case 3: Multiple slashes and "."
        System.out.println("Test 3: " + simplifyPath("/a/./b/../../c/")); // /c

        // Test Case 4: Root navigation
        System.out.println("Test 4: " + simplifyPath("/../")); // /

        // Test Case 5: Deep directory with ".."
        System.out.println("Test 5: " + simplifyPath("/a/../../b/../c//.//")); // /c
    }
}