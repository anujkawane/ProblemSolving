package AllProblems.InterviewCampProblems.RecursionBacktracking;

import java.util.Arrays;

/*
Level: Medium
    Given an array of integers, print all combinations of size X.

Solution:

    We use a buffer of size X with a recursive function "printCombosHelper".
    In any recursive call to printCombosHelper(), the buffer is filled up to a certain index
     i-1, and the task for the function call is to fill index i. If 'i' is greater than the size of the buffer,
     then the buffer is full, and we print its contents.Otherwise,
     we find the candidates from the input array that can go into index i.
     We place each candidate into index i and then call printCombosHelper() for i+1.
 */
public class CombinationOfSizeX {


    public static void printCombosOfX(int[] num, int x){
        if(num == null || num.length==0 || x > num.length)
            return;

        int[] buffer = new int[x];
        printComboHelper(num, buffer, 0, 0);
    }

    public static void printComboHelper(int[] num, int[] buffer, int startIndex, int bufferIndex){
        if(bufferIndex == buffer.length){
            System.out.println(Arrays.toString(buffer));
            return;
        }

        if(startIndex == num.length)
            return;

        for(int i = startIndex; i < num.length; i++) {
            buffer[bufferIndex] = num[i];
            printComboHelper(num, buffer, i + 1, bufferIndex+1);
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        printCombosOfX(a, 3);
    }
}
