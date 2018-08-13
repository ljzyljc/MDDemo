package com.finance.jackie.mddemo;

/**
 * Created by Jackie on 2018/7/24.
 */
public class BinarySerarch {

    static int[] arr = {1,2,6,8,11,23,55,88,4411};

    public static void main(String[] args){
        int a = binarySearch(arr,0);
        System.out.println(a);
    }

    //二分查找
    public static int binarySearch(int[] arr,int value){
        if (arr == null || arr.length < 2){
            return -1;
        }
        int first = 0;
        int last = arr.length - 1;

        while (first <= last){
            int mid = (last - first) >> 1;
            if (value > arr[mid]){
                first = mid + 1;
            }else if (value < arr[mid]){
                last = mid - 1;
            }else{
                return mid;
            }
        }
        return ~first;


    }



//    static int binarySearch(int[] array, int size, int value) {
//        int lo = 0;
//        int hi = size - 1;
//
//        while (lo <= hi) {
//            final int mid = (lo + hi) >>> 1;
//            final int midVal = array[mid];
//
//            if (midVal < value) {
//                lo = mid + 1;
//            } else if (midVal > value) {
//                hi = mid - 1;
//            } else {
//                return mid;  // value found
//            }
//        }
//        return ~lo;  // value not present
//    }
}
