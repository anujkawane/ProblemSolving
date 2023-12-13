package AllProblems.InterviewCampProblems.SubArrayProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Level: Medium
    Given an array of positive integers, find a subarray that sums to a given number X.
    For e.g, input = [1,2,3,5,2] and X=8, Result = [3,5] (indexes 2,3)
 */
public class SlidingWindowTwoPointer {


    public static int[] subarraySum(int[] a, int target) {
        List<Integer> result = new ArrayList<>();
        int start = 0, end = 0;
        int sum = a[0];
        while(start < a.length){
            if(start > end){
                end = start;
                sum = a[start];
            }
            if(sum < target){
                if(end == a.length-1){
                    break;
                }
                end++;
                sum += a[end];
            }
            else if(sum>target){
                sum -= a[start];
                start++;
            }
            else{
                return Arrays.copyOfRange(a, start, end + 1);
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,5,2};
        int[] result = subarraySum(arr,8);
        for(int n:result){
            System.out.println(n);
        }
    }

}
