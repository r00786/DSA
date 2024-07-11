package com.example.programs.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * url- https://leetcode.com/problems/valid-parentheses/description/
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */

public class ValidParenthesis {


    public boolean isValid(String s) {
        Map<Character,Character> brackets= new HashMap();
        brackets.put('(',')');
        brackets.put('{','}');
        brackets.put('[',']');
        Stack<Character> stack= new Stack();
        for(char c :s.toCharArray()){
            if(brackets.containsKey(c)){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    char previousOpening=stack.pop();
                    if(brackets.get(previousOpening)!=c){
                        return false;
                    }
                }
            }

        }
        return stack.isEmpty();
    }
}
