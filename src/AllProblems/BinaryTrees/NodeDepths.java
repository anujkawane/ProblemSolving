package AllProblems.BinaryTrees;


/**
 * The distance between a node in a Binary Tree and the tree's root is called the node's depth.
 * Write a function that takes in a Binary Tree and returns the sum of its nodes' depths.
 * Each AllProblems.BinaryTree node has an integer value, a left child node, and a right child node.
 * Children nodes can either be AllProblems.BinaryTree nodes themselves or None / null
 * Sample Input tree =
 *           1
 *        /     \
 *       2       3
 *     /   \   /   \
 *    4     5 6     7
 *  /   \
 * 8     9
 *
 * Sample Output 16
 * // The depth of the node with value 2 is 1.
 * // The depth of the node with value 3 is 1.
 * // The depth of the node with value 4 is 2.
 * // The depth of the node with value 5 is 2.
 * // Etc..
 * // Summing all of these depths yields 16.
 */

public class NodeDepths {
    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static int nodeDepths(BinaryTree root) {
        return helper(root, 0);
    }

    public static int helper(BinaryTree root, int depth){
        if(root == null)
            return 0;

        return depth + helper(root.left, depth +1) + helper(root.right, depth + 1);
    }


//    understandable code
    public static int nodeDepths1(BinaryTree root) {
        int[] sum = new int[1];
        sum[0] = 0;
        helper(root, sum, 0);
        return sum[0];
    }

    public static void helper(BinaryTree root, int[] sum, int depth){
        if(root == null)
            return;

        sum[0] += depth;
        helper(root.left, sum, depth + 1);
        helper(root.right, sum, depth + 1);
    }


}
