package com.zhangwj.project.concurrent.collection.demo;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName LinkedBlockingDequeExample
 * @Date 2019/12/25 0:25
 * @Author zhangwj
 * @Version 1.0
 */
public class LinkedBlockingDequeExample {

    public static void main(String[] args) {

        LinkedBlockingDeque<String> deque = new LinkedBlockingDeque<>(3);

        new Thread(() -> {
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 5; ++j) {
                    String str = new String(i + "" + j);
                    try {
                        deque.put(str);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("client:" + str + "|" + System.currentTimeMillis());
                }
            }
        }).start();

        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 3; ++j) {
                try {
                    String str = deque.take();
                    System.out.println("main take " + str + ", size = " + deque.size());

                    TimeUnit.MICROSECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("end");

    }
}
