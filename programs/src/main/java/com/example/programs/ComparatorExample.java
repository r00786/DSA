package com.example.programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {


        public static void main(String[] args) {
            Integer[] numbers = {5, 3, 8, 1, 2, 7, 4, 6};
            Arrays.sort(numbers, new Comparator<Integer>(){
                @Override
                public int compare(Integer a,Integer b){
                    return a>b?1:a==b?0:-1;
                }
            });
            System.out.println("Ascending Order "+Arrays.toString(numbers));
            Arrays.sort(numbers,new Comparator<Integer>(){
                public int compare(Integer one ,Integer two){
                    return one > two ? -1:one==two?0:1;
                }
            });
            System.out.println("Descending Order "+Arrays.toString(numbers));
            List<Integer> list = Arrays.asList(numbers);
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer integer, Integer t1) {
                    return integer.compareTo(t1);
                }
            });
            System.out.println("Asecnding Order "+Arrays.toString(Arrays.stream(numbers).toArray()));





        }
}
