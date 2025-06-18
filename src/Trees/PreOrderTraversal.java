package Trees;
import java.util.*;
public class PreOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: [1,null,2,3]
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);
        System.out.println("Test Case 1: " + solution.preorderTraversal(root1)); // [1, 2, 3]

        // Test Case 2: []
        TreeNode root2 = null;
        System.out.println("Test Case 2: " + solution.preorderTraversal(root2)); // []

        // Test Case 3: [1]
        TreeNode root3 = new TreeNode(1);
        System.out.println("Test Case 3: " + solution.preorderTraversal(root3)); // [1]

        // Test Case 4: [1,2]
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        System.out.println("Test Case 4: " + solution.preorderTraversal(root4)); // [1, 2]

        // Test Case 5: [1,null,2]
        TreeNode root5 = new TreeNode(1);
        root5.right = new TreeNode(2);
        System.out.println("Test Case 5: " + solution.preorderTraversal(root5)); // [1, 2]
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

    // Solution class to perform preorder traversal
    static class Solution {
        private List<Integer> answer;

        public List<Integer> preorderTraversal(TreeNode root) {
            this.answer = new ArrayList<>();
            preOrder(root);
            return this.answer;
        }

        private void preOrder(TreeNode node) {
            if (node != null) {
                this.answer.add(node.val);
                preOrder(node.left);
                preOrder(node.right);
            }
        }
    }
}