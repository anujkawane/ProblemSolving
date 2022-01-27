package InterviewCampProblems.Queue;

import java.util.*;

/*
239. Sliding Window Maximum (Hard)

You are given an array of integers nums, there is a sliding window of size k which is moving from the very
 left of the array to the very right. You can only see the k numbers in the window.
 Each time the sliding window moves right by one position.
 */
public class SlidingWindowMaximum {

    Queue<Integer> q;
    Deque<Integer> maxQ;

    public SlidingWindowMaximum(){
        q = new LinkedList<>();
        maxQ = new LinkedList<>();
    }

    public int getMax(){
        return maxQ.getFirst();
    }

    public void enque(int num){
        q.add(num);
        while(!maxQ.isEmpty() && maxQ.getLast() < num){
            maxQ.removeLast();
        }
        maxQ.addLast(num);
    }

    public void deque(){
        int item = q.remove();
        if(maxQ.getFirst() == item){
            maxQ.remove();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while(q.size() != k){
            enque(nums[i]);
            i++;
        }
        res.add(getMax());

        for( int j = i; j < nums.length; j++){
            deque();
            enque(nums[j]);
            res.add(getMax());
        }
        return res.stream().mapToInt(idx -> idx).toArray();
    }
}
