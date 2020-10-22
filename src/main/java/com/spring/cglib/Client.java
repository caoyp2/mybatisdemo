package com.spring.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

public class Client {
    public static void main(String[] args) {
        final Producer producer = new Producer();

        /**
         * 使用cglib第三方库实现动态代理
         *  class:代理对象的class
         *  callback:需要代理增强的具体实现
         *
         */
        Producer cglibProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                float money = 0;
                if("saleProducer".equals(method.getName())){
                    money = (Float) objects[0];
                    money = money * 0.8f;
                }
                return method.invoke(producer,money);
            }
        });
        cglibProducer.saleProducer(1000);
    }
}
