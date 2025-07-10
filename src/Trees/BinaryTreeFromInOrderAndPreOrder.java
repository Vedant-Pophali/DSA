package Trees;
import java.util.*;

public class BinaryTreeFromInOrderAndPreOrder {

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    private static int preorderIndex;
    private static Map<Integer, Integer> inorderMap;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, 0, inorder.length - 1);
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) return null;

        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);
        int index = inorderMap.get(rootValue);

        root.left = buildTree(preorder, inorder, start, index - 1);
        root.right = buildTree(preorder, inorder, index + 1, end);
        return root;
    }

    // Helper class to hold a node with its level and position
    static class DisplayNode {
        TreeNode node;
        int x; // horizontal position
        int depth;

        DisplayNode(TreeNode node, int x, int depth) {
            this.node = node;
            this.x = x;
            this.depth = depth;
        }
    }

    // Horizontal printer using BFS and position mapping
    public static void printTreeHorizontal(TreeNode root) {
        if (root == null) return;

        Map<Integer, List<DisplayNode>> levels = new TreeMap<>();
        Queue<DisplayNode> queue = new LinkedList<>();
        queue.add(new DisplayNode(root, 0, 0));

        int minX = 0, maxX = 0;

        while (!queue.isEmpty()) {
            DisplayNode dn = queue.poll();
            levels.computeIfAbsent(dn.depth, k -> new ArrayList<>()).add(dn);
            minX = Math.min(minX, dn.x);
            maxX = Math.max(maxX, dn.x);

            if (dn.node.left != null)
                queue.add(new DisplayNode(dn.node.left, dn.x - 1, dn.depth + 1));
            if (dn.node.right != null)
                queue.add(new DisplayNode(dn.node.right, dn.x + 1, dn.depth + 1));
        }

        // Printing each level with spacing
        for (List<DisplayNode> level : levels.values()) {
            int currentX = minX;
            level.sort(Comparator.comparingInt(dn -> dn.x));
            for (DisplayNode dn : level) {
                while (currentX < dn.x) {
                    System.out.print("    ");
                    currentX++;
                }
                System.out.printf("%3d ", dn.node.val);
                currentX++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] preorders = {
                {3, 9, 20, 15, 7},
                {1, 2, 4, 5, 3},
                {1, 2},
                {1, 2, 3},
                {5, 3, 1, 4, 8, 7, 9}
        };

        int[][] inorders = {
                {9, 3, 15, 20, 7},
                {4, 2, 5, 1, 3},
                {2, 1},
                {1, 2, 3},
                {1, 3, 4, 5, 7, 8, 9}
        };

        for (int i = 0; i < preorders.length; i++) {
            System.out.println("🔹 Tree " + (i + 1) + " Horizontal View:");
            TreeNode tree = buildTree(preorders[i], inorders[i]);
            printTreeHorizontal(tree);
            System.out.println("\n-----------------------------\n");
        }
    }
}