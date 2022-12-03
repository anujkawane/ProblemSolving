package Graphs.TopologicalSort;

import java.util.*;

/**
 * There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.
 *
 * You are given a list of strings words from the alien language's dictionary, where the strings in words are sorted
 * lexicographically by the rules of this new language.
 *
 * Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by
 * the new language's rules. If there is no solution, return "". If there are multiple solutions, return any of them.
 *
 * Example 1:
 *
 * Input: words = ["wrt","wrf","er","ett","rftt"]
 * Output: "wertf"
 * Example 2:
 *
 * Input: words = ["z","x"]
 * Output: "zx"
 * Example 3:
 *
 * Input: words = ["z","x","z"]
 * Output: ""
 * Explanation: The order is invalid, so return "".
 */
public class LC269_AlienDictionary {

    StringBuilder sb;
    public String alienOrder(String[] words) {

        sb = new StringBuilder();
        Map<Character, List<Character>> map = new HashMap<>();

        for(String word : words){
            for(char c : word.toCharArray()){
                map.putIfAbsent(c, new ArrayList<>());
            }
        }

        for(int i = 0; i < words.length - 1; i++){
            String s1 = words[i];
            String s2 = words[i+1];

            if(s1.length() > s2.length() && s1.startsWith(s2)){
                return "";
            }

            for(int j = 0; j < Math.min(s1.length(), s2.length()); j++){
                if(s1.charAt(j) != s2.charAt(j)){
                    map.get(s1.charAt(j)).add(s2.charAt(j));
                    break;
                }
            }
        }

        int[] visited = new int[26];

        for (Character key : map.keySet()) {
            if(visited[key-'a'] == 0 && dfs(map, visited, key)){
                return "";
            }
        }

        return sb.reverse().toString();


    }

    public boolean dfs(Map<Character, List<Character>> map, int[] visited, char current){
        if(visited[current-'a'] == 1){
            return true;
        }

        if(visited[current-'a'] == 2){
            return false;
        }

        visited[current-'a'] = 1;

        for(Character neighbor : map.get(current)){
            if(dfs(map, visited, neighbor)){
                return true;
            }
        }

        sb.append(current);
        visited[current-'a'] = 2;
        return false;
    }
}
