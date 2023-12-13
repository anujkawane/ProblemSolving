package AllProblems.Stack;

import java.util.Stack;

public class MinStack {

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

    Stack<Integer> main = new Stack<>();
    Stack<Integer> minStack = new Stack<>();


    public int getMin(){
        return minStack.peek();
    }

    public int remove(){
        int top = main.pop();
        if(top == minStack.peek())
            minStack.pop();

        return top;
    }
    public void add(int value){
        main.add(value);
        if(minStack.isEmpty() || minStack.peek() >= value)
            minStack.add(value);
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.add(1);
        s.add(2);
        s.add(1);
        s.add(3);
        s.add(0);
        s.remove();

        System.out.println(s.getMin());
    }
}
