package com.finance.jackie.mddemo;

import java.util.Arrays;

/**
 * Created by Jackie on 2018/7/18.
 * 快速排序优化
 */
public class QuickSortPlus {

    public static void quickSort(int a[]) {
        sort(a, 0, a.length - 1);
    }


    public static void main(String[] args) {

        int a[] = { 49, 38, 65, 97, 76, 13, 27, 49 };
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }
    public static void sort(int[] arr,int low,int high){
        if (low < high) {
            int[] p = partition(arr, low, high);
            sort(arr, low, p[0] - 1);
            sort(arr, p[1] + 1, high);
        }

    }
    public static int[] partition(int[] arr,int l,int r){
        int less = l -1;
        int more = r;
        while (l < more){
            if (arr[l] < arr[r]){
                swap(arr,++less,l++);
            }else if (arr[l]> arr[r]){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        swap(arr,more,r);
        return new int[]{less + 1,more};
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
