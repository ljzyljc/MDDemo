package com.finance.jackie.mddemo;

public class TestDigui {

    public static int getMax(int[] arr,int L,int R){
        if (L == R){
            return arr[L];
        }
        System.out.println("---------------");
        int mid = (L + R)/2;
        int maxLeft = getMax(arr,L,mid);
        int maxRight = getMax(arr,mid+1,R);
        return Math.max(maxLeft,maxRight);


    }

    public static void main(String[] args){
        int[] arr = {0,4,3,2,1};
        int a = getMax(arr,0,arr.length - 1);
        System.out.println("---------------"+a);
    }


}
