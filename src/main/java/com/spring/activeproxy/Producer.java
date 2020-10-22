package com.spring.activeproxy;

public class Producer implements IProducer {
    public void saleProducer(float money) {
        System.out.println("通过代理商后能拿到前：" + money);
    }

    public void originProducer(int money) {
        System.out.println("厂家直销拿到的钱：" + money);
    }
}
