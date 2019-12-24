package com.zhangwj.project.concurrent.singleton.demo;

/**
 * 懒汉式(同步方法实现)
 *
 * @ClassName LazySingleton
 * @Date 2019/12/24 11:23
 * @Author zhangwj
 * @Version 1.0
 */
public class LazySingleton {

    private static LazySingleton instance;

    public static synchronized LazySingleton getInstance() {
        if (null == instance) {
            instance = new LazySingleton();
        }

        return instance;
    }

    private LazySingleton() {

    }
}
