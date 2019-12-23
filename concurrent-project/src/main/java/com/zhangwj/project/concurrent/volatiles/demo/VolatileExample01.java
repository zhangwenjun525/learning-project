package com.zhangwj.project.concurrent.volatiles.demo;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName VolatileExample01
 * @Date 2019/12/23 22:37
 * @Author zhangwj
 * @Version 1.0
 */
public class VolatileExample01 {

    private static final int MAX_VALUE = 5;

    private static int initValue = 0;

    /*    private static volatile int initValue = 0;*/

    public static void main(String[] args) {

        new Thread(() -> {
            int localValue = initValue;

            while (localValue < MAX_VALUE) {
                if (localValue != initValue) {
                    localValue = initValue;
                    System.out.println("Reader:" + localValue);
                }
            }
        }, "Reader").start();

        new Thread(() -> {

            int localValue = initValue;

            while (true) {
                if (localValue < MAX_VALUE) {
                    try {
                        TimeUnit.MICROSECONDS.sleep(2000);
                        localValue++;
                        System.out.println("Writer:" + localValue);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    initValue = localValue;
                }
            }
        }, "Writer").start();


    }


}
