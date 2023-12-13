package AllProblems.InterviewCampProblems.SubArrayProblems;

import java.util.HashMap;

public class LongestSubstringWithUniqueChar {


    public static String getLongestUniqueSubstring(String s){
        int[] pair = new int[2];
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        map.put(s.charAt(0),0);
        int longest = 1;
        while(end < s.length() -1 ){
            end++;
            char toAdd = s.charAt(end);
            if(map.containsKey(toAdd) && map.get(toAdd)>=start) {
                start = map.get(toAdd) + 1;
            }
            map.put(toAdd, end);

            if((end - start)+1 > longest) {
                longest = (end - start) + 1;
                pair[0] = start;
                pair[1] = end;
            }

        }
        return s.substring(pair[0], pair[1]+1);
    }



    public static void main(String[] args) {
        String s = "whatwhywhere";
        System.out.println(getLongestUniqueSubstring(s));

    }
}
