package com.zhangwj.project.concurrent.aqs.demo;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName MyLockDemo
 * @Date 2019/12/24 17:11
 * @Author zhangwj
 * @Version 1.0
 */
public class MyLockDemo {

    private int number = 0;

    private MyLock lock = new MyLock();

    public void increase() {
        try {
            lock.lock();
            TimeUnit.MICROSECONDS.sleep(10);
            number++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyLockDemo demo = new MyLockDemo();

        for (int i = 0; i < 20; ++i) {
            new Thread(() -> {
                demo.increase();
            }).start();
        }

        TimeUnit.SECONDS.sleep(2);

        System.out.println(demo.number);
    }
}
