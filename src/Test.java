import java.util.*;

public class Test  {
//    String s;
//
//    @Override
//    public String toString() {
//        return "Test{" +
//                "s='" + s + '\'' +
//                ", age=" + age +
//                '}';
//    }
//
//    int age;
//    public Test(String s, int age){
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

        List<Interval> list = new ArrayList<>((a, b) -> a.start - b.start);
        for(List<Interval> l : schedule){
            list.addAll(l);
        }

    }

    public static  void main(String[] args) {

        System.out.println(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));


//        Test a = new Test("Anuj", 23);
//        List l = new ArrayList();
//        l.add(2);
//        l.add("new");
//        l.add(a);
//        l.add(new int[]{1,2,3,4});
//        System.out.println(l.toString());
    }
}