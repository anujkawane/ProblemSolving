package AllProblems.InterviewCampProblems.BinarySearch;

public class BS_SearchWithDuplicates {

    public static int getFirstIndexOfTarget(int[] array, int target){

        int low = 0;
        int high  = array.length;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(array[mid] > target || (array[mid] == target && mid > 0 && array[mid-1]==target)){
                high = mid-1;
            }else if(array[mid] < target){
                low = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }


    public static int[] searchRange(int[] nums, int target) {
        if(nums.length == 0 || nums == null)
            return new int[]{-1,-1};
        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        return new int[]{first,last};
    }

    public static int findFirst(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = low + (high-low) /2;

            if(nums[mid] > target ||
                    (nums[mid]==target && mid > 0 && nums[mid-1]==target)){
                high = mid - 1;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static int findLast(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = low + (high-low) /2;

            if(nums[mid] > target){
                high = mid - 1;
            }else if(nums[mid] < target ||
                    (nums[mid] == target && mid < nums.length-1 && nums[mid+1]==target)){
                low = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] array = {1,2,4,4,5,6,7};
        System.out.println(getFirstIndexOfTarget(array, 4));


    }

}
