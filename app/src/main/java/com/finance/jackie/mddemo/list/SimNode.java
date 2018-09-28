package com.finance.jackie.mddemo.list;

/**
 * Created by Jackie on 2018/9/28.
 */
public class SimNode {

    public static void main(String[] args){
        SimNode head = new SimNode(1);
        SimNode one = new SimNode(2);
        SimNode two = new SimNode(3);
        SimNode three = new SimNode(4);

        head.next = one;
        one.next = two;
        two.next = three;
//        SimNode node = reverse1(head);
        SimNode node = reverse2(head);
        SimNode current = node;
        while (current != null){
            System.out.println("----"+current.data);
            current = current.next;
        }

    }
    //循环实现反转链表
    public static SimNode reverse1(SimNode head){
        SimNode prev = null;
        SimNode next = null;

        while (head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    //递归实现反转链表
    public static SimNode reverse2(SimNode head){
        if (head == null || head.next == null){
            return head;
        }
        SimNode reHead = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return reHead;

    }




    protected SimNode next;
    public int data;

    public SimNode(int data) {
        this.data = data;
    }
    public void display(){
        System.out.println(data + " ");
    }
}
