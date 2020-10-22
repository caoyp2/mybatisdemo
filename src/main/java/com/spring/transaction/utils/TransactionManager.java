package com.spring.transaction.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager {

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务
     */
    public void beginTransaction(){
        try {
            connectionUtils.getConnection().setAutoCommit(false);
            System.out.println("开启事务。。。。。。。");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *提交
     */
    public void commit(){
        try {
            connectionUtils.getConnection().commit();
            System.out.println("提交事务。。。。。。。");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚
     */
    public void rollback(){
        try {
            connectionUtils.getConnection().rollback();
            System.out.println("回滚事务。。。。。。。");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放资源
     */
    public void release(){
        try {
            connectionUtils.getConnection().close();
            connectionUtils.remove();
            System.out.println("释放连接。。。。。。。");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
