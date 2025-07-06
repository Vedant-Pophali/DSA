package Trees;

public class ValidateBST {

    // Static nested TreeNode class
    public static class TreeNode {
        int val;
        TreeNode left, right;

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

    public static boolean solve(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val <= minVal || root.val >= maxVal) return false;

        return solve(root.left, minVal, root.val) &&
                solve(root.right, root.val, maxVal);
    }

    public static boolean isValidBST(TreeNode root) {
        return solve(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static void main(String[] args) {
        // Test Case 1: Valid BST
        TreeNode root1 = new TreeNode(2,
                new TreeNode(1),
                new TreeNode(3));
        System.out.println("Test 1: " + isValidBST(root1)); // true

        // Test Case 2: Invalid BST
        TreeNode root2 = new TreeNode(5,
                new TreeNode(6),
                new TreeNode(7));
        System.out.println("Test 2: " + isValidBST(root2)); // false

        // Test Case 3: Valid deeper BST
        TreeNode root3 = new TreeNode(10,
                new TreeNode(5,
                        new TreeNode(2), new TreeNode(8)),
                new TreeNode(15,
                        null, new TreeNode(20)));
        System.out.println("Test 3: " + isValidBST(root3)); // true

        // Test Case 4: Invalid BST with duplicate value on the right
        TreeNode root4 = new TreeNode(10,
                new TreeNode(5),
                new TreeNode(10));  // violates strict inequality rule
        System.out.println("Test 4: " + isValidBST(root4)); // false

        // Test Case 5: Valid BST with Integer.MIN and Integer.MAX
        TreeNode root5 = new TreeNode(0,
                new TreeNode(-100000),
                new TreeNode(100000));
        System.out.println("Test 5: " + isValidBST(root5)); // true
    }
}