package AllProblems.Graphs.UnionFind;

public class LC323_NumberOfConnectedComponentsInUndirectedGraph {

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
            if(x == root[x]){
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
                    rank[rootX] += 1;
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

        for(int[] edge : edges){
            uf.union(edge[0], edge[1]);
        }

        return uf.getCount();
    }

    public static void main(String[] args) {
        LC323_NumberOfConnectedComponentsInUndirectedGraph ob =
                new LC323_NumberOfConnectedComponentsInUndirectedGraph();

        int[][] a = {{0,1}, {1,2}, {0,2}, {3,4}};
        ob.countComponents(5, a);

    }

}