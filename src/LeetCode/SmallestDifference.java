package LeetCode;

import java.util.Arrays;

/*
Write a function that takes in two non-empty arrays of integers, finds the pair of numbers (one from each array)
whose absolute difference is closest to zero, and returns an array containing these two numbers, with the number
 from the first array in the first position. Note that the absolute difference of two integers is the distance between
  them on the real number line. For example, the absolute difference of -5 and 5 is 10, and the absolute difference of
  -5 and -4 is 1. You can assume that there will only be one pair of numbers with the smallest difference.
  Sample Input : arrayOne = [-1, 5, 10, 20, 28, 3]
                 arrayTwo = [26, 134, 135, 15, 17]
  Sample Output [28, 26]
 */
public class SmallestDifference {
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        int[] result = new int[2];
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int pointer1 = 0;
        int p2 = 0;
        int diff = Integer.MAX_VALUE;
        while (pointer1 < arrayOne.length && p2 < arrayTwo.length) {
            int currentdiff = Math.abs(arrayOne[pointer1] - arrayTwo[p2]);
            if (diff > currentdiff) {
                diff = currentdiff;
                result = new int[]{arrayOne[pointer1], arrayTwo[p2]};
            }
            if (arrayOne[pointer1] < arrayTwo[p2])
                pointer1++;
            else if (arrayOne[pointer1] > arrayTwo[p2])
                p2++;
            else
                return new int[]{arrayOne[pointer1], arrayTwo[p2]};
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a1 = {-1, 5, 10, 20, 28, 3};
        int[] a2 = {26, 134, 135, 15, 17};
        System.out.println(smallestDifference(a1, a2));
    }
}
