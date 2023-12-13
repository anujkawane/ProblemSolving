package AllProblems.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class SortColors {
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        int start = 0, end = 0;
        int sum = arr[0];
        while(start < arr.length){

            if(start > end){
                end = start;
                sum = arr[start];
            }
            if(sum > s){
                sum -= arr[start];
                start++;
            }else if( sum < s){
                if(end == arr.length-1)
                    break;
                end++;
                sum += arr[end];
            }else{
                return new ArrayList<>(Arrays.asList(start+1, end+1));
            }
        }
        return new ArrayList<>();

    }

    static ArrayList<Integer> subarraySum1(int[] arr, int n, int s)
    {
        int start = 0, end = 0;
        int sum = arr[0];
        while(end < arr.length){
            if(start > end){
                end = start;
                sum = arr[start];
            }
            if(sum < s){
                if(end == arr.length-1)
                    break;
                end++;
                sum += arr[end];
            }else if ( sum > s){
                start++;
                sum -= arr[start];
            }else{
                return new ArrayList<>(Arrays.asList(start+1, end+1));
            }
        }
        return new ArrayList<>(Arrays.asList(-1));
    }

    public static void sortColors(int[] nums) {

        int start = 0, end = nums.length-1, i = 0;
        while(i <= end){
            if(nums[i] == 0){
                swap(nums, start, i);
                start++;
            }else if(nums[i] == 2){
                swap(nums, end, i);
                end--;
            }
            i++;
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,2,3,7,5}, 5, 12));
    }
}
