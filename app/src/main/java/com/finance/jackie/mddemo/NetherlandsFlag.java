package com.finance.jackie.mddemo;

import java.util.Arrays;

public class NetherlandsFlag {

    static int[] a = new int[]{3,1,8,5,0,2,33,2,4,3,2};
    static int[] bb = new int[]{10, -2, 5, 8, -4, 2, -3, 7, 12, -88, -23, 35};
    public static void main(String[] args){

//        int[] aa = partition(a,0,a.length-1,2);
        int[] aa = partition(bb,2);
        System.out.print(Arrays.toString(bb));
        System.out.print(Arrays.toString(aa));

    }

//    public static int[] partition(int[] arr,int L,int R,int num){
//        int less = L - 1;
//        int more = R + 1;
//        while(L < more){
//            if (arr[L] < num){
//                swap(arr,++less,L++);
//            }else if (arr[L] > num){
//                swap(arr,--more,L);
//            }else{
//                L++;
//            }
//        }
//        System.out.println(Arrays.toString(arr));
//        return new int[]{less + 1,more -1};  //返回的是等于区域是从哪到哪的,以后有用
//
//    }




    //easy way,for menmory
    public static int[] partition(int[] arr,int num){
        int topEnd = 0;
        int end = arr.length - 1;
        int current = 0;
        while (current <= end){
            int nowNum = arr[current];
            if (nowNum < num){
                swap(arr,current,topEnd);
                topEnd++;
                current++;
            }else if (nowNum > num){
                swap(arr,current,end);
                end--;
            }else{
                current++;
            }

        }
        return new int[]{topEnd,current-1};


    }





    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
