package com.zhangwj.project.concurrent.collection.demo;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @ClassName ConcurrentLinkedDequeExample
 * @Date 2019/12/25 0:15
 * @Author zhangwj
 * @Version 1.0
 */
public class ConcurrentLinkedDequeExample {

    public static void main(String[] args) throws InterruptedException {

        ConcurrentLinkedDeque<Integer> deque = new ConcurrentLinkedDeque<>();

        Thread[] addArray = new Thread[100];
        for (int i = 0; i < 100; ++i) {
            addArray[i] = new Thread(() -> {
                for (int j = 0; j < 10000; ++j) {
                    deque.add(j);
                    System.out.println(Thread.currentThread().getName() + "add element :" + j);
                }
            }, "add" + i);

            addArray[i].start();
            addArray[i].join();
        }

        System.out.println("after add size:" + deque.size());


        Thread[] pollArray = new Thread[100];
        for (int i = 0; i < 100; ++i) {
            pollArray[i] = new Thread(() -> {
                for (int j = 0; j < 5000; ++j) {
                    Integer last = deque.pollLast();
                    System.out.println(Thread.currentThread().getName() + "poll last element :" + last);
                    Integer first = deque.pollFirst();
                    System.out.println(Thread.currentThread().getName() + "poll first element :" + first);
                }
            }, "poll" + i);

            pollArray[i].start();
            pollArray[i].join();
        }

        System.out.println("after poll size:" + deque.size());


    }

}
