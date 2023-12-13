package AllProblems.InterviewCampProblems.SubArrayProblems;

public class KadaneAlgorithm {

    /*
    https://leetcode.com/problems/maximum-subarray/

    Given an integer array nums, find the contiguous subarray (containing at least one number) which has the
    largest sum and return its sum.

    A subarray is a contiguous part of an array.

    Example:
    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.
     */
    public static int maximumSumSubarray(int[] array){
        int maxSum = array[0], maxSumEndingHere = array[0];
        for(int i=1; i<array.length;i++){
            maxSumEndingHere = maxSumEndingHere + array[i];
            if(maxSumEndingHere<array[i]){
                maxSumEndingHere = array[i];
            }
            maxSum  = Math.max(maxSum, maxSumEndingHere);
        }
        return maxSum;
    }


    public static void main(String[] args) {

        int[] array = {-2,-3,4,-1,-2,1,5,-1};

        System.out.println(maximumSumSubarray(array));

    }


}
