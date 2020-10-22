package com.spring.activeproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        final Producer producer = new Producer();

        /**
         * 使用动态代理增强销售方法
         * classLoader: 需要代理类的类加载器
         * interface:需要代理类实现的接口
         * InvocationHandler：代理增强的实现
         */
        IProducer iProducer = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        float money = 0;
                        if("saleProducer".equals(method.getName())){
                            money = (Float) args[0];
                            money = money * 0.8f;
                        }
                        return method.invoke(producer,money);
                    }
                });
        iProducer.saleProducer(1000);
    }
}
