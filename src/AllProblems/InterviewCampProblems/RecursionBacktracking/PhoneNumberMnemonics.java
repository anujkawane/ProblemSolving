package AllProblems.InterviewCampProblems.RecursionBacktracking;
import java.util.*;
/*
17. Letter Combinations of a Phone Number
Medium

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
Example 1:
    Input: digits = "23"
    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:
    Input: digits = ""
    Output: []

Example 3:
    Input: digits = "2"
    Output: ["a","b","c"]
 */
class PhoneNumberMnemonics {

    HashMap<Character, char[]> map = new HashMap<>();

    public PhoneNumberMnemonics()
    {
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});
        map.put('5', new char[]{'j','k','l'});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'p','q','r','s'});
        map.put('8', new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0 || digits==null)
            return new ArrayList<>();

        char[] nums = digits.toCharArray();
        char[] buffer = new char[digits.length()];
        List<String> result = new ArrayList<>();
        helper(nums, buffer, 0 , 0, result);
        return result;
    }

    public void helper(char[] arr, char[] buffer, int startIndex, int bufferIndex, List<String> result){

        if(bufferIndex == buffer.length){
            result.add(String.valueOf(buffer));
            return;
        }

        if(startIndex == arr.length)
            return;

        char[] types = map.get(arr[startIndex]);

        for(char c : types){
            buffer[bufferIndex] = c;
            helper(arr, buffer, startIndex + 1 , bufferIndex + 1, result);
        }
    }
}
