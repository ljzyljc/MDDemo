package com.finance.jackie.mddemo;

import java.util.Arrays;

/**
 * Created by Jackie on 2018/7/18.
 */
public class QuickSort {


        public static void quickSort(int a[]) {
            sort(a, 0, a.length - 1);
        }


        public static void main(String[] args) {

            int a[] = { 49, 38, 65, 97, 76, 13, 27, 49 };
            quickSort(a);
            System.out.println(Arrays.toString(a));
        }
        public static void sort(int[] arr,int low,int high){

            if (low > high){
                return;
            }
            int i = low;
            int j = high;
            int index = arr[low];

            while (i < j){
                while (i < j && arr[j] >= index){
                    j--;
                }
                if (i < j) {
                    arr[i++] = arr[j];
                }
                while (i < j && arr[i] < index){
                    i++;
                }
                if (i < j){
                    arr[j--] = arr[i];
                }

            }
            arr[i] = index;
            sort(arr,low,i - 1);
            sort(arr,i + 1,high);

        }

































}
