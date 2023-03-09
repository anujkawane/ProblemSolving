package Challenge15Days.Day4;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;


/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be
 * stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later
 * in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be
 * serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree.
 * You do not necessarily need to follow this format, so please be creative and come up with
 * different approaches yourself.
 */
// * Definition for a binary tree node.
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
public class LC297_SerializeAndDeserializeBinaryTree {

    StringBuilder sb;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sb = new StringBuilder();
        helper(root);
        return sb.toString();
    }

    public void helper(TreeNode node){
        if(node == null){
            sb.append("#").append(",");
            return;
        }

        sb.append(node.val).append(",");
        helper(node.left);
        helper(node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        Deque<String> dq = new LinkedList<>();
        dq.addAll(Arrays.asList(data.split(",")));
        return builder(dq);
    }

    public TreeNode builder(Deque<String> dq){
        String value = dq.remove();
        if(value.equals("#")){
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(value));
            node.left = builder(dq);
            node.right = builder(dq);
            return node;
        }
    }

    public static void main(String[] args) {
        LC297_SerializeAndDeserializeBinaryTree ser = new LC297_SerializeAndDeserializeBinaryTree();
        LC297_SerializeAndDeserializeBinaryTree deser = new LC297_SerializeAndDeserializeBinaryTree();

    }
}


