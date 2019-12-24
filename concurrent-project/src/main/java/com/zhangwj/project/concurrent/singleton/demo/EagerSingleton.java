package com.zhangwj.project.concurrent.singleton.demo;

/**
 * 饿汉式单例模式
 *
 * @ClassName EagerSingleton
 * @Date 2019/12/24 11:13
 * @Author zhangwj
 * @Version 1.0
 */
public class EagerSingleton {

    private static final EagerSingleton INSTANCE = new EagerSingleton();

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }

    private EagerSingleton() {

    }
}
