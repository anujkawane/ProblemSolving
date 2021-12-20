package Graphs;

import java.awt.*;
import java.util.*;
import java.util.List;

enum State {
    UNVISITED,
    VISITING,
    VISITED
}
class Node{
    List<Node> neighbors;
    int data;
    State state;

    public Node(int data) {
        this.neighbors = new ArrayList<>();
        this.data = data;
        this.state = State.UNVISITED;
    }
    public List<Node> getNeighbors() {
        return neighbors;
    }
    public void addNeighbor(Node node) {
        neighbors.add(node);
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}

class Graph{
    List<Node> nodes;

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public void addNode(Node node){
        this.nodes.add(node);
    }

    public List<Node> getNodes(){
        return nodes;
    }
}

public class GraphDFS_BFS {

    /*
    Find target node in Graph: return True if target present, false otherwise
     */

    public boolean findTargetUsingDFS(Graph graph, int target){
        for(Node node : graph.getNodes()){
            if(node.getState() == State.UNVISITED && findTargetUsingDFSHelper(node, target)){
                return true;
            }
        }
        return false;
    }

    public boolean findTargetUsingDFSHelper(Node node, int target){
        node.setState(State.VISITING);
        if(node.getData() == target)
            return true;
        for(Node neighbor : node.getNeighbors()){
            if(neighbor.getState() == State.UNVISITED && findTargetUsingDFSHelper(neighbor, target))
                return true;
        }
        node.setState(State.VISITED);
        return false;
    }

    /*
    Print DFS of graph
     */

    public void printDFS(Graph graph){
        for(Node node : graph.getNodes()){
            if(node.getState() == State.UNVISITED){
                dfs(node);
            }
        }
    }
    public void dfs(Node start){
        start.setState(State.VISITING);
        System.out.print(start.getData()+" ");
        for(Node neighbor : start.getNeighbors()){
            if(neighbor.getState() == State.UNVISITED){
                dfs(neighbor);
            }
        }
        start.setState(State.VISITED);
    }

    public void printBFS(Graph graph){
        for(Node node : graph.getNodes()){
            if(node.getState() == State.UNVISITED){
                bfs(node);
            }
        }
    }

    public void bfs(Node start){
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            Node current = q.peek();
            current.setState(State.VISITING);
            System.out.print(current.getData()+" ");
            for(Node neighbor : current.getNeighbors()){
                if(neighbor.getState() == State.UNVISITED){
                    q.add(neighbor);
                }
            }
            q.peek().setState(State.VISITED);
            q.remove();
        }
    }

    public boolean hasCycle(Graph graph){
        for(Node node : graph.getNodes()){
            if(node.getState() ==  State.UNVISITED && detectCycleDFS(node)){
                return true;
            }
        }
        return false;
    }
    boolean detectCycleDFS(Node start){
        start.setState(State.VISITING);
        for(Node neighbor : start.getNeighbors()){
            if(neighbor.getState() == State.UNVISITED && detectCycleDFS(neighbor))
                return true;
            if(neighbor.getState() == State.VISITING)
                return true;
        }
        start.setState(State.VISITED);
        return false;
    }

    public boolean isBipartite(int[][] graph) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0;i<graph.length;i++){
            map.put(i,new ArrayList<>());
            for(int j = 0;j<graph[i].length;j++){
                map.get(i).add(graph[i][j]);
            }
        }

        int[] visited = new int[graph.length];
//        0 = Un, 1 = Visiting, 3 = VIsited
        Arrays.fill(visited,0);
        int[] level = new int[graph.length];

        for(Integer n : map.keySet()){
            level[n] = 0;
            if(visited[n]==0 && !isBipartiteHelper(n, visited,level,map)){
                return false;
            }
        }
        return true;
    }

    public boolean isBipartiteHelper(Integer node, int[] visited, int[] level, HashMap<Integer, List<Integer>> map){
        visited[node] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            Integer current = q.peek();
            for(Integer neighbor : map.get(current)){
                if(visited[neighbor]==0){
                    q.add(neighbor);
                    level[neighbor] = level[current]+1;
                    visited[neighbor] = 1;
                }
                if(level[current]==level[neighbor])
                    return false;
            }
            visited[q.peek()] = 2;
            q.remove();
        }
        return true;
    }
    public static void main(String[] args) {

        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        a.addNeighbor(b);
        a.addNeighbor(c);
        b.addNeighbor(e);
        c.addNeighbor(b);
        c.addNeighbor(d);
        d.addNeighbor(e);
//        e.addNeighbor(a); // create cycle e->a (5->1)
        Graph g = new Graph();
        g.addNode(a);
        g.addNode(b);
        g.addNode(c);
        g.addNode(d);
        g.addNode(e);

        GraphDFS_BFS dfs = new GraphDFS_BFS();
//        System.out.println(dfs.findTargetUsingDFS(g,6));
//        dfs.printDFS(g);
//        System.out.println();
//        System.out.println("BFS below");
//        Stack<Integer> stack = new Stack<>();
//        stack.pop();
//        dfs.printBFS(g);

        System.out.println(dfs.hasCycle(g));

        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(dfs.isBipartite(graph));

    }

}
