package com.zhangwj.project.concurrent.cas.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName CasExample01
 * @Date 2019/12/24 14:34
 * @Author zhangwj
 * @Version 1.0
 */
public class CasExample01 {

    private static volatile int number = 0;

    private static volatile AtomicInteger atomicInteger = new AtomicInteger(0);


    public static void increase() {
        number++;
        atomicInteger.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 200; ++i) {
            new Thread(() -> {
                increase();
            }).start();
        }

        TimeUnit.SECONDS.sleep(1);

        System.out.println(number);
        System.out.println(atomicInteger.get());
    }

}
