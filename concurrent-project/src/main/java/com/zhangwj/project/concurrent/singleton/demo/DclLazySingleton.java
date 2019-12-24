package com.zhangwj.project.concurrent.singleton.demo;

/**
 * 懒加载(双重检测)
 *
 * @ClassName DclLazySingletion
 * @Date 2019/12/24 11:28
 * @Author zhangwj
 * @Version 1.0
 */
public class DclLazySingleton {

    private static volatile DclLazySingleton instance;

    public static DclLazySingleton getInstance() {
        if (null == instance) {
            synchronized (DclLazySingleton.class) {
                if (null == instance) {
                    instance = new DclLazySingleton();
                }
            }
        }
        return instance;
    }

    private DclLazySingleton() {

    }

}
