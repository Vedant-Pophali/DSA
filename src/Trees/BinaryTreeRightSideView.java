package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> ans = new LinkedList<>();
        ans.offer(root);

        while (!ans.isEmpty()) {
            int size = ans.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = ans.poll();
                if (i == size - 1) result.add(node.val);
                if (node.left != null) ans.offer(node.left);
                if (node.right != null) ans.offer(node.right);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test Case 1:
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(5)),
                new TreeNode(3, null, new TreeNode(4)));
        System.out.println("Test 1: " + rightSideView(root1)); // [1, 3, 4]

        // Test Case 2:
        TreeNode root2 = new TreeNode(10,
                new TreeNode(8,
                        new TreeNode(6), null),
                new TreeNode(15));
        System.out.println("Test 2: " + rightSideView(root2)); // [10, 15, 6]

        // Test Case 3:
        TreeNode root3 = new TreeNode(7);
        System.out.println("Test 3: " + rightSideView(root3)); // [7]
    }
}