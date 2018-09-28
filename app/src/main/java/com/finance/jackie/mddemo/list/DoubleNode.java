package com.finance.jackie.mddemo.list;

/**
 * Created by Jackie on 2018/9/28.
 */
public class DoubleNode {

    public int data;
    public DoubleNode(int data){
        this.data = data;
    }
    public DoubleNode preNode;
    public DoubleNode nextNode;

    public static void main(String[] args){
        DoubleNode head = new DoubleNode(1);
        DoubleNode one = new DoubleNode(2);
        DoubleNode two = new DoubleNode(3);
        DoubleNode three = new DoubleNode(4);
        head.preNode = three;
        head.nextNode = one;
        one.preNode = head;
        one.nextNode = two;
        two.preNode = one;
        two.nextNode = three;
        three.preNode = two;
        three.nextNode = head;
//        DoubleNode current = reverse(head);
        DoubleNode current = reverse2(head);
        int i = 0;
        while (current != null){
            if (current.data == 1){
                if (i == 1){
                    return;
                }
                i = i+1;
            }
            System.out.println("----"+current.data);
            current = current.nextNode;
        }




    }
//    //递归实现
//    public static DoubleNode reverse2(DoubleNode head){
//        if(head == null || head.preNode == null || head.nextNode == null){
//            return head;
//        }
//        DoubleNode reHead = reverse2(head.nextNode);
//        head.nextNode.nextNode = head;
//        head.preNode = head.nextNode;
//        return reHead;
//    }

    //循环实现
    public static DoubleNode reverse(DoubleNode head){
        DoubleNode prev = null;
        DoubleNode next = null;
        while (head != null){
            next = head.nextNode;
            head.nextNode = prev;
            head.preNode = next;
            prev = head;
            head = next;
        }
        return prev;
    }



}
