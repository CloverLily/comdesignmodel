package DesignModel_23.CreatedModel_5._3Singleton;

import java.util.Vector;

/**
 * 实际情况是，单例模式使用内部类来维护单例的实现，JVM内部的机制能够保证当一个类被加载的时候，这个类的加载过程是线程互斥的。
 * 这样当我们第一次调用getInstance的时候，JVM能够帮我们保证instance只被创建一次，并且会保证把赋值给instance的内存初始化完毕，
 * 这样我们就不用担心由创建对象和赋值操作命令分开进行而产生的问题。同时该方法也只会在第一次调用的时候使用互斥机制，这样就解决了低性能问题。
 * 这样我们暂时总结一个完美的单例模式：
 *
 * 目前最推荐的实现方式：（按需创建）
 */
 public class Singleton2 {
    /*私有构造方法，防止被实例化*/
    private Singleton2() {}

    //使用内部类来保护单例模式
    private static class SingletonFactory {
        private static Singleton2 instance = new Singleton2();
    }

    //获取实例
    public static Singleton2 getInstance() {
        return SingletonFactory.instance;
    }

    //如果该对象被用于序列化，可以保证对象在序列化前后保持一致
    public Object readResolve() {
        return getInstance();
    }
}


/**
 * 推荐的实现方式：利用静态特性
 * 但是会过早地创建实例，从而降低内存的使用效率。
 *
 */
class Singleton3{
    private  Singleton3(){}

    private static Singleton3 instance= new Singleton3();

    public static Singleton3 getInstance(){
        return instance;
    }

}

/**
 * 其实说Singleton2完美，也不一定，如果在构造函数中抛出异常，
 * 实例将永远得不到创建，也会出错。所以说，十分完美的东西是没有的，我们只能根据实际情况，选择最适合自己应用场景的实现方法。也有人这样实现：
 * 因为我们只需要在创建类的时候进行同步，所以只要将创建和getInstance()分开，单独为创建加synchronized关键字，也是可以的：
 */
class Singleton4 {
    private static Singleton4 instance = null;

    private Singleton4() {

    }

    private static synchronized void syncInit() {
        if (instance == null) {
            instance = new Singleton4();
        }
    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            syncInit();
        }
        return instance;
    }
}

//补充：采用"影子实例"的办法为单例对象的属性同步更新
class Singleton4_2 {
    private static Singleton4_2 instance = null;
    //属性列表
    private Vector properties = null;

    public Vector getProperties() {
        return properties;
    }

    private Singleton4_2() {

    }

    private static synchronized void syncInit() {
        if (instance == null) {
            instance = new Singleton4_2();
        }
    }

    public static Singleton4_2 getInstance() {
        if (instance == null) {
            syncInit();
        }
        return instance;
    }

    //同步更新属性
    public void updateProperties() {
        Singleton4_2 shadow = new Singleton4_2();
        properties = shadow.getProperties();
    }
}


