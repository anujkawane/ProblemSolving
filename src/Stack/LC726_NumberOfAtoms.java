package Stack;
import java.util.*;
public class LC726_NumberOfAtoms {
    public static String countOfAtoms(String formula) {

        Stack<TreeMap<String, Integer>> stack = new Stack<>();

        TreeMap<String, Integer> map = new TreeMap<>();
        int i = 0, n = formula.length();

        while(i < n){
            if(i < n && formula.charAt(i) == '('){
                stack.push(map);
                map = new TreeMap<>();
                i++;
            } else if(i < n && formula.charAt(i) == ')'){
                int val = 0;
                i += 1;
                while(i < n && Character.isDigit(formula.charAt(i))){
                    val = val * 10 + formula.charAt(i++) - '0';
                }

                val = val == 0 ? 1 : val;

                if(!stack.isEmpty()){
                    TreeMap<String, Integer> temp = map;
                    map = stack.pop();

                    for(String atom : temp.keySet()){
                        map.put(atom, temp.get(atom) * val + map.getOrDefault(atom, 0));
                    }
                }
            } else{
                int j = i+1;

                while(j < n && Character.isLowerCase(formula.charAt(j))){
                    j++;
                }

                String atom  = formula.substring(i, j);
                int val = 0;
                while(j < n && Character.isDigit(formula.charAt(j))){
                    val = val * 10 + formula.charAt(j++) - '0';
                }
                val = val == 0 ? 1 : val;
                map.put(atom, map.getOrDefault(atom, 0) + val);
                i = j;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(String atom : map.keySet()){
            sb.append(atom);
            String value = map.get(atom) == 1 ? "" : String.valueOf(map.get(atom));
            sb.append(value);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(countOfAtoms("K4(ON(SO3)2)2"));
        
    }
}
