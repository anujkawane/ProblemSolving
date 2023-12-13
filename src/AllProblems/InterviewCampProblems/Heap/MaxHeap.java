package AllProblems.InterviewCampProblems.Heap;

public class MaxHeap {

    int[] maxHeap;
    int size, currentSize;

    public MaxHeap(int size){
        this.maxHeap = new int[size + 1];
        this.size = size;
        currentSize = 0;
        maxHeap[0] = 0;
    }

    public void add(int item){
        currentSize++;
        if(currentSize > size){
            System.out.println("Full");
            currentSize--;
            return;
        }

        maxHeap[currentSize] = item;
        int index = currentSize;
        int parent  = index / 2;

    }

    public int pop(){
        return 0;
    }

    public int peek(){
        if(currentSize < 1){
            System.out.println("Empty Heap No element at peek");
            return Integer.MIN_VALUE;
        }
        return maxHeap[1];
    }

    public int size(){
        return currentSize;
    }

}
