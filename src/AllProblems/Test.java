package AllProblems;

import java.util.*;

public class Test  {
//    String s;
//
//    @Override
//    public String toString() {
//        return "AllProblems.Test{" +
//                "s='" + s + '\'' +
//                ", age=" + age +
//                '}';
//    }
//
//    int age;
//    public AllProblems.Test(String s, int age){
//        this.s = s;
//        this.age = age;
//    }

    public record Node(int max, int index) {
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int[] result = new int[nums.length - k + 1];
        int ri = 0;
        Queue<Node> maxHeap = new PriorityQueue<>((a1,a2) -> a2.max() - a1.max());

        for(int i = 0; i < nums.length; i++){

            maxHeap.add(new Node(nums[i], i));

            while(maxHeap.size() > 0 && maxHeap.peek().index < i-k + 1){
                maxHeap.remove();
            }

            if(maxHeap.size() == k){
                result[ri++] = maxHeap.peek().max;
            }
        }
        return result;
    }
    class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    };

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

//        List<Interval> list = new ArrayList<>((a, b) -> a.start - b.start);
//        for(List<Interval> l : schedule){
//            list.addAll(l);
//        }
        return null;
    }

    public static int countBinarySubstrings(String s) {
        int prevRunLength = 0, curRunLength = 1, res = 0;
        for (int i=1;i<s.length();i++) {
            if (s.charAt(i) == s.charAt(i-1)) curRunLength++;
            else {
                prevRunLength = curRunLength;
                curRunLength = 1;
            }
            if (prevRunLength >= curRunLength) res++;
        }
        return res;
    }

    public static  void main(String[] args) {

        System.out.println(countBinarySubstrings("001100"));
    }
}