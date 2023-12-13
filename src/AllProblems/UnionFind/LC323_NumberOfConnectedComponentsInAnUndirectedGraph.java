package AllProblems.UnionFind;

/**
 * You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.
 *
 * Return the number of connected components in the graph.
 *
 *
 * Input: n = 5, edges = [[0,1],[1,2],[3,4]]
 * Output: 2
 *
 * Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
 * Output: 1
 */
public class LC323_NumberOfConnectedComponentsInAnUndirectedGraph {

    class UnionFind{
        int[] root, rank;
        int count;

        public UnionFind(int size){
            count = size;
            root = new int[size];
            rank = new int[size];
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
            int rootX = find(x);
            int rootY = find(y);

            if(rootX != rootY){
                if(rank[rootX] > rank[rootY]){
                    root[rootY] = rootX;
                } else if(rank[rootX] < rank[rootY]){
                    root[rootX] = rootY;
                } else{
                    root[rootY] = rootX;
                    rank[rootX] +=1;
                }
                count--;
            } else{
                return false;
            }
            return true;
        }

        public int getCount(){
            return count;
        }
    }
    public int countComponents(int n, int[][] edges) {

        UnionFind uf = new UnionFind(n);

        for(int[] a : edges){
            uf.union(a[0], a[1]);
        }

        return uf.getCount();
    }

    public static void main(String[] args) {

    }
}
