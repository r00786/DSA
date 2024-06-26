package com.example.programs;

class SquareSort {
    public int[] sortedSquares(int[] nums) {

        int negativeArrayEndIndex=0;
        for(int i = nums.length-1;i>=0;i--){
            if(nums[i]<0){
                negativeArrayEndIndex=i;
                break;
            }

        }
        int endPointer=negativeArrayEndIndex+1;
        int[] newArr=new int[nums.length];
        int newArrPos=0;
        while(negativeArrayEndIndex>=0&&endPointer<nums.length){
            if((-nums[negativeArrayEndIndex])<nums[endPointer]){
                int number = -nums[negativeArrayEndIndex];
                newArr[newArrPos]=number*number;
                negativeArrayEndIndex-=1;
            }else{
                newArr[newArrPos]=nums[endPointer]*nums[endPointer];
                endPointer+=1;
            }
            newArrPos+=1;

        }
        while(negativeArrayEndIndex>=0){
            int number = -nums[negativeArrayEndIndex];
            newArr[newArrPos]=number*number;
            negativeArrayEndIndex-=1;
            newArrPos+=1;
        }
        while(endPointer<nums.length){
            newArr[newArrPos]=nums[endPointer]*nums[endPointer];
            endPointer+=1;
            newArrPos+=1;
        }

        return newArr;

    }

}
