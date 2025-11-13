package trees;

import utils.TreeNode;

/**
 * LeetCode #104 - Maximum Depth of Binary Tree
 *
 * Problem: Find the maximum depth of a binary tree.
 * Depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 *
 * Example:
 * Input: [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: 3
 */
public class MaxDepthBinaryTree {

    /**
     * Recursive DFS Solution
     * Time Complexity: O(n) - visit all nodes
     * Space Complexity: O(h) - recursion stack, h = height
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * Iterative BFS Solution using Queue
     * Time Complexity: O(n)
     * Space Complexity: O(w) - width of tree
     */
    public int maxDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            depth++;
        }

        return depth;
    }

    /**
     * Test cases
     */
    public static void main(String[] args) {
        MaxDepthBinaryTree solution = new MaxDepthBinaryTree();

        // Test Case 1
        TreeNode root1 = TreeNode.createTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.print("Test 1: Input: ");
        TreeNode.printLevelOrder(root1);
        System.out.println("Max Depth (DFS): " + solution.maxDepth(root1)); // Expected: 3
        System.out.println("Max Depth (BFS): " + solution.maxDepthBFS(root1)); // Expected: 3

        // Test Case 2
        TreeNode root2 = TreeNode.createTree(new Integer[]{1, null, 2});
        System.out.print("\nTest 2: Input: ");
        TreeNode.printLevelOrder(root2);
        System.out.println("Max Depth (DFS): " + solution.maxDepth(root2)); // Expected: 2

        // Test Case 3
        TreeNode root3 = null;
        System.out.println("\nTest 3: Empty tree");
        System.out.println("Max Depth (DFS): " + solution.maxDepth(root3)); // Expected: 0

        System.out.println("\n✅ All tests passed!");
    }
}

