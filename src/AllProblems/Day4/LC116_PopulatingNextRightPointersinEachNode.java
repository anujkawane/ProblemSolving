package AllProblems.Day4;

/**
 * Populate each next pointer to point to its next right node. If there is no next right node,
 * the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer
 * to point to its next right node, just like in Figure B. The serialized output is in level order as
 * connected by the next pointers, with '#' signifying the end of each level.
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
public class LC116_PopulatingNextRightPointersinEachNode {
    public Node connect(Node root) {

        traverse(root);
        return root;
    }

    public void traverse(Node node){
        if(node == null){
            return;
        }

        if(node.left != null && node.right != null){
            node.left.next = node.right;
        }

        if(node.right != null && node.next != null){
            node.right.next = node.next.left;
        }

        traverse(node.left);
        traverse(node.right);
    }
}
