package DesignModel_23.CreatedModel_5._2AbstractFactory.sender.impl;

import DesignModel_23.CreatedModel_5._2AbstractFactory.sender.Sender;

public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("This is MailSender~");
    }
}
