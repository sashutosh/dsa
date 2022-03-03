package com.sashutosh;

import java.util.stream.IntStream;

public class StringAdd {
    public static String add(String s1, String s2) {
        String smaller =s1;
        String bigger=s2;
        String result="";
        int carry=0;
        if(s1.length()>s2.length()) {
            smaller = s2;
            bigger =s1;
        }
        int diff = bigger.length()-smaller.length();
        if(diff > 0) {
            for(int i=0;i<diff;i++) {
                smaller = "0" + smaller;
            }
        }
        for(int i= bigger.length()-1;i> -1;i--) {
            Integer val1 = Integer.parseInt(String.valueOf(bigger.charAt(i)));
            Integer val2 = Integer.parseInt(String.valueOf(smaller.charAt(i)));
            int res = val1 + val2 + carry;
            if(res > 9) {
                res= res%10;
                //res = res + carry;
                carry=1;
            }
            else {
                carry =0;
            }
            result = res + result;
        }
        if(carry>0)
            result = "1" + result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(add("9999" , "1"));
    }
}
