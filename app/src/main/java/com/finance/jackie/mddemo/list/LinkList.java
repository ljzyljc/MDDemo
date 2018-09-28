package com.finance.jackie.mddemo.list;

import java.util.LinkedList;

/**
 * Created by Jackie on 2018/9/28.
 * 单链表
 */
public class LinkList {

    public static void main(String[] args){
//        LinkList linkList = new LinkList();
//        linkList.addFirstNode(100);
////        linkList.addFirstNode(2);
////        linkList.addFirstNode(3);
//        linkList.add(1,200);
//        linkList.add(2,300);
//        linkList.displayAllNodes(linkList);

//        Node node = new Node(1);

    }


    public Node first;
    private int pos = 0;

    public LinkList(){
        this.first = null;
    }

    //添加头结点
    public void addFirstNode(int data){
        Node node = new Node(data);
        node.next = first;
        first = node;
    }

    //删除头结点，并返回头结点
    public Node deleteFirstNode(){
        Node node = first;
        first = first.next;
        return node;
    }

    //在index后面插入
    public void add(int index,int data){
        Node node = new Node(data);
        Node previous = first;
        Node current = first;
        while (pos != index){
            previous = current;
            current = current.next;
            pos++;
        }
        node.next = current;
        previous.next = node;
        pos = 0;
    }




    public void displayAllNodes(LinkList linkList){
        Node current = first;
        while (current != null){
            current.display();
            current = current.next;
        }

    }




    //FIXME：反转单列表节点----------循环实现
    public Node reverse1(Node node){
        Node prev = null;
        Node next = null;
        if (null != node){
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return node;
    }

    //单链表节点
    public class Node{
        protected Node next;
        public int data;

        public Node(int data) {
            this.data = data;
        }
        public void display(){
            System.out.println(data + " ");
        }




    }

}
