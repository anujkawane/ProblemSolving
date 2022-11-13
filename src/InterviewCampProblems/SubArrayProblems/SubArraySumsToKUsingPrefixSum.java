package InterviewCampProblems.SubArrayProblems;

import java.util.Arrays;
import java.util.HashMap;

public class SubArraySumsToKUsingPrefixSum {

    public static int[] subArraySum(int[] array, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            sum += array[i];
            if(sum == target){
                return Arrays.copyOfRange(array, 0, i+1);
            }
            if(map.containsKey(sum-target)){
                return Arrays.copyOfRange(array, map.get(sum)+1, i+1);
            }
            map.put(sum, i);
        }
        return new int[0];
    }

    public static void main(String[] args) {

//        int[] array = {2,4,-2,1,-3,5,-3};
//        int[] res = subArraySum(array, 0);
//        for(int n : res){
//            System.out.print(n + " ");
//        }
      
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
