package com.sashutosh;

import java.util.ArrayList;
import java.util.List;

public class MultiSearch {
    public static void main(String[] args) {
        MultiSearch multiSearch = new MultiSearch();
        String bigString = "this is a big string";
        String[] small = {"this", "yo", "is", "a", "bigger", "string", "kappa"};
        multiSearch.multiStringSearch(bigString,small);
    }
    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
        // Write your code here.
        List<Boolean> matches = new ArrayList<>();
        for(String current: smallStrings) {
            boolean result = findMatch(current,bigString);
            matches.add(result);
        }
        return matches;
    }

    private static boolean findMatch(String str, String bigStr) {
        for( int i=0; i< bigStr.length(); i++) {
            char ch = bigStr.charAt(i);
            if(str.charAt(0) == ch)
                if(findRemaining(i,str,bigStr))
                    return true;
        }
        return false;
    }

    private static boolean findRemaining(int index, String str, String bigStr) {

        for(int i=1;i< str.length();i++) {
            if(str.charAt(i)!= bigStr.charAt(index+1))
                return false;
        }
        return true;
    }
}
