package com.zhangwj.project.concurrent.juc.demo;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName SemaphoreExample
 * @Date 2019/12/24 18:40
 * @Author zhangwj
 * @Version 1.0
 */
public class SemaphoreExample {

    private final static int threadCount = 20;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < threadCount; ++i) {
            int threadNum = i;

            executorService.execute(() -> {
                //获取一个许可
                try {
                    semaphore.acquire();
                    test(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
        }

        executorService.shutdown();
    }

    private static void test(int threadNum) throws Exception {
        System.out.println(threadNum);
        TimeUnit.SECONDS.sleep(new Random().nextInt(10));
    }
}
