package LeetCode.BinaryTree;


//  Definition for a binary tree node.
   class TreeNode {
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


public class BinaryTreeProblems {

//#####################################################################################################################

       /*
           1448. Count Good Nodes in Binary Tree
        */
        public int goodNodes(TreeNode root) {
            if(root == null)
                return 0;
            return countNodes(root, root.val);
        }

        public int countNodes(TreeNode root, int max){
            if(root == null)
                return 0;

            int res = (root.val >= max) ? 1 : 0;
            max = Math.max(max, root.val);

            return res + countNodes(root.left, max) + countNodes(root.right, max);
        }
//#####################################################################################################################
    /*
        226. Invert Binary Tree
     */
    public TreeNode invertTree(TreeNode root) {

        if(root == null)
            return null;

        TreeNode temp = root.left;

        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

//#####################################################################################################################

    /*
    617. Merge Two Binary Trees
     */

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null)
            return root2;
        if(root2 == null)
            return root1;

        TreeNode root = new TreeNode(root1.val + root2.val);

        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);

        return root;
    }

//#####################################################################################################################

    /*
        check if tree is a valid BST
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer low, Integer high){
        if(root == null)
            return true;

        if((low != null && root.val <=low) || (high != null && root.val >=high))
            return false;

        return (helper(root.left, low, root.val) && helper(root.right, root.val, high));
    }


//#####################################################################################################################
    /*
        108. Convert Sorted Array to Binary Search Tree
     */

    int[] array;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.array = nums;
        return helper(0, nums.length-1);
    }

    public TreeNode helper(int low, int high){
        if(low > high)
            return null;

        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(array[mid]);
        root.left = helper(low, mid-1);
        root.right = helper(mid+1, high);

        return root;
    }

//#####################################################################################################################

   static int sum = 0;
    public static int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        String s = "";
        helper(root, s);
        return sum;
    }

    public static void helper(TreeNode root, String str){
        if(root == null)
            return;

        str += root.val;

        if(root.left == null && root.right == null){
            sum += Integer.valueOf(str);
        }

        helper(root.left, str);
        helper(root.right, str);
        str = str.substring(0, str.length() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(sumNumbers(root));
    }
}
