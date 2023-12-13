package AllProblems.Medium15Days.Day1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LC340_LongestSubstringwithAtMostKDistinctCharacters {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int left = 0, max = 0;

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            map.put(c, right);

            while(map.size() == k + 1){

                int leftmost = Collections.min(map.values());
                map.remove(s.charAt(leftmost));
                left = leftmost + 1;
            }
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstringKDistinct("abaccc", 2));

    }
}
