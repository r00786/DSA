package com.example.programs;

public class ReverseOnlyLetters {
    public static void main(String[] arr){
        System.out.println(new ReverseOnlyLetters().reverseOnlyLetters("Qedo1ct-eeLg=ntse-T!"));
    }

        public String reverseOnlyLetters(String s) {
            int left=0;
            int right=s.length()-1;
            StringBuilder reversedString= new StringBuilder(s);
            while(left<right){
                boolean isLeftCharValid=isAlphabet(s.charAt(left));
                boolean isRightCharValid= isAlphabet(s.charAt(right));
                if(!isLeftCharValid){
                    left++;
                }
                if(!isRightCharValid){
                    right--;
                }
                if(isLeftCharValid&&isRightCharValid){
                    reversedString.setCharAt(left,s.charAt(right));
                    reversedString.setCharAt(right,s.charAt(left));
                    left++;
                    right--;
                }
            }

            return reversedString.toString();
        }

        public boolean isAlphabet(char s) {
            return (s >= 'a' && s <= 'z') || (s >= 'A' && s <= 'Z');
        }
}
