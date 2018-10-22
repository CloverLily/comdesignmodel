package DesignModel.FactoryMethod.CommonFactory;

  class CommonSendFactory {

     Sender produce(String type) {
        if ("mail".equals(type)) {
            return new MailSender();
        } else if ("sms".equals(type)) {
            return new SmsSender();
        } else {
            System.out.println("Please input correct type~");
            return null;
        }
    }


}