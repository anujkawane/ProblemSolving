package AllProblems.SlidingWindow;

import java.util.*;
public class LC76_MinimumWindowSubstring {
    public static String minWindow(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) +1);
        }

        int have = 0, len = s.length() + 1, left = 0;
        int subIndex = 0;
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0)
                    have++;
            }
            while(have == map.size()){
                if(len > i - left + 1){
                    len = i - left + 1;
                    subIndex = left;
                }
                Character deleted = s.charAt(left);
                if(map.containsKey(deleted)){
                    if(map.get(deleted) == 0){
                        have--;
                    }
                    map.put(deleted, map.get(deleted) + 1);
                }
                left++;
            }
        }
        return len > s.length() ? "" : s.substring(subIndex, subIndex + len);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("aa", "aa"));
    }
}
