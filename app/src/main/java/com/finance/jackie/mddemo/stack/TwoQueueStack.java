package com.finance.jackie.mddemo.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Jackie on 2018/7/23.
 */
public class TwoQueueStack {

    public static void main(String[] args) {
        TwoQueueSta<String> twoQueueSta = new TwoQueueSta<>();
        twoQueueSta.push("A");
        twoQueueSta.push("B");
        twoQueueSta.push("C");
        twoQueueSta.push("D");
        twoQueueSta.pop();
        twoQueueSta.push("E");
        twoQueueSta.push("F");
        twoQueueSta.pop();
        twoQueueSta.pop();
    }


    public static class TwoQueueSta<E>{
        private Queue<E> queueA;
        private Queue<E> queueB;

        public TwoQueueSta(){
            queueA = new LinkedList<>();
            queueB = new LinkedList<>();
        }

        //选一个非空的队列入队
        public E push(E e){
            if (queueA.size() != 0){
                queueA.add(e);
                System.out.println("从queueA入队"+e);
            }else if (queueB.size() != 0){
                queueB.add(e);
                System.out.println("从queueB入队"+e);
            }else{
                System.out.println("从queueA入队---"+e);
                queueA.add(e);
            }
            return e;
        }

        public E pop(){
            if (queueA.size() == 0 && queueB.size() == 0){
                return null;
            }
            E result = null;
            if (queueA.size() != 0){
                while (queueA.size() > 0){
                    result = queueA.poll();
                    if (queueA.size() != 0){
                        System.out.println("从queueA出队-并queueB入队--"+result);
                        queueB.add(result);
                    }
                }
                System.out.println("从queueA出队----------"+result);

            }else{
                while (queueB.size() > 0){
                    result = queueB.poll();
                    if (queueB.size() != 0){
                        System.out.println("从queueB出队-并queueA入队--"+result);
                        queueA.add(result);
                    }
                }
                System.out.println("从queueB出队----------"+result);

                }
                return result;
            }










    }
}
