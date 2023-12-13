package AllProblems.InterviewCampProblems.BinarySearch;

public class BS_SearchTarget {

    public static boolean searchTarget(int[] array, int target){
        if(array.length==0)
            return false;
        int start = 0;
        int end = array.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(array[mid]==target)
                return true;
            else if(array[mid]<target)
                start = mid+1;
            else
                end = mid-1;
        }
        return false;
    }
    public static void main(String[] args) {

        int array[] = {1,2,3,4,5,6,7,8,9};
        System.out.println(searchTarget(array, -1));
    }
}
