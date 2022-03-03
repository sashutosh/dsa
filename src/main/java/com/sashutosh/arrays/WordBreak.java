package com.sashutosh.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        String s = "aaaaaaa";
        List<String> data = Arrays.asList("aaaa","aaa");
        wordBreak(s,data);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        Set<String> result = new HashSet<>();
        for(String word:wordDict) {
            wordSet.add(word);
        }
        String str = s;
        boolean found=false;
        while(str.length() > 0) {
            String current = "";
            found=false;
            for(int i=0;i< str.length();i++) {
                current+= str.charAt(i);
                if(wordSet.contains(current)) {
                    found=true;
                    str= str.substring(current.length());
                    break;
                }
            }
            if(!found)
                return false;
        }
        return true;

    }
}
