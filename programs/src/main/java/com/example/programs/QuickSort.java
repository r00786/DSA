package com.example.programs;

public class QuickSort {
    public static void main(String[] args) {
        int[] unsorted=new int[]{56,34,14,123,14,12};
        new QuickSort().quickSort(unsorted,0,unsorted.length-1);
        for (int i : unsorted) {
            System.out.print(i+",");
        }
    }



    public void quickSort(int arr[], int low, int high){
        if(low<high){
            int partition=partition(arr,low,high);
            quickSort(arr,low,partition-1);
            quickSort(arr,partition+1,high);
        }
    }
    public int partition(int[] arr,int low,int high){
        int pivot= arr[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<=pivot){
                i++;
                swap(arr,i,j);
            }

        }
        swap(arr,i+1,high);
        return i+1;

    }

    public void swap(int[] arr,int i,int j){
        int temp= arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
