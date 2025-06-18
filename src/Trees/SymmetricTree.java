package Trees;
public class SymmetricTree {
    public static void main(String[] args) {
        // Test Case 1: Symmetric
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3))
        );
        System.out.println("Test 1 (Expected: true): " + isSymmetric(root1));
        // Test Case 2: Not Symmetric
        TreeNode root2 = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3))
        );
        System.out.println("Test 2 (Expected: false): " + isSymmetric(root2));
        // Test Case 3: Single Node
        TreeNode root3 = new TreeNode(1);
        System.out.println("Test 3 (Expected: true): " + isSymmetric(root3));
        // Test Case 4: Null Tree
        TreeNode root4 = null;
        System.out.println("Test 4 (Expected: true): " + isSymmetric(root4));
        // Test Case 5: Symmetric with deeper structure
        TreeNode root5 = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), null),
                new TreeNode(2, null, new TreeNode(3))
        );
        System.out.println("Test 5 (Expected: true): " + isSymmetric(root5));
    }
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSym(root.left, root.right);
    }
    public static boolean isSym(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val &&
                isSym(p.left, q.right) &&
                isSym(p.right, q.left);
    }
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
}