package LeetCode.BackTracking;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 */
public class LC46_Permutations {

    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {

        result = new ArrayList<>();
        int[] buffer = new int[nums.length];
        boolean[] inBuffer = new boolean[nums.length];

        backtrack(nums, buffer, inBuffer, 0);

        return result;
    }

    public void backtrack(int[] nums, int[] buffer, boolean[] inBuffer, int bufferIndex){
        if(bufferIndex == buffer.length) {
            result.add(Arrays.stream(buffer).boxed().collect(Collectors.toList()));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!inBuffer[i]){
                buffer[bufferIndex] = nums[i];
                inBuffer[i] = true;
                backtrack(nums, buffer, inBuffer, bufferIndex+1);
                inBuffer[i] = false;
            }
        }
    }
}
