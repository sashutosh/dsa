package com.sashutosh.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public static List<String> permute(String s) {
        List<String> results = new ArrayList<>();
        permuteHelper(s,0,results);
        return results;
    }

    private static void permuteHelper(String s, int i, List<String> results) {
        if(i==s.length()-1){
            results.add(s);
        }

        for(int j=i;j<s.length();j++){
            s=swap(s,i,j);
            permuteHelper(s,i+1,results);
            s=swap(s,j,i);
        }
    }

    private static String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp =chars[i];
        chars[i]= chars[j];
        chars[j] = temp;
        return String.valueOf(chars);
    }


    public static void main(String[] args) {
        List<String> done = permute("done");
        System.out.println(done);
    }

    /* private static void permuteHelper(String s, String chosen, List<String> results) {
        if(s.length()==0){
            results.add(chosen);
            return;
        }

        for (int i=0;i<s.length();i++) {
            Character ch = s.charAt(i);
            s = removeCharAt(s,i);
            chosen = chosen + ch;
            permuteHelper(s,chosen,results);
            s = addCharAt(s,ch,i);
            chosen=chosen.substring(0,chosen.length()-1);
        }

    }

    private static String addCharAt(String s, Character ch, int i) {
        if(i==0)
            return ch+s;
        if(i==s.length())
            return s+ch;
        if(s.length()==0){
            return String.valueOf(ch);
        }
        return s.substring(0,i-1)+ ch + s.substring(i);
    }

    private static String removeCharAt(String s, int i) {
        if (i==0)
            return s.substring(1);
        if(s.length()==2 && i==1){
            return String.valueOf(s.charAt(0));
        }
        if(i==s.length()-1)
            return s.substring(0,i-1);
        return s.substring(0,i-1) + s.substring(i+1);
    }*/
}
