package AllProblems.InterviewCampProblems.Queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueWithMax {

    Queue<Integer> queue;
    Deque<Integer> maxQ;

    public QueueWithMax(){
        queue = new LinkedList<>();
        maxQ = new LinkedList<>();
    }

    public int getMax() throws QueueEmptyException {
        if(maxQ.isEmpty())
            throw new QueueEmptyException("Empty Queue");
        return maxQ.getFirst();
    }


    public void enqueue(int num){
        queue.add(num);
        while (!maxQ.isEmpty() && maxQ.getLast() < num)
            maxQ.removeLast();
        maxQ.addLast(num);
    }


    public void dequeue() throws QueueEmptyException {
        if(!queue.isEmpty())
            throw new QueueEmptyException("Empty Queue");
        int item = queue.remove();
        if(maxQ.getFirst() == item) {
            maxQ.removeFirst();
        }
    }


}
