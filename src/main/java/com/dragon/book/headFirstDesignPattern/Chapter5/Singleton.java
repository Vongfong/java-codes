package com.dragon.book.headFirstDesignPattern.Chapter5;

/**
 * Created with IntelliJ IDEA.
 * User: dsy30
 * Date: 2018/3/11
 * 单例模式的懒加载实现
 */
public class Singleton {
    /**
     * 一种错误的单例写法，线程不安全
     */
/*    private static Singleton uniqueSingleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (uniqueSingleton == null) {
            uniqueSingleton = new Singleton();
        }

        return uniqueSingleton;
    }*/

    /**
     * 线程安全的懒加载，影响效率，JVM不保证执行顺序
     */
/*    private static Singleton uniqueSingleton;

    private Singleton() {

    }

    public static synchronized Singleton getInstance() {
        if (uniqueSingleton == null) {
            uniqueSingleton = new Singleton();
        }

        return uniqueSingleton;
    }*/

    /**
     * 急加载模式又名饿汉式,线程安全，代码简单
     */
/*    private final static Singleton singleton = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {
        return singleton;
    }*/

    /**
     * 懒加载，双重锁保证，线程安全
     */
/*    private static volatile Singleton singleton;

    private Singleton() {
    }

    private static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    return new Singleton();
                }
            }
        }
        return singleton;
    }*/

    /**
     * 懒加载的内部类写法，线程安全，懒加载
     */
    private static class SingletonHolder {
        private final static Singleton singleton = new Singleton();
    }

    private Singleton() {
    }

    public static Singleton getInstance() {
        return SingletonHolder.singleton;
    }


}
