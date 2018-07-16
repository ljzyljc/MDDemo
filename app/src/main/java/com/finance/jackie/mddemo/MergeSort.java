package com.finance.jackie.mddemo;

public class MergeSort {

    static int[] a = new int[]{3,1,8,5,2,66};
    public static void main(String[] args){
        mergeSort(a);

    }


    public static void mergeSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        sortProcess(arr,0,arr.length - 1);
    }

    public static void sortProcess(int[] arr,int L,int R){
        if (L == R){
            return;
        }
        int mid = L + ((R - L) >> 1);
        sortProcess(arr, L, mid);
        sortProcess(arr,mid + 1,R);


    }

    public static void merge(int[] arr,int L,int mid,int R){
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //两个之中必有且只有一个越界,然后把没越界的那个数组的剩下的值都赋给help
        while (p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= R){
            help[i++] = arr[p2++];
        }
        //把help里面的值都赋给arr
        for (i = 0;i < help.length;i++){
            arr[L+i] = help[i];
        }


    }

}
