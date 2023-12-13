package AllProblems.LeetCode;

import java.util.*;

public class LC1146_SnapshotArray {
    List<Integer> array;
    Map<Integer, List<Integer>> map;
    int snapID;
    public LC1146_SnapshotArray(int length) {

        array = new ArrayList<>(Arrays.asList(new Integer[length]));
        snapID = 0;
        map = new HashMap<>();
    }

    public void set(int index, int val) {
        array.set(index, val);
    }

    public int snap() {
        map.put(snapID++, array);
        return snapID-1;
    }

    public int get(int index, int snap_id) {
        return map.get(snap_id).get(index);
    }

    public static void main(String[] args) {
        LC1146_SnapshotArray ob = new LC1146_SnapshotArray(3);
        ob.set(0,5);
        ob.snap();
        ob.set(0,6);
        ob.get(0,0);
    }
}

