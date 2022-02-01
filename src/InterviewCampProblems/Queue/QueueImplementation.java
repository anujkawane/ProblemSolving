package InterviewCampProblems.Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
    implement Queue using Array
 */
public class QueueImplementation {
    int capacity, front, rear;
    int[] array;

    public QueueImplementation(int capacity){
        this.capacity = 0;
        this.front=0;
        this.rear = 0;
        this.array = new int[capacity];
    }


    public int remove() throws QueueEmptyException {
        if(capacity == 0)
          throw new QueueEmptyException("Empty Queue");
        int result = array[front];
        front = (front+1) % array.length;
        capacity--;
        return result;
    }

    public int getHowMany(){
        return capacity;
    }

    public int peek() throws QueueEmptyException{
        if(capacity == 0)
            throw new QueueEmptyException("Empty Queue");
        return array[front];
    }

    public void add(int n) throws QueueFullException {
        if (capacity == array.length)
            throw new QueueFullException("Queue Full");
        array[rear] = n;
        rear = (rear + 1) % array.length;
        capacity++;
    }

//    size(), isEmpty(), isFull()


    public static int[] slidingWindowSum(int[] a, int k){
        List<Integer> result = new ArrayList<>();
        java.util.Queue<Integer> q = new LinkedList<>();
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
           QueueImplementation q = new QueueImplementation(5);
           try{
              q.add(6);


           }catch (Exception e){
               System.out.println(e);

           }

        }
    }





