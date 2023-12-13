package AllProblems.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i<intervals.length; i++){
            List<Integer> newList  = new ArrayList<>();
            if(intervals[i][1] >= intervals[i+1][0]){
                newList.add(intervals[i][0]);
                newList.add(intervals[i+1][1]);
                result.add(newList);
            }else{
                newList.add(intervals[i][0]);
                newList.add(intervals[i][1]);
                result.add(newList);
            }

        }
        int[][] finalRes  = new int[result.size()][2];
        int i=0;
        for(List<Integer> l : result){
            finalRes[i][0] = l.get(0);
            finalRes[i][1] = l.get(1);
            i++;
        }
        return finalRes;
    }

    public static void main(String[] args) {

    }
}
