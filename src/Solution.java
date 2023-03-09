import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    TreeMap<Integer, Integer> intervals = new TreeMap<>();

    public void addRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        Integer end = intervals.floorKey(right);
        if(start != null && intervals.get(start) >= left){
            left = start;
        }

        if(end != null && intervals.get(end) > right){
            right = intervals.get(end);
        }

        intervals.put(left, right);

        intervals.subMap(left, false, right, true).clear();
    }

    public boolean queryRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        if(start == null) return false;
        return intervals.get(start) >= right;
    }

    public void removeRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        Integer end = intervals.floorKey(right);

        if(end != null && intervals.get(end) > right){
            intervals.put(right, intervals.get(end));
        }
        if(start != null && intervals.get(start) > left){
            intervals.put(start, left);
        }
        intervals.subMap(left, true, right, false).clear();
    }

    public static boolean canConvert(String str1, String str2) {
        if(str1.equals(str2)) return true;

        Map<Character, Character> map = new HashMap<>();

        for(int i = 0; i < str1.length(); i++){
            char a = str1.charAt(i);
            char b = str2.charAt(i);

            if(map.getOrDefault(a, b) != b){
                return false;
            }
            map.put(a, b);
        }
        return new HashSet<>(map.values()).size() < 26;
    }

    public static void main(String[] args) {
//        Solution s = new Solution();
//        s.addRange(10, 20);
//        s.removeRange(14, 16);
//        s.queryRange(10, 14);
//        s.queryRange(13,15);
//        s.queryRange(16,17);

        canConvert("abcdefghijklmnopqrstuvwxyz", "bcdefghijklmnopqrstuvwxyza");
    }
}