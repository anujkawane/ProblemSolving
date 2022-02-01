package LeetCode;

import java.util.*;
public class ThreeNumberSum {
/*
Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum.
The function should find all triplets in the array that sum up to the target sum and return a two-dimensional array of all these triplets.
The numbers in each triplet should be ordered in ascending order, and the triplets themselves should be ordered in ascending order with respect to the numbers they hold.
If no three numbers sum up to the target sum, the function should return an empty array.
Sample Input array = [12, 3, 1, 2, -6, 5, -8, 6] targetSum = 0 Sample Output [[-8, 2, 6], [-8, 3, 5], [-6, 1, 5]]
 */
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> result = new ArrayList<>();
        for(int i=0;i<array.length-2;i++){
            int start = i+1;
            int end = array.length-1;
            int temp = targetSum - array[i];
            while(start<end){
                if(array[start]+array[end]<temp){
                    start++;
                } else if(array[start]+array[end]>temp){
                    end--;
                }else{
                    result.add(new Integer[]{array[i], array[start], array[end]});
                    end--;
                    start++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<Integer[]> list = threeNumberSum(arr,6);
        for(Integer n[]:list){
            System.out.println(n);
        }
    }

}
