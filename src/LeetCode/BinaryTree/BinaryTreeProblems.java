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


}
