import java.util.*;

class Solution {
    static StringBuilder sb;
    public static String alienOrder(String[] words) {

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

    public static boolean dfs(Map<Character, List<Character>> map, int[] visited, char current){
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

    public static void main(String[] args) {

        System.out.println(alienOrder(new String[]{"ac","ab","zc","zb"}));
    }
}