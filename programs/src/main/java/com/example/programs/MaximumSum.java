package com.example.programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumSum {
    public static void main(String[] arr){
        System.out.println(new MaximumSum().maximumSum(new int[]{18,43,36,13,7}));
    }

    public int maximumSum(int[] nums) {
        Map<Integer, Integer> dic = new HashMap<>();
        int ans = -1;
        for (int num: nums) {
            int digitSum = getDigitSum(num);
            if (dic.containsKey(digitSum)) {
                ans = Math.max(ans, num + dic.get(digitSum));
            }

            dic.put(digitSum, Math.max(dic.getOrDefault(digitSum, 0), num));
        }

        return ans;
    }

    public int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
