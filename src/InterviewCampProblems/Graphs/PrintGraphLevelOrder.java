package InterviewCampProblems.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

enum State {UNVISITED, VISITING, VISITED;}

class Node {
    List<Node> neighbors;
    int data;
    State state;

    public Node(int data) {
        super();
        this.data = data;
        state = State.UNVISITED;
        neighbors = new ArrayList<Node>();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void addNeighbor(Node node) {
        neighbors.add(node);
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }
}

public class PrintGraphLevelOrder {

    public void printLevelsSingleQueue(Node root) {

        Queue<Node> q = new LinkedList<>();

        q.add(root);
        root.setState(State.VISITING);
        Node marker = new Node(0);
        q.add(marker);

        while(!q.isEmpty()){
            Node current = q.remove();
            if(current == marker){
                if(!q.isEmpty()){
                    q.add(marker);
                }
                System.out.println();
                continue;
            }

            System.out.print(current.data+" ");

            for(Node neighbor : current.getNeighbors()){
                if(neighbor.state == State.UNVISITED){
                    q.add(neighbor);
                    neighbor.state = State.VISITING;
                }
            }
            current.state = State.VISITED;
        }

    }

    public static void main(String[] args) {

        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        root.addNeighbor(node2);
        root.addNeighbor(node3);
        node2.addNeighbor(node4);
        node2.addNeighbor(node5);
        node3.addNeighbor(node6);
        node4.addNeighbor(node5);
        node5.addNeighbor(node3);

        PrintGraphLevelOrder o = new PrintGraphLevelOrder();
        o.printLevelsSingleQueue(root);
    }
}
