package LeetCode.BackTracking;

import java.util.*;
import java.util.stream.Collectors;

public class LC78_Subsets {

    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {

        result = new ArrayList<>();

        int[] buffer = new int[nums.length];

        backtrack(nums, buffer, 0, 0);

        return result;

    }

    public void backtrack(int[] nums, int[] buffer, int startIndex, int bufferIndex){

        result.add(Arrays.stream(Arrays.copyOfRange(buffer, 0, bufferIndex)).boxed().collect(Collectors.toList()));

        if(startIndex == nums.length){
            return;
        }

        for(int i = startIndex; i < nums.length; i++){
            buffer[bufferIndex] = nums[i];
            backtrack(nums, buffer, i+1, bufferIndex+1);
        }
    }
}
