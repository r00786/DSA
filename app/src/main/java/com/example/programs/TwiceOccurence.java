package com.example.programs;

import java.util.HashMap;
import java.util.Map;

public class TwiceOccurence {

    public static void main(String[] arr){

        System.out.println(new TwiceOccurence().repeatedCharacter("eesll"));
    }


    public char repeatedCharacter(String s) {
        Map map =new HashMap<Character,Integer>();
        Character twice=null;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                twice=s.charAt(i);
                break;
            }
            map.put(s.charAt(i),1);

        }
        return twice;

    }
}
