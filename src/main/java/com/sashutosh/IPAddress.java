package com.sashutosh;

import java.util.ArrayList;

public class IPAddress {
    public static void main(String[] args) {
        IPAddress ipAddress = new IPAddress();
        ArrayList<String> strings = ipAddress.validIPAddresses("1921680");
        System.out.println(strings);
    }
    public boolean isValid(String octet1){
        if(octet1==null || octet1.length()==0)
            return false;
        if(Integer.valueOf(octet1) > 255){
            return false;
        }
        return true;
    }
    
    private String substr(String str, int start, int end) {
        String res="";
        for(int i=start; i<=end; i++) {
            res = res + str.charAt(i);
        }
        return res;
    }

    public String normalize(String octet) {
        return Integer.valueOf(octet).toString();
    }

    public boolean allValid(String octet1, String octet2, String octet3, String octet4, String str){
        String result = octet1+octet2+octet3+octet4;
        if(result.length()==str.length()){
            return true;
        }
        return false;
    }

    



    public ArrayList<String> validIPAddresses(String string) {
        // Write your code here.
        ArrayList<String> result = new ArrayList<>();
        for(int i=0;i<3;i++){
            String octet1 = substr(string,0,i);
            if(isValid(octet1))  {
                for(int j=i+1;j<i+4 && j< string.length();j++) {
                    String octet2= substr(string,i+1,j);
                    if(isValid(octet2)){
                        for(int k= j+1; k<j+4 && k<string.length();k++) {
                            String octet3= substr(string,j+1,k);
                            if(isValid(octet3)){
                                for(int l=k+1;k<l+3 && l < string.length();l++){
                                    String octet4 = substr(string,k+1,l);
                                    if(isValid(octet4)) {
                                        if(allValid(octet1,octet2,octet3,octet4,string)){
                                            result.add(normalize(octet1)+"."+normalize(octet2)+"."+normalize(octet3)+"."+normalize(octet4));
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            }

        }

        return new ArrayList<>(result);
    }
}
