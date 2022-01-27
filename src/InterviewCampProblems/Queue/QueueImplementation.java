package InterviewCampProblems.Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    implement Queue using Array
 */
public class QueueImplementation {
    int capacity, front, rear;
    int[] array;

    public QueueImplementation(int capacity){
        capacity = 0;
        front=0;
        rear = 0;
        array = new int[capacity];
    }


    public int remove() throws QueueEmptyException {
        if(capacity == 0)
          throw new QueueEmptyException();
        int result = array[front];
        front = (front+1) % array.length;
        capacity--;
        return result;
    }

    public void add(int n) throws QueueFullException {
        if (capacity == array.length)
            throw new QueueFullException();
        array[rear] = n;
        rear = (rear + 1) % array.length;
        capacity++;
    }


    public static int[] slidingWindowSum(int[] a, int k){
        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        for(int i = 0; i < a.length; i++){
            if(q.size() == k){
                sum -= q.remove();
            }
            sum += a[i];
            q.add(a[i]);
            if(q.size() == k)
                result.add(sum);
        }

        return  result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {2,3,5,6,2,1};
        for(int n: slidingWindowSum(arr, 3)){
            System.out.println(n);
        }
    }
}

class QueueFullException extends Exception {
    public QueueFullException() {

    }
}

class QueueEmptyException extends Exception {
    public QueueEmptyException() {    }
}



