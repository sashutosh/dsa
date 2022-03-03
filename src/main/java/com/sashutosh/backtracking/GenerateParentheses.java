package com.sashutosh.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(n,"",0, 0, result);
        return result;
    }

    public static void generate(int n, String cur,int start,int end,List<String> result){
        if(start==n && end == n){
            result.add(cur);
        }
        if(start < n)
            generate(n,cur+ "(",start+1,end,result);
        if(end < start){
            generate(n,cur+ ")",start,end+1,result);

        }

    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(2);
        System.out.println(strings);
    }

}
