package LeetCode;

import java.util.*;
/*
You're given an array of integers and an integer. Write a function that moves all instances of that integer in the array
 to the end of the array and returns the array. The function should perform this in place (i.e., it should mutate the
 input array) and doesn't need to maintain the order of the other integers.
 Sample Input array = [2, 1, 2, 2, 2, 3, 4, 2] toMove = 2
 Sample Output [1, 3, 4, 2, 2, 2, 2, 2]
     // the numbers 1, 3, and 4 could be ordered differently
 */
public class MoveElementToEnd {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int j = 0;
        int count = 0;
        int start = 0;
        while (start < array.size()) {
            if (array.get(start) != toMove) {
                array.set(j, array.get(start));
                j++;
            }
            start++;
        }
        for (int i = j; i < array.size(); i++) {
            array.set(i, toMove);
        }
        return array;
    }

    public static List<Integer> moveElementToEnd1(List<Integer> array, int toMove) {
        int index = array.size()-1;
        for(int i = array.size()-1; i>=0;i--){
            if(array.get(i)==toMove){
                Collections.swap(array, i, index);
                index--;
            }
        }
        return array;
    }
}
