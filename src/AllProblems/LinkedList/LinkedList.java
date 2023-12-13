package AllProblems.LinkedList;

class Node {
    Node next;
    int data;
    public Node(Node next, int data) {
        super();
        this.next = next;
        this.data = data;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
}
public class LinkedList {
    Node head;
    Node tail;
    public LinkedList(Node head, Node tail) {
        super();
        this.head = head;
        this.tail = tail;
    }
    public Node getHead() {
        return head;
    }
    public void setHead(Node head) {
        this.head = head;
    }
    public Node getTail() {
        return tail;
    }
    public void setTail(Node tail) {
        this.tail = tail;
    }

    /*
   Function to get nth node from the list
     */
    public Node get(int n) {
        Node node = head;
        for (int i = 0; i < n - 1; i++) {
            if (node != null) node = node.getNext();
            else {
                throw new IndexOutOfBoundsException("No node at index " + Integer.toString(n));
            }
        }
        if (node == null) {
            throw new IndexOutOfBoundsException("No node at index " + Integer.toString(n));
        }
        return node;
    }


    /*
    Reverse LL
     */
    public Node reveresLL(Node head){
        Node prev = null;
        Node temp = head;
        while(temp!=null){
            Node next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        head = prev;

        return head;
    }

    public boolean isPalindrom(){
        Node median = finMedianOfLL();
        Node reversed = reveresLL(median);
        Node start = head, end = reversed;
        while (start != null && end !=null){
            if(start.data != end.data)
                return false;
            start = start.next;
            end = end.next;
        }
        return true;
    }

    public Node finMedianOfLL(){
        Node slow = head;
        Node fast = head;
        while(fast.next != null){
            fast = fast.next;
            if(fast.next == null)
                break;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {

    }

}

