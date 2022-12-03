package SlidingWindow;

import java.util.*;

/**
 * Given a string s, return the length of the longest substring that contains at most two distinct characters.
 *
 * Example 1:
 *
 * Input: s = "eceba"
 * Output: 3
 * Explanation: The substring is "ece" which its length is 3.
 * Example 2:
 *
 * Input: s = "ccaabbb"
 * Output: 5
 * Explanation: The substring is "aabbb" which its length is 5.
 */
public class LC159_Longest_Substring_With_At_Most_Two_Distinct_Characters {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {


        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        int result = 0, start = 0;

        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            map.put(c, i);

            if(map.size() == 3){
                int idx = Collections.min(map.values());
                start = map.get(s.charAt(idx)) + 1;
                map.remove(s.charAt(idx));
            }

            result = Math.max(result, i - start + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("cdaba"));
    }
}
