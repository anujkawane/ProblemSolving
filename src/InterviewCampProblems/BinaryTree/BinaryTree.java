package InterviewCampProblems.BinaryTree;

import java.util.*;

class Program {
    // This is the class of the input root. Do not edit it.
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> result = new ArrayList<>();
        int sum = 0;
        helper(root, result, sum);
        return result;
    }

    public static List<Integer> helper(BinaryTree root, List<Integer> res, int sum){
        if(root == null)
            return res;

        if(root.left == null && root.right == null)
            res.add(sum);

        sum += root.value;
         helper(root.left, res, sum);
        helper(root.right, res, sum);

        return res;
    }
}
