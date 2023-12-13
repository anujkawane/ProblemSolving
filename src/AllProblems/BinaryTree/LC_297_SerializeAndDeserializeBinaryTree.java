package AllProblems.BinaryTree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LC_297_SerializeAndDeserializeBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        helperSerialize(root, sb);
        return sb.toString();
    }

    public static void helperSerialize(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null").append(",");
            return;
        }

        sb.append(root.val).append(",");
        helperSerialize(root.left, sb);
        helperSerialize(root.right, sb);
    }


    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {

        Deque<String> deque = new LinkedList<>();
        deque.addAll(Arrays.asList(data.split(",")));
        return treeBuilder(deque);
    }

    public static TreeNode treeBuilder(Deque<String> deque){
        String value = deque.remove();
        if(value == "null"){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(value));
        node.left = treeBuilder(deque);
        node.right = treeBuilder(deque);

        return node;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(serialize(root));

        TreeNode build = deserialize(serialize(root));

        System.out.println(build.val);

    }

}
