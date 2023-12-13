package AllProblems.Stack;

import java.util.Stack;

/*
Write a function that takes in a string made up of brackets ((, [, {, ), ], and }) and other optional
characters. The function should return a boolean representing whether the string is balanced with regards
to brackets. A string is said to be balanced if it has as many opening brackets of a certain type as it has
 closing brackets of that type and if no bracket is unmatched. Note that an opening bracket can't match
 a corresponding closing bracket that comes before it, and similarly, a closing bracket can't match a
  corresponding opening bracket that comes after it. Also, brackets can't overlap each other as in [(]).
   Sample Input string = "([])(){}(())()()" Sample Output true // it's balanced
 */
public class BalancedBrackets {

    public static boolean balancedBrackets(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).matches("[(){}\\[\\]]")) {
                if (stack.isEmpty()) {
                    stack.push(str.charAt(i));
                } else if (stack.peek() == '{' && str.charAt(i) == '}')
                    stack.pop();
                else if (stack.peek() == '[' && str.charAt(i) == ']')
                    stack.pop();
                else if (stack.peek() == '(' && str.charAt(i) == ')')
                    stack.pop();
                else
                    stack.push(str.charAt(i));
            }
        }
        if (stack.isEmpty())
            return true;

        return false;
    }






    public static void main(String[] args) {

    }
}
