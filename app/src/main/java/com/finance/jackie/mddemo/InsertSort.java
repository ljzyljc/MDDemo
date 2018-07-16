package com.finance.jackie.mddemo;

public class InsertSort {

    static int[] a = new int[]{3,1,8,5,2,66};

    public static void main(String[] args){
        insertSort(a);

    }

    public static void insertSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 1;i < arr.length;i++){
            //如果后面的小于前面的，就交换
            for (int j = i - 1;j > 0 && arr[j] > arr[j+1];j--){
                swap(arr,j,j+1);
            }
        }



    }


    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
