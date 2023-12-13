package AllProblems.SlidingWindow;

import java.util.*;
public class LC3_LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() == 0 )
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        int start = 0, longest = 1;
        for(int i = 1; i < s.length(); i++){
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= start){
                start = map.get(s.charAt(i)) + 1;
            }
            map.put(s.charAt(i), i);
            longest = Math.max(i - start + 1, longest);
        }
        return longest;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
