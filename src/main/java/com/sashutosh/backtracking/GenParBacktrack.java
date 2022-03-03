package com.sashutosh.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenParBacktrack {
    public ArrayList<String> generateDivTags(int numberOfTags) {
        // Write your code here.
        ArrayList<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        //backTrack(result,current,0,0,0,numberOfTags);
        backtrack(result,current,0,0,numberOfTags);
        return result;

    }
    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        if (open < max) {
            cur.append("(");
            backtrack(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(")");
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    /*private void backTrack(ArrayList<String> result, StringBuilder cur, int index,int open,int close,int n){
        if(index==2*n){
            result.add(cur.toString());
            return;
        }
        if(open<n) {
            cur.append("<div>");
            backTrack(result,cur,index+1,open+1,close,n);
            cur = new StringBuilder(cur.substring(0,cur.length()-5));
        }
        if(close<open){
            cur.append("</div>");
            backTrack(result,cur,index+1,open,close+1,n);
            cur= new StringBuilder(cur.substring(0,cur.length()-6));
        }
    }*/

    public static void main(String[] args) {
        GenParBacktrack genParBacktrack = new GenParBacktrack();
        ArrayList<String> strings = genParBacktrack.generateDivTags(2);
        System.out.println(strings);
    }
}
