package com.sashutosh.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllConstruct {

    public List<List<String>> allConstruct(String target, List<String> words){
        if(target.length()==0) {
            List<String> inner = new ArrayList<>();
            List<List<String>> res= new ArrayList<>();
            res.add(inner);
            return res;
        }
        List<List<String>> result= new ArrayList<>();
        for(int i=0;i<words.size();i++){
            if(target.startsWith(words.get(i))){
                List<List<String>> cur = allConstruct(target.substring(words.get(i).length()),words);
                for (List<String> cur_array:cur) {
                    cur_array.add(words.get(i));
                }
                result.addAll(cur);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        AllConstruct allConstruct = new AllConstruct();
        List<List<String>> lists = allConstruct.allConstruct("purple", Arrays.asList("purp", "le", "p", "ur", "purpl"));
        lists.forEach(l->l.forEach(System.out::println));
    }
}
