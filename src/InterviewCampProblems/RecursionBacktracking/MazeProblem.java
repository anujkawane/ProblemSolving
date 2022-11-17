package InterviewCampProblems.RecursionBacktracking;

/*
Maze Problem: You are given a 2D array that represents a maze.
It can have 2 values - 0 and 1.1 represents a wall and 0 represents a path.
The objective is to reach the bottom right corner, i.e, A[A.length-1][A.length-1]. You start fromA[0][0].
 You can move in 4 directions - up, down, left and right.
 Find if a path exists to the bottom right of the maze.For example,
 a path exists in the following maze:
 {{0, 1, 1, 1 },
  {0, 1, 1, 1 },
  {0, 0, 0, 0 },
  {1, 1, 1, 0 }}
 */
public class MazeProblem {


    static int[] rows = {1, 0, -1, 0};
    static int[] cols = {0, -1, 0, 1};

    public static boolean pathExists(int[][] a){
        if(a.length == 0 || a == null)
            return false;
        boolean[][] visited = new boolean[a.length][a[0].length];

        return helper(a, 0 , 0, visited);
    }

    public static boolean helper(int[][] a, int row, int col, boolean[][] visited){
        if((row < 0 || row >= a.length || col < 0 || col >=a[0].length) || a[row][col] == 1)
            return false;
        if(row == a.length-1 && col == a[0].length-1)
            return true;
        if(visited[row][col])
            return false;

        visited[row][col] = true;
        for(int i = 0; i < 4; i++){
            if(helper(a, row + rows[i], col + cols[i], visited)) {
                return true;
            }
        }
      return false;
    }

    public static void main(String[] args) {
        int[][] a = {
                        {0, 1, 1, 1 },
                        {0, 1, 1, 1 },
                        {0, 0, 1, 0 },
                        {1, 0, 0, 0 }
                    };

        System.out.println(pathExists(a));
    }
}
