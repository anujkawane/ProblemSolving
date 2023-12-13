package AllProblems.TikTok;

import java.util.*;

public class HR4_DustControl {

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));

        int[] current = intervals[0];
        List<int[]> result = new ArrayList<>();
        result.add(current);
        for(int[] next : intervals){
            int preEnd = current[1];
            int nextStart = next[0];
            int nextEnd = next[1];

            if(preEnd >= nextStart){
                current[1] = Math.max(preEnd, nextEnd);
            }else{
                current = next;
                result.add(current);
            }
        }
        return result.toArray(new int[result.size()][]);
    }


    public static int ans(int[] coins, int target, int k) {
        if (coins == null || coins.length == 0 || target <= 0)
            return 0;

        int[] result = new int[1];

        printCoinsHelper(coins, target, 0, new Stack<Integer>(), 0, k, result);

        return result[0];
    }
    public static void printCoinsHelper(int[] coins, int target, int startIndex,Stack<Integer> buffer, int sum, int k, int[] result) {

        if (sum > target || buffer.size() > k) {
            return;
        }
        if (sum == target) {
            if(buffer.size() == k){
                result[0] +=1;
            }
            return;
        }

        for(int i = startIndex; i < coins.length; i++) {
            buffer.push(coins[i]);
            printCoinsHelper(coins, target, i, buffer, sum + coins[i], k, result);
            buffer.pop();
        }
    }


    private static Integer[][][] dp;
    public static int change(int[] coins, int amount, int k) {
        if(k <= 0){
            return 0;
        }
        if (amount == 0)
            return 1;
        if (coins.length == 0)
            return 0;
        dp = new Integer[coins.length][amount + 1][k + 1];

        return changeFrom(amount, coins, 0, k);
    }

    private static int changeFrom(int amount, int[] coins, int currentIndex, int k) {
        if (amount == 0 && k == 0)
            return 1;

        if (amount < 0 || currentIndex == coins.length || k < 0)
            return 0;

        if (dp[currentIndex][amount][k] != null)
            return dp[currentIndex][amount][k];

        // Recursive call after selecting the coin at the currentIndex
        int sum1 = changeFrom(amount - coins[currentIndex], coins, currentIndex, k - 1);

        // Recursive call after excluding the coin at the currentIndex
        int sum2 = changeFrom(amount, coins, currentIndex + 1, k);

        dp[currentIndex][amount][k] = sum1 + sum2;
        return dp[currentIndex][amount][k];
    }



    public static void main(String[] args) {



        System.out.println(change( new int[]{10,30,50},200, 8));
//        int m = 2, n = 7;
//
//        int[][] arr = {{0,3}, {2,4}};

//
//
//        Set<Integer> set = new HashSet<>();
//        for(int i = 0; i < n; i++){
//            set.add(i);
//        }
//
//        int[][] result  = merge(arr);
//        for(int[] a : result){
//            for(int j = a[0]; j <= a[1]; j++){
//                if(set.contains(j)){
//                    set.remove(j);
//                }
//            }
//        }
//        System.out.println(set.size());
    }

}
