package com.finance.jackie.mddemo;

import java.util.Arrays;

public class NetherlandsFlag {

    static int[] a = new int[]{3,1,8,5,0,2};

    public static void main(String[] args){

        int[] aa = partition(a,0,a.length-1,2);
        System.out.print(Arrays.toString(a));
        System.out.print(Arrays.toString(aa));

    }

    public static int[] partition(int[] arr,int L,int R,int num){
        int less = L - 1;
        int more = R + 1;
        while(L < more){
            if (arr[L] < num){
                swap(arr,++less,L++);
            }else if (arr[L] > num){
                swap(arr,--more,L);
            }else{
                L++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return new int[]{less + 1,more -1};  //返回的是等于区域是从哪到哪的,以后有用

    }




    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
