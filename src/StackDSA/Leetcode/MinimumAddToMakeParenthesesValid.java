    package StackDSA.Leetcode;

    public class MinimumAddToMakeParenthesesValid {
            public int minAddToMakeValid(String s) {
                int openCount = 0;
                int closeCount = 0;

                for (int i = 0; i < s.length(); i++) {
                    char ch = s.charAt(i);
                    if (ch == '(') {
                        openCount++;
                    } else if (ch == ')') {
                        if (openCount > 0) {
                            openCount--;
                        } else {
                            closeCount++;
                        }
                    }
                }
                return openCount + closeCount;
            }

        public static void main(String[] args) {
            MinimumAddToMakeParenthesesValid solution = new MinimumAddToMakeParenthesesValid();
            String[] testCases = {
                    "())",      // Output: 1
                    "(((",      // Output: 3
                    "()",       // Output: 0
                    "()))((",   // Output: 4
                    "((())())", // Output: 0
                    ")))((("    // Output: 6
            };
            for (String testCase : testCases) {
                System.out.println("Input: " + testCase + " -> Output: " + solution.minAddToMakeValid(testCase));
            }
        }
}