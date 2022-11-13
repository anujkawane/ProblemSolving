package LinkedList;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    public class Node{
        int key, value;
        Node prev, next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
        public Node(){
            this(0,0);
        }
    }

    Map<Integer, Node> map;
    int capacity, count;
    Node head, tail;


    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        this.count = 0;
    }

    public int get(int key) {
        if(!map.containsKey(key))
            return -1;

        Node node = map.get(key);
        update(node);
        return node.value;
    }

    private void remove(Node node) {
        Node after = node.next;
        Node before = node.prev;
        before.next = after;
        after.prev = before;
    }

    private void update(Node node) {
        remove(node);
        add(node);
    }

    public void add(Node node){
        Node after = head.next;
        head.next = node;
        node.prev = head;
        node.next = after;
        after.prev = node;
    }

    public void put(int key, int value) {
        Node toAdd = map.get(key);
        if(toAdd == null){
            toAdd = new Node(key, value);
            map.put(key, toAdd);
            add(toAdd);
            count++;
        }else{
            toAdd.value = value;
            update(toAdd);
        }

        if(count > capacity){
            Node delete = tail.prev;
            remove(delete);
            map.remove(delete.key);
            count--;
        }
    }

}