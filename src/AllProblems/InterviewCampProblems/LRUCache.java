package AllProblems.InterviewCampProblems;
import java.util.*;

public class LRUCache {

    class Node{
        int key, value;
        Node next, prev;
        public Node(){
            key = 0;
            value = 0;
            next = null;
            prev = null;
        }
    }

    HashMap<Integer, Node> map = new HashMap<>();
    int capacity, count;
    Node head, tail;
    public LRUCache(int capacity){
        this.capacity = capacity;
        count = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int read(int key){
        if(!map.containsKey(key))
            return -1;

        Node current = map.get(key);
        int value = current.value;
        update(current);
        return value;
    }

    public void add(Node node){
        Node current = head.next;
        head.next = node;
        node.prev = head;
        node.next = current;
        current.prev = node;
    }

    public void remove(Node node){
        Node prev = node.prev;
        prev.next = node.next;
        node.next.prev = prev;
    }

    public void update(Node node){
        remove(node);
        add(node);
    }
    public void insert(int key, int value){
        Node current = null;
        if(map.containsKey(key)){
            current = map.get(key);
            current.value = value;
            update(current);
            return;
        }

        if(current == null){
            current = new Node();
            current.key = key;
            current.value = value;
            map.put(key, current);

        }

        if(count >= capacity){
            Node delete = tail.prev;
            remove(delete);
            count--;
            map.remove(key);
        }

        add(current);
        count++;

    }


}
