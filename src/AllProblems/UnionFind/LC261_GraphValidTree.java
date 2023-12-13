package AllProblems.UnionFind;

/**
 * You have a graph of n nodes labeled from 0 to n - 1.
 * You are given an integer n and a list of edges where edges[i] = [ai, bi] indicates that there
 * is an undirected edge between nodes ai and bi in the graph.
 *
 * Return true if the edges of the given graph make up a valid tree, and false otherwise.
 *
 * Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
 * Output: true
 *
 * Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
 * Output: false
 */
public class LC261_GraphValidTree {
    class UnionFind{
        int[] root, rank;
        int count;

        public UnionFind(int size){
            root = new int[size];
            rank = new int[size];
            count = size;
            for(int i = 0; i < size; i++){
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x){
            if(root[x] == x){
                return x;
            }
            return root[x] = find(root[x]);
        }

        public boolean union(int x, int y){
            int rootx = find(x);
            int rooty = find(y);

            if(rootx != rooty){
                if(rank[rootx] == rank[rooty]){
                    root[rooty] = rootx;
                    rank[rootx] += 1;
                } else if(rank[rootx] > rank[rooty]){
                    root[rooty] = rootx;
                } else{
                    root[rootx] = rooty;
                }
                count--;
            }else {
                return false;
            }
            return true;
        }

        public int getCount(){
            return count;
        }
    }

    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);

        for(int[] a : edges){
            boolean flag = uf.union(a[0], a[1]);
            if(!flag){
                return false;
            }
        }
        if(uf.getCount() > 1){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};  // true
//        int[][] edges = {{0,1},{1,2},{2,3},{1,3},{1,4}}; //false

        LC261_GraphValidTree ob = new LC261_GraphValidTree();
        System.out.println(ob.validTree(n, edges));

    }
}
