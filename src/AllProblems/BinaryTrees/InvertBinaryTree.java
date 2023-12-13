package AllProblems.BinaryTrees;

/**
 * Write a function that takes in a Binary Tree and inverts it. In other words, the function should swap every left node
 * in the tree for its corresponding right node. Each AllProblems.BinaryTree node has an integer value, a left child node,
 * and a right child node. Children nodes can either be AllProblems.BinaryTree nodes themselves or None / null.
 * Sample Input:
 *           1
 *        /     \
 *       2       3
 *     /   \   /   \
 *    4     5 6     7
 *  /   \
 * 8     9
 *
 * Sample Output:
 *        1
 *     /     \
 *    3       2
 *  /   \   /   \
 * 7     6 5     4
 *             /   \
 *            9     8
 *
 */
public class InvertBinaryTree {

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static void invertBinaryTree(BinaryTree root) {
       if(root == null)
           return;

        BinaryTree left = root.left;
        root.left = root.right;
        root.right = left;

        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }
}
