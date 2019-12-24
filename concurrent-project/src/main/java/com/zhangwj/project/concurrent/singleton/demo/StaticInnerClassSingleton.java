package com.zhangwj.project.concurrent.singleton.demo;

/**
 * 静态内部类实现单例模式
 *
 * @ClassName StaticInnerClassSingleton
 * @Date 2019/12/24 11:47
 * @Author zhangwj
 * @Version 1.0
 */
public class StaticInnerClassSingleton {

    public static StaticInnerClassSingleton getInstance() {
        return SingletonHandler.INSTANCE;
    }

    private static class SingletonHandler {
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    private StaticInnerClassSingleton() {
    }
}
