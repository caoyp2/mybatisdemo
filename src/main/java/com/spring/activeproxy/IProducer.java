package com.spring.activeproxy;

public interface IProducer {

    /**
     * 通过销售代理商售卖
     * @param money
     */
    public void saleProducer(float money);

    /**
     * 通过厂家直接售卖
     * @param money
     */
    public void originProducer(int money);

}
