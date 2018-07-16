package com.finance.jackie.mddemo;

import java.util.Arrays;

public class BubbleSort {
    static int[] a = new int[]{3,1,8,5,2,66};

    public static void main(String[] args){
        bubbleShort(a);

    }

    public static void bubbleShort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        int length = arr.length;
        for (int end = length - 1;end > 0;end--){
            for (int i = 0;i < end ;i++){
                if (arr[i]>arr[i+1]){
                    swap(arr,i,i+1);
                }
            }
        }
        System.out.print(Arrays.toString(a));

    }


    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
