package com.spring.aop;

public class Producer implements IProducer {
    public int saveAccount() {
        System.out.println("保存成功");
        return 1;
    }

    public void updateAccount(int id) {
        System.out.println("更新成功");
    }

    public void deleteAccount() {
        System.out.println("删除成功");
    }
}
