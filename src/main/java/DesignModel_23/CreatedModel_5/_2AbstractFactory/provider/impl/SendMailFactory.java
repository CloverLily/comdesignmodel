package DesignModel_23.CreatedModel_5._2AbstractFactory.provider.impl;

import DesignModel_23.CreatedModel_5._2AbstractFactory.sender.impl.MailSender;
import DesignModel_23.CreatedModel_5._2AbstractFactory.provider.Provider;
import DesignModel_23.CreatedModel_5._2AbstractFactory.sender.Sender;

public class SendMailFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
