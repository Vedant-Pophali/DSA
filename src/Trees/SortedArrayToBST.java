package Trees;
public class SortedArrayToBST {

    // Definition for a binary tree node
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

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return constructBST(nums, 0, nums.length - 1);
    }

    public static TreeNode constructBST(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = constructBST(nums, left, mid - 1);
        node.right = constructBST(nums, mid + 1, right);
        return node;
    }

    // Utility: Print In-Order Traversal of Tree
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    // Main method with test case
    public static void main(String[] args) {
        // Test Case 1: Mixed negative and positive
        int[] nums1 = {-10, -3, 0, 5, 9};
        System.out.print("Test 1 (In-order): ");
        printInOrder(sortedArrayToBST(nums1));
        System.out.println();

        // Test Case 2: Only one element
        int[] nums2 = {1};
        System.out.print("Test 2 (In-order): ");
        printInOrder(sortedArrayToBST(nums2));
        System.out.println();

        // Test Case 3: Two elements
        int[] nums3 = {1, 3};
        System.out.print("Test 3 (In-order): ");
        printInOrder(sortedArrayToBST(nums3));
        System.out.println();

        // Test Case 4: Empty array
        int[] nums4 = {};
        System.out.print("Test 4 (In-order): ");
        printInOrder(sortedArrayToBST(nums4)); // Should print nothing
        System.out.println();

        // Test Case 5: Longer array
        int[] nums5 = {0, 1, 2, 3, 4, 5, 6, 7};
        System.out.print("Test 5 (In-order): ");
        printInOrder(sortedArrayToBST(nums5));
        System.out.println();
    }
}