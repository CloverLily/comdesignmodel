package DesignModel.FactoryMethod.CommonFactory;

/**
 * 普通工厂模式
 */
public class FactoryTest {

    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produce("sms");
        sender.send();
    }
}