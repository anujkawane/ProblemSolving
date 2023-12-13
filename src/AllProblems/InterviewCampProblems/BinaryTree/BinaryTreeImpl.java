package AllProblems.InterviewCampProblems.BinaryTree;



import java.util.*;

class Node{
    int data;
    Node left, right;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinaryTreeImpl {

    public void inorder(Node node){
        if(node==null)
            return;
        inorder(node.getLeft());
        System.out.println(node.getData());
        inorder(node.getRight());
    }

    public void preorder(Node node){
        if(node==null)
            return;
        System.out.println(node.getData());
        preorder(node.getLeft());
        preorder(node.getRight());
    }

    public void postorder(Node node){
        if(node==null)
            return;
        postorder(node.getLeft());
        postorder(node.getRight());
        System.out.println(node.getData());
    }

    /*
    Bottom up approach
     */
    public int heightOfTree(Node root){
       /*if(root.getLeft() == null && root.getRight()==null)
           return 0;

       int left = 0, right = 0;
       if(root.getLeft() != null){
           left = heightOfTree(root.getLeft());
       }
        if(root.getRight() != null){
            right = heightOfTree(root.getRight());
        }
        return Math.max(left,right)+1;*/

        if(root==null)
            return 0;
        return Math.max(heightOfTree(root.getLeft()), heightOfTree(root.getRight())) + 1;
    }

    public int getHeight(Node root){
       int[] maxHeight  = {-1};
       int parentHeight = -1;
       heightHelper(root, parentHeight, maxHeight);
       return maxHeight[0];
    }

    public void heightHelper(Node root, int parentHeight, int[] maxHeight){
        if(root == null)
            return;

        int currentHeight = parentHeight + 1;
        if(currentHeight > maxHeight[0])
            maxHeight[0] = currentHeight;

        heightHelper(root.getLeft(), currentHeight, maxHeight);
        heightHelper(root.getRight(), currentHeight, maxHeight);
    }


    public boolean isTreeBalanced(Node root){
        return isBalancedHelper(root) != -1;
    }

    public int isBalancedHelper(Node root){
        if(root==null)
            return 0;

        int left = isBalancedHelper(root.getLeft());
        int right = isBalancedHelper(root.getRight());

        if(left == -1 || right == -1)
            return -1;
        if(Math.abs(left-right) > 1 )
            return -1;

        return Math.max(left, right) + 1;

    }

    public void printPaths(Node root){
        pathFinder(root, new Stack<Integer>());
    }

    public void pathFinder(Node root, Stack<Integer> stack){
        if(root == null)
            return;
        stack.add(root.data);

        if(root.getLeft() == null && root.getRight() == null) {
            System.out.println(stack);
        }
        pathFinder(root.getLeft(), stack);
        pathFinder(root.getRight(), stack);
        stack.pop();
    }




    public static void main(String[] args) {
        Node root = new Node(1);
        root.setLeft(new Node(2));
        root.setRight(new Node(3));
        root.getLeft().setLeft(new Node(4));
        root.getLeft().setRight(new Node(5));
        root.getRight().setLeft(new Node(6));
        root.getLeft().getLeft().setRight(new Node(7));

        BinaryTreeImpl b = new BinaryTreeImpl();
//        b.postorder(root);
        b.printPaths(root);


    }

}
