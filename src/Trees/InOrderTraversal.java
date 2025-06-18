package Trees;
import java.util.*;
public class InOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: [1,null,2,3]
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);
        System.out.println("Test Case 1: " + solution.inorderTraversal(root1)); // [1, 3, 2]

        // Test Case 2: []
        TreeNode root2 = null;
        System.out.println("Test Case 2: " + solution.inorderTraversal(root2)); // []

        // Test Case 3: [1]
        TreeNode root3 = new TreeNode(1);
        System.out.println("Test Case 3: " + solution.inorderTraversal(root3)); // [1]

        // Test Case 4: [1,2]
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        System.out.println("Test Case 4: " + solution.inorderTraversal(root4)); // [2, 1]

        // Test Case 5: [1,null,2]
        TreeNode root5 = new TreeNode(1);
        root5.right = new TreeNode(2);
        System.out.println("Test Case 5: " + solution.inorderTraversal(root5)); // [1, 2]
    }

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Solution class to perform inorder traversal
    static class Solution {
        private List<Integer> answer;

        public List<Integer> inorderTraversal(TreeNode root) {
            this.answer = new ArrayList<>();
            inOrder(root);
            return this.answer;
        }

        private void inOrder(TreeNode node) {
            if (node != null) {
                inOrder(node.left);
                this.answer.add(node.val);
                inOrder(node.right);
            }
        }
    }
}