package com.example.programs;

public class LongestSubstringWith1Zero {
    public static void main(String[] arr){
        System.out.println(new LongestSubstringWith1Zero().findLength("1101100111"));
    }

    public static int findLength(String s){
        int left=0;
        int zeroCount=0;
        int answer=0;
        for(int right=0;right<s.length();right++){
            if(s.charAt(right)=='0'){
                zeroCount+=1;
            }
            while(zeroCount>1){
                if(s.charAt(left)=='0'){
                    zeroCount-=1;
                }
                left++;

            }
           answer= Math.max(right-left+1,answer);
        }
        return answer;

    }
}
