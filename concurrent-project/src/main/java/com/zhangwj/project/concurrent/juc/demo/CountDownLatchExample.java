package com.zhangwj.project.concurrent.juc.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CountDownLatchExample
 * @Date 2019/12/24 17:43
 * @Author zhangwj
 * @Version 1.0
 */
public class CountDownLatchExample {

    private static List<String> companyNameList = Arrays.asList("东方航空", "南方航空", "海南航空");

    private static List<String> fightList = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        String source = "BJ";
        String target = "SH";

        CountDownLatch countDownLatch = new CountDownLatch(companyNameList.size());
        for (int i = 0; i < companyNameList.size(); ++i) {
            String companyName = companyNameList.get(i);
            new Thread(() -> {
                System.out.println(String.format("%s从%s到%s的机票", companyName, source, target));

                int ticketCount = new Random().nextInt(5);

                try {
                    TimeUnit.SECONDS.sleep(ticketCount);
                    fightList.add(companyName + "--" + ticketCount);
                    System.out.println(String.format("%s 公司查询成功", companyName));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            }).start();
        }

        countDownLatch.await();

        System.out.println("=====================================");

        System.out.println(fightList);


    }

}
