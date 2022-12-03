package UnionFind;

/**
 * WRONG SOLUTION NEED TO FIX
 */
public class LC947_Most_Stones_Removed_with_Same_Row_or_Column {

    static class UnionFind{
        int[] rank, root;
        int count;

        public UnionFind(int size){
            count = size;
            root = new int[size];
            rank = new int[size];

            for(int i= 0; i < size; i++){
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
    public static int removeStones(int[][] stones) {

        int len = stones.length;

        UnionFind uf = new UnionFind(1000);

        for(int[] a : stones){
            uf.union(a[0], a[1]);
        }

        int count = 0;
        int[] root = uf.root;
        for(int i = 0; i < len; i++){
            if(i == root[i]){
                count++;
            }
        }

        return stones.length - count;
    }

    public static void main(String[] args) {
        int[][] a = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        removeStones(a);
    }
}
