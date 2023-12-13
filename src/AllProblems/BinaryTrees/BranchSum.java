package AllProblems.BinaryTrees;

import java.util.*;

/*
Write a function that takes in a Binary Tree and returns a list of its branch sums ordered from leftmost branch sum
to rightmost branch sum. A branch sum is the sum of all values in a Binary Tree branch.
A Binary Tree branch is a path of nodes in a tree that starts at the root node and ends at any leaf node.
 Each AllProblems.BinaryTree node has an integer value, a left child node, and a right child node.
 Children nodes can either be AllProblems.BinaryTree nodes themselves or None / null.
  Sample Input tree =

           1
        /     \
       2       3
     /   \    /  \
    4     5  6    7
  /   \  /
 8    9 10

 Sample Output:  [15, 16, 18, 10, 11]
 // 15 == 1 + 2 + 4 + 8
 // 16 == 1 + 2 + 4 + 9
 // 18 == 1 + 2 + 5 + 10
 // 10 == 1 + 3 + 6
 // 11 == 1 + 3 + 7
 */

public class BranchSum {
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

        helper(root, result, 0);
        return result;
    }

    public static void helper(BinaryTree root, List<Integer> result, int sum){
        if(root == null)
            return;
        sum += root.value;

        if(root.left == null && root.right == null)
            result.add(sum);

        helper(root.left, result, sum);
        helper(root.right, result, sum);
    }

}
