package com.finance.jackie.mddemo.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Jackie on 2018/7/23.
 * https://mp.weixin.qq.com/s/DEJ8SYvH-WuIX4PPvqk0Ow
 * 两个栈实现一个队列
 * 1.无论如果 StackA（最开始add元素的那个栈） 要往 StackB 中压入元素，那么必须选择一次性全部压入。
 * 2.无论什么时候从队列中取元素，必须保证元素是从 StackB 中 pop 出的，
 *  也就是说，当 StackB 不为空的时候绝不能再次向 StackB 中压入元素。
 */
public class TwoStackQueue {


    public static void main(String[] args){
        TwoStackQue<String> twoStackQue = new TwoStackQue<>();
        twoStackQue.add("1");
        twoStackQue.add("2");
        twoStackQue.add("3");
        twoStackQue.poll();  //取出1
        twoStackQue.add("4");
        twoStackQue.add("5");
        for (int i = 0;i< 4;i++){
            System.out.println(twoStackQue.poll());
        }

    }

    public static class TwoStackQue<E>{
        private Stack<E> stackA;
        private Stack<E> stackB;

        public TwoStackQue(){
            stackA = new Stack<>();
            stackB = new Stack<>();
        }

        public boolean add(E e){
            stackA.push(e);
            return true;
        }

        //返回队列中的元素
        public E poll(){
            if (stackB.isEmpty() && stackA.isEmpty()){
                return null;
            }
            if (stackB.isEmpty()){
                while (!stackA.isEmpty()){
                    stackB.push(stackA.pop());
                }
            }
            return stackB.pop();
        }

        //返回队列的头元素，不取出值
        public E peek(){
            if (stackB.isEmpty() && stackA.isEmpty()){
                return null;
            }
            if (stackB.isEmpty()){
                while (!stackA.isEmpty()){
                    stackB.push(stackA.pop());
                }
            }
            return stackB.peek();

        }




    }











}
