package com.zhangwj.project.concurrent.juc.demo;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CyclicBarrierExample
 * @Date 2019/12/24 18:04
 * @Author zhangwj
 * @Version 1.0
 */
public class CyclicBarrierExample {

    private static final int threadCount = 10;

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(threadCount);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < threadCount; ++i) {
            executorService.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(new Random().nextInt(10));
                    System.out.println(Thread.currentThread().getName() + "准备好了");
                    barrier.await();
                    System.out.println(Thread.currentThread().getName() + "起跑");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();
    }
}
