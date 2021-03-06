package DesignModel_23.StructuralModel_7._9Facade;

/**
 * 我们以一个计算机的启动过程为例
 * 用户通过Computer类使用CPU、Memory、Disk类
 */
public class User {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startUp();
        computer.shutdown();
    }
}
/**
 * 如果我们没有Computer类，那么，CPU、Memory、Disk他们之间将会相互持有实例，产生关系，这样会造成严重的依赖，
 * 修改一个类，可能会带来其他类的修改，这不是我们想要看到的，有了Computer类，他们之间的关系被放在了Computer类里，这样就起到了解耦的作用，这，就是外观模式！
 */
