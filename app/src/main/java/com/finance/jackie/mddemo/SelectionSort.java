package com.finance.jackie.mddemo;

import java.util.Arrays;

public class SelectionSort {
    static int[] a = new int[]{3,1,8,5,2,66};
    public static void main(String[] args){
//        selectionSort(a);
        SelectionSort(a);
        System.out.print(Arrays.toString(a));
    }

//    public static void selectionSort(int[] arr){
//        if (arr == null || arr.length < 2){
//            return;
//        }
//        for (int i = 0;i < arr.length - 1;i++){
//            int mIndex = i;
//            //2和2到最后一位上最小的数交换
//            for (int j = i + 1;j < arr.length;j++){
//                mIndex = arr[j] < arr[mIndex] ? j :mIndex;
//            }
//            swap(arr,i,mIndex);
//        }
//
//    }

    public static void SelectionSort(int[] arr){
        for (int i = 0;i < arr.length - 1;i++){
                int mIndex = i;
                //2和2到最后一位上最小的树交换
            for (int j = mIndex + 1;j < arr.length;j++){  //3 1 8 5 2 66
                mIndex = arr[mIndex] > arr[j] ? j : mIndex;
            }
            swap(arr,i,mIndex);

        }

    }




    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}































