package Trees;

public class SameTree {
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
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            return p.val == q.val
                    && isSameTree(p.left, q.left)
                    && isSameTree(p.right, q.right);
        } else if (p == null && q == null) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        // Test Case 1: Identical Trees
        TreeNode t1a = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode t1b = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println("Test Case 1: " + isSameTree(t1a, t1b)); // true

        // Test Case 2: One node different
        TreeNode t2a = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode t2b = new TreeNode(1, new TreeNode(2), new TreeNode(4));
        System.out.println("Test Case 2: " + isSameTree(t2a, t2b)); // false

        // Test Case 3: One tree has extra node
        TreeNode t3a = new TreeNode(1, new TreeNode(2), null);
        TreeNode t3b = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println("Test Case 3: " + isSameTree(t3a, t3b)); // false

        // Test Case 4: Both trees are null
        System.out.println("Test Case 4: " + isSameTree(null, null)); // true

        // Test Case 5: Different structure
        TreeNode t5a = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
        TreeNode t5b = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println("Test Case 5: " + isSameTree(t5a, t5b)); // false
    }
}
