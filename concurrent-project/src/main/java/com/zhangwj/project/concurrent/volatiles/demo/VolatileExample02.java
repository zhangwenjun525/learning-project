package com.zhangwj.project.concurrent.volatiles.demo;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName VolatileExample02
 * @Date 2019/12/23 23:36
 * @Author zhangwj
 * @Version 1.0
 */
public class VolatileExample02 {

    private static volatile int number = 0;

    public static synchronized void incr() {
        number++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; ++i) {

            new Thread(() -> {
                for (int j = 0; j < 5; ++j) {
                    incr();
                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(1);

        System.out.println("number = " + number);

    }

}
