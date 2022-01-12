package InterviewCampProblems.ArraysString;

/*
Given a sorted array in non-decreasing order, return an array of squares of each number, also in non-decreasing order.
 For example:
    [-4,-2,-1,0,3,5] -> [0,1,4,9,16,25]
How can you do it in O(n) time?
 */
public class ArrayOfSquares {


    public static int[] squareNumber(int[] nums){
        int start = 0, end = nums.length-1;
        int index = end;
        int result[] = new int[nums.length];
        while (start<=end){
            if(Math.abs(nums[start])>Math.abs(nums[end])){
                result[index] = nums[start] * nums[start];
                start++;
            }
            else{
                result[index] = nums[end] * nums[end];
                end--;
            }
            index--;
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {-7,-3,2,3,11};
        int result[]  = squareNumber(arr);
        for(int n : result)
            System.out.print(n+" ");
    }
}
