import java.util.*;
public class ThreeNumberSum {

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
