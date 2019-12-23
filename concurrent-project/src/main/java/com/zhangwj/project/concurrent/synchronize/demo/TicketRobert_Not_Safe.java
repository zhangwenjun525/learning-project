package com.zhangwj.project.concurrent.synchronize.demo;

import java.util.concurrent.TimeUnit;

/**
 * 机器叫号系统(非线程安全版本)
 *
 * @ClassName TicketRobert_Not_Safe
 * @Date 2019/12/23 16:26
 * @Author zhangwj
 * @Version 1.0
 */
public class TicketRobert_Not_Safe implements Runnable {

    private int index = 1;

    private static final int MAX_INDEX = 50;

    @Override
    public void run() {
        while (index <= MAX_INDEX) {
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "叫到号码是：" + (index++));
        }
    }

    public static void main(String[] args) {
        TicketRobert_Not_Safe ticketRobert = new TicketRobert_Not_Safe();
        for (int i = 0; i < 5; ++i) {
            new Thread(ticketRobert, "叫号机" + (i + 1)).start();
        }
    }
}
