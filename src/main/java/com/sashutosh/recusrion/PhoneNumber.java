package com.sashutosh.recusrion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PhoneNumber {

    public static void main(String[] args) {
        PhoneNumber pn = new PhoneNumber();
        pn.letterCombinations("23");
    }
    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0){
            return new ArrayList<String>();
        }
        Map<Character,List<Character>> nums = new HashMap<>();
        nums.put('2', Arrays.asList('a','b','c'));
        nums.put('3', Arrays.asList('d','e','f'));
        nums.put('4', Arrays.asList('g','h','i'));
        nums.put('5', Arrays.asList('j','k','l'));
        nums.put('6', Arrays.asList('m','n','o'));
        nums.put('7', Arrays.asList('p','q','r','s'));
        nums.put('8', Arrays.asList('t','u','v'));
        nums.put('9', Arrays.asList('w','x','y','z'));

        List<String> comb = new ArrayList<>();
        combinations(digits,0, digits.length(),"",nums,comb);
        return comb;
    }

    private void combinations(String digits,int pos,int len, String str, Map<Character, List<Character>> pattern, List<String> comb) {

        if(pos==len){
            comb.add(str);
            return;
        }
        Character ch = str.charAt(pos);
        List<Character> chars = pattern.get(ch);
        for(int i=0;i<chars.size();i++) {
            str = str + chars.get(i);
            combinations(digits,pos+1,len,str,pattern,comb);
        }
    }
}