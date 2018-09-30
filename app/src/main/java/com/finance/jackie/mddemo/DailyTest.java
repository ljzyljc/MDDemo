package com.finance.jackie.mddemo;

/**
 * Created by Jackie on 2018/9/29.
 */
public class DailyTest {
    static int[] mSui = {-5,2,7,3,8,1,0,-7,85};
    static int[] mArray = {9,12,15,23,333,3211};

    static int[] mTestArray = {6,-3,-2,7,-15,1,2,2};
    public static void main(String[] args){
//        int a  = binarySort(mArray,15);
//        System.out.println("------"+a);

//        Node node = initNode();
//        Node reverseNode = reverse(node);
//        while (reverseNode!= null){
//            System.out.println(reverseNode.data);
//            if (reverseNode.next != null) {
//                reverseNode = reverseNode.next;
//            }else {
//                break;
//            }
//        }

//        quickSort(mSui,0,mSui.length - 1);
//        for (int i = 0;i<mSui.length;i++){
//            System.out.println(mSui[i]);
//        }

//        Node node = initNode();
//        Node node1 = getNode(2,node);
//        System.out.println("-----"+node1.data);

        int m = FindGreatestSumOfSubArray(mTestArray);
            System.out.println("-----"+m);
    }

    //输入两个链表，找出他们的公共节点
    public static Node FindFirstCommonNode(Node one,Node two){
        Node first = one;
        Node second = two;
        while (first != second){
            first = (first == null ? two : first.next);
            second = (second == null ? one : second.next);
        }
        return first;
    }



    //求最大连续子数组的,采用动态规划的方式，时间复杂度O（n）
    public static int FindGreatestSumOfSubArray2(int[] array) {
        int max = array[0];
        int res = array[0];
        for(int i = 1;i < array.length;i++){
            max = Math.max(max + array[i],array[i]);
            res = Math.max(res,max);
        }
        return res;
    }



    //求最大连续子数组的     O(n2)算法
    public static int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length < 1){
            return 0;
        }
        int sum;
        int total = 0;
        for(int i = 0;i<array.length;i++){
            sum = 0;
            for(int j = i;j<array.length;j++){
                sum = sum + array[j];
                if(sum > total){
                    total = sum;
                }
            }

        }
        return total;
    }



    //获取链表的倒数第K个节点
    public static Node getNode(int k,Node head){
        Node first = head;
        Node second = head;
        for(int i = 0;i< k - 1;i++){
            if (first.next != null) {
                first = first.next;
            }else {
                return null;
            }
        }
        while (first.next != null){
            first = first.next;
            second = second.next;
        }
        return second;
    }






    //快速排序
    public static void quickSort(int[] arr,int low,int high){
        if (arr == null || arr.length < 2){
            return;
        }
        sort(arr,0,arr.length - 1);
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
            if (i < j){
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
        sort(arr,low,i-1);
        sort(arr,i + 1,high);
    }


    //二分法排序
    public static int binarySort(int[] arr,int value){
        if (arr == null || arr.length < 2 ){
            return -1;
        }
        int first = 0;
        int last = arr.length - 1;
        while (first <= last){
            int mid = (first + last) >> 1;
            if (arr[mid] > value){
                first = mid + 1;
            }else if (arr[mid] < value){
                last = mid - 1;
            }else{
                return mid;
            }

        }
        return -1;
    }
    public static Node initNode(){
        Node head = new Node(1);
        Node one = new Node(2);
        Node two = new Node(3);
        Node three = new Node(4);

        head.next = one;
        one.next = two;
        two.next = three;
        return head;
    }

    //单链表反转
    public static Node reverse(Node head){
        Node prev = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static class Node{
        public Node next;
        public int data;
        public Node(int data){
            this.data = data;
        }
    }

}
