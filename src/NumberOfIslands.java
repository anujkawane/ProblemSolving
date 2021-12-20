import java.util.*;


/*
https://leetcode.com/problems/number-of-islands/
 */
/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

 */

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int count  = 0;
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(grid[i][j] == '1'){
                    dfs(i,j,grid, height, width);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(int row, int col, char[][] grid, int height, int width){
        if(grid[row][col] == '1') {
            grid[row][col] = '-';
            int[] addRow = {0, 1, -1, 0};
            int[] addCol = {1, 0, 0, -1};
            for (int i = 0; i < addRow.length; i++) {
                if (-1 < row + addRow[i] && row + addRow[i] < height && -1 < col + addCol[i] && col + addCol[i] < width) {
                    dfs(row + addRow[i], col + addCol[i], grid, height, width);
                }
            }
        }
    }

    public static void main(String[] args) {

        Random rand = new Random(); //instance of random class
        int upperbound = 3;
        int int_random = rand.nextInt(upperbound);
        System.out.println(int_random);
    }
}
