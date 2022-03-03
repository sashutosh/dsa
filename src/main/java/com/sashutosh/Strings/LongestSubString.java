package com.sashutosh.Strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
    public static void main(String[] args) {
        LongestSubString ls = new LongestSubString();
        int len = ls.lengthOfLongestSubstring("dvdf");
        System.out.println(len);
    }
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int len=0;
        String subStr="";
        if(s==null || s.length()==0)
            return 0;

        for(int i=0;i<s.length();i++) {
            set.clear();;
            subStr="";
            for(int j=i;j<s.length();j++) {
                char ch = s.charAt(j);
                if (!set.contains(ch)) {
                    subStr += ch;
                    set.add(ch);
                } else {
                    set.clear();

                    break;
                    /*subStr = "" + ch;
                    set.add(ch);*/
                }
                if (subStr.length() > len) {
                    len = subStr.length();
                }
            }
        }
        if(subStr.length() > len)
        {
            len = subStr.length();
        }
        return len;
    }

}
