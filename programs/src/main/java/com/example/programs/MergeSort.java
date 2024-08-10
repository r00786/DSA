package com.example.programs;

public class MergeSort {
    public static void main(String[] args) {
        int[] unsorted= new int[]{4,5,6,12,1,4};
        new MergeSort().mergeSort(unsorted);
        for (int i : unsorted) {
            System.out.print(i+",");
        }
    }

    public void mergeSort(int[] arr){
        if(arr.length>1){
            int mid=arr.length/2;
            int[] left= new int[mid];
            int[] right= new int[arr.length-mid];
            for(int i=0;i<mid;i++){
                left[i]=arr[i];
            }
            for(int i=mid;i<arr.length;i++){
                right[i-mid]=arr[i];
            }
            mergeSort(left);
            mergeSort(right);
            merge(arr,left,right);
        }



    }
    public void merge(int[] result,int[] left,int[] right){
        int i=0;
        int j=0;
        int k=0;
        while (i<left.length&&j<right.length){
            if(left[i]<right[j]){
                result[k]=left[i];
                i++;
            }else{
                result[k]=right[j];
                j++;
            }
            k++;
        }
        while (i<left.length){
            result[k]=left[i];
            k++;
            i++;
        }

        while (j<right.length){
            result[k]=right[j];
            k++;
            j++;
        }

    }
}
