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

        int a[] = {49, 38, 65, 97, 76, 13,49, 27, 49};
//        quickSort(a);
        sort2(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
        System.out.println("-----彻底消化--1--");
    }

    public static void sort(int[] arr, int low, int high) {

        if (low > high) {
            return;
        }
        int i = low;
        int j = high;
        int index = arr[low];

        while (i < j) {
            while (i < j && arr[j] >= index) {
                j--;
            }
            if (i < j) {
                arr[i++] = arr[j];
            }
            while (i < j && arr[i] < index) {
                i++;
            }
            if (i < j) {
                arr[j--] = arr[i];
            }

        }
        arr[i] = index;
        sort(arr, low, i - 1);
        sort(arr, i + 1, high);

    }

    public static int getMiddle(int[] arr, int low, int high) {
        int temp = arr[low];
        while (low < high) {
            if (low < high && arr[low] < temp) {
                low++;
            }
            if (low < high) {
                arr[high--] = arr[low];
            }
            if (low < high && arr[high] >= temp) {
                high--;
            }
            if (low < high) {
                arr[low++] = arr[high];
            }

        }
        arr[low] = temp;
        return low;
    }
    //利用荷兰国旗优化和随机数的方式优化
    public static void sort2(int[] arr,int low,int high){
//        int mid = getMiddle(arr,low,high);
//        sort(arr,0,mid - 1);
//        sort(arr,mid + 1,high);
        if (low < high) {
            swap(arr, (int)( low + Math.random() * (high - low + 1)), high);
            int[] dd = partation(arr, low, high);
            System.out.println(Arrays.toString(dd));
            sort2(arr, low, dd[0] - 1);
            sort2(arr, dd[1] + 1, high);
        }
    }


    public static int[] partation(int[] arr,int low,int high){
        int topEnd = low;
        int end = high;
        int mid = arr[high];  //以最后一个数为基准，小于这个数在前，大于这个数的在后面
        int current = low;

        while (current <= end){
            int currentNum = arr[current];
            if (currentNum > mid){
                swap(arr,current,end);
                end--;
            }else if (currentNum < mid){
                swap(arr,current,topEnd);
                topEnd++;
                current++;
            }else{
                current++;
            }
        }
//        swap(arr,end-1,high);
        return new int[]{topEnd,current - 1};
//        int less = l -1;
//        int more = r;
//        while (l < more){
//            if (arr[l] < arr[r]){
//                swap(arr,++less,l++);
//            }else if (arr[l]> arr[r]){
//                swap(arr,--more,l);
//            }else{
//                l++;
//            }
//        }
//        swap(arr,more,r);
//        return new int[]{less + 1,more};
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}