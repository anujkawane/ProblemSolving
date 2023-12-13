package AllProblems.StringLeetCode;

import java.util.Stack;

public class wordCompression {
    public static String reduced_String(int k, String s)
    {
        // Base Case
        if (k == 1) {
            return "";
        }

        Stack<Pair> st = new Stack<Pair>();

        int l = s.length();
        int ctr = 0;

        for (int i = 0; i < l; i++) {

            if (st.size() == 0) {
                st.push(new Pair(s.charAt(i), 1));
                continue;
            }

            if (st.peek().c == s.charAt(i)) {
                Pair p = st.peek();
                st.pop();
                p.ctr += 1;
                if (p.ctr == k) {
                    continue;
                }
                else {
                    st.push(p);
                }
            }
            else {
                st.push(new Pair(s.charAt(i), 1));
            }
        }
        String ans = "";
        while (st.size() > 0) {
            char c = st.peek().c;
            int cnt = st.peek().ctr;
            while (cnt-- > 0)
                ans = c + ans;
            st.pop();
        }
        return ans;
    }

    static class Pair {
        char c;
        int ctr;
        Pair(char c, int ctr)
        {
            this.c = c;
            this.ctr = ctr;
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        int k = 3;
        String st = "abbcccb";
        String ans = removeDuplicates(st, k);
        System.out.println(ans);

    }


    public static  String removeDuplicates(String s, int k) {
        StringBuilder result = new StringBuilder(s);
        Stack<Integer> counts = new Stack<>();
        for (int i = 0; i < result.length(); ++i) {
            if (i == 0 || result.charAt(i) != result.charAt(i - 1)) {
                counts.push(1);
            } else {
                int incremented = counts.pop() + 1;
                if (incremented == k) {
                    result.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    counts.push(incremented);
                }
            }
        }
        return result.toString();
    }
}
