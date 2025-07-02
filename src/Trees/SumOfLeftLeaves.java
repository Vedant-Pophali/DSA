package Trees;

public class SumOfLeftLeaves {
    public static class TreeNode {
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

    private int sum = 0;  // Instance-level variable

    private void visit(TreeNode node, boolean isLeft) {
        if (node == null) return;

        if (node.left == null && node.right == null && isLeft) {
            sum += node.val;
        }

        visit(node.left, true);
        visit(node.right, false);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        sum = 0; // Reset before each call
        visit(root, false);
        return sum;
    }

    public static void main(String[] args) {
        SumOfLeftLeaves solution = new SumOfLeftLeaves();

        // Test 1: Tree with multiple left leaves
        TreeNode root1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );
        System.out.println("Test 1: " + solution.sumOfLeftLeaves(root1)); // 24 (9 + 15)

        // Test 2: Tree with no left leaves
        TreeNode root2 = new TreeNode(1);
        System.out.println("Test 2: " + solution.sumOfLeftLeaves(root2)); // 0

        // Test 3: Left-heavy tree
        TreeNode root3 = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
        System.out.println("Test 3: " + solution.sumOfLeftLeaves(root3)); // 3
    }
}